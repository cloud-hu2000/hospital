package com.example.hospital.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.hospital.dto.AuditDTO;
import com.example.hospital.dto.BackToFrontPrescription;
import com.example.hospital.dto.FrontToBackPrescription;
import com.example.hospital.entity.Drug;
import com.example.hospital.entity.MedicalRecord;
import com.example.hospital.entity.Prescription;
import com.example.hospital.entity.PrescriptionContent;
import com.example.hospital.mapper.*;
import com.example.hospital.dao.PrescriptionDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CloudHu
 * @since 2022-12-28
 */
@Service
public class PrescriptionDaoImpl extends ServiceImpl<PrescriptionMapper, Prescription> implements PrescriptionDao {

    @Autowired
    private PrescriptionMapper prescriptionMapper;


    @Autowired
    private PrescriptionContentMapper prescriptionContentMapper;

    @Autowired
    private DrugMapper drugMapper;

    @Autowired
    private MedicalRecordMapper medicalRecordMapper;

    @Override
    @Transactional
    public boolean addPrescription(FrontToBackPrescription frontToBackPrescription) {
        //插入药单记录
        Prescription prescription = frontToBackPrescription;
        prescriptionMapper.insert(prescription);
        //获取药单id
        QueryWrapper<Prescription> queryWrapper = new QueryWrapper();
        queryWrapper.eq("patient_id",prescription.getPatientId());
        List<Prescription> prescriptions = prescriptionMapper.selectList(queryWrapper);
        Integer prescriptionId = prescriptions.get(0).getId();
        //关联药单和药品
        List<Map<String, Integer>> drugList = frontToBackPrescription.getDrugs();
        for (Map<String, Integer> map : drugList) {
            Integer drugId = map.get("id");
            Integer count = map.get("count");
            PrescriptionContent prescriptionContent = new PrescriptionContent(prescriptionId, drugId, count);
            prescriptionContentMapper.insert(prescriptionContent);
        }
        return true;
    }

    @Override
    public BackToFrontPrescription checkPrescription(Integer prescriptionId) {
        //获取药单信息
        Prescription prescription = prescriptionMapper.selectById(prescriptionId);
        //组装药品信息
        BackToFrontPrescription backToFrontPrescription = new BackToFrontPrescription();
        backToFrontPrescription.setPrescription(prescription);
        QueryWrapper<PrescriptionContent> queryWrapper = new QueryWrapper();
        queryWrapper.eq("prescription_id",prescriptionId);
        List<PrescriptionContent> list = prescriptionContentMapper.selectList(queryWrapper);
        for (PrescriptionContent prescriptionContent : list) {
            //获取药品信息和数量
            Integer drugId = prescriptionContent.getDrugId();
            Drug drug = drugMapper.selectById(drugId);
            backToFrontPrescription.getDrugList().add(drug);
            backToFrontPrescription.getCountList().add(prescriptionContent.getCount());
        }
        return backToFrontPrescription;
    }

    @Override
    public boolean pay(Integer id) {
        return prescriptionMapper.pay(id)>0;
    }

    @Override
    public boolean receive(Integer id) {
        return prescriptionMapper.receive(id)>0;
    }

    @Override
    public boolean drugRefund(Integer prescriptionId) {
        Prescription prescription = prescriptionMapper.selectById(prescriptionId);
        //没有付款
        if(prescription.getIsPaid()<=0){
            return false;
        }
        //付款了但是已经拿了药
        if(prescription.getIsReceived()>0){
            return false;
        }
        //付款没拿药
        System.out.println("模拟支付退款接口");
        UpdateWrapper<Prescription> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",prescriptionId).set("is_refunded",1);
        prescriptionMapper.update(null,updateWrapper);
        return true;
    }

    @Override
    public boolean isPaid(Integer id) {
        return prescriptionMapper.selectById(id).getIsPaid()==1;
    }

    @Override
    public boolean isReceived(Integer id) {
        return prescriptionMapper.selectById(id).getIsReceived()==1;
    }

    @Override
    public boolean isDistributed(Integer id) {
        return prescriptionMapper.selectById(id).getIsDistributed()==1;
    }

    @Override
    public List<AuditDTO> getUnauditedPrescription() {
        List<AuditDTO> list= new ArrayList<>();
        QueryWrapper<Prescription> wrapper = new QueryWrapper<>();
        wrapper.eq("is_paid",1).eq("is_distributed",0);
        List<Prescription> prescriptionList = prescriptionMapper.selectList(wrapper);
        for (Prescription prescription : prescriptionList) {
            Integer patientId = prescription.getPatientId();
            QueryWrapper<MedicalRecord> queryWrapper = new QueryWrapper<>();
            wrapper.eq("patient_id",patientId);
            MedicalRecord medicalRecord = medicalRecordMapper.selectList(queryWrapper).get(0);
            BackToFrontPrescription backToFrontPrescription = checkPrescription(prescription.getId());
            list.add(new AuditDTO(medicalRecord,backToFrontPrescription));
        }
        return list;
    }
}
