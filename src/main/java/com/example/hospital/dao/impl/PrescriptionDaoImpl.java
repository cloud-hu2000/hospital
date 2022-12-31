package com.example.hospital.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hospital.dto.BackToFrontPrescription;
import com.example.hospital.dto.FrontToBackPrescription;
import com.example.hospital.entity.Drug;
import com.example.hospital.entity.Prescription;
import com.example.hospital.entity.PrescriptionContent;
import com.example.hospital.mapper.DrugMapper;
import com.example.hospital.mapper.PrescriptionContentMapper;
import com.example.hospital.mapper.PrescriptionMapper;
import com.example.hospital.dao.PrescriptionDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
