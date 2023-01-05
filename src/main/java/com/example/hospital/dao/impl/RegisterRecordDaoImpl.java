package com.example.hospital.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hospital.entity.AuditResult;
import com.example.hospital.entity.Patient;
import com.example.hospital.entity.RegisterRecord;
import com.example.hospital.mapper.PatientMapper;
import com.example.hospital.mapper.RegisterRecordMapper;
import com.example.hospital.dao.RegisterRecordDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CloudHu
 * @since 2022-12-28
 */
@Service
public class RegisterRecordDaoImpl extends ServiceImpl<RegisterRecordMapper, RegisterRecord> implements RegisterRecordDao {

    @Autowired
    RegisterRecordMapper registerRecordMapper;
    @Autowired
    PatientMapper patientMapper;
    public boolean addRecord(RegisterRecord registerRecord){
        return registerRecordMapper.insert(registerRecord)>0;
    }

    @Override
    public RegisterRecord checkRecord(int PatientId) {
        return registerRecordMapper.selectById(PatientId);
    }

    @Override
    public boolean hangUp(Integer id) {
        UpdateWrapper<RegisterRecord> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",id).set("is_hang_up",1);
        return registerRecordMapper.update(null,updateWrapper)>0;
    }

    @Override
    public boolean cancelHangUp(Integer recordId) {
        UpdateWrapper<RegisterRecord> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",recordId).set("is_hang_up",0);
        return registerRecordMapper.update(null,updateWrapper)>0;
    }

    @Override
    public boolean cancelRegister(Integer recordId) {
        UpdateWrapper<RegisterRecord> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",recordId).set("is_canceled",1);
        return registerRecordMapper.update(null,updateWrapper)>0;
    }



    @Override
    public List registerComplete(int recordId,int doctorId) {
        //更改
        UpdateWrapper<RegisterRecord> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",recordId).eq("is_hang_up",0).eq("is_paid",1).set("is_completed",1);
        registerRecordMapper.update(null, updateWrapper);

        //返回后续排队的十个人
        QueryWrapper<RegisterRecord>wrapper = new QueryWrapper<>();
        Page<RegisterRecord> page = new Page<>(0, 10);
        wrapper.eq("is_paid",1).eq("is_hang_up",0).eq("is_canceled",0).eq("is_completed",0).eq("doctor_id",doctorId).orderByAsc("visit_time");
        List<RegisterRecord> registerRecords = registerRecordMapper.selectPage(page,wrapper).getRecords();
        List<String> res = new ArrayList<>();
        for (RegisterRecord registerRecord : registerRecords) {
            Integer patientId = registerRecord.getPatientId();
            String name = patientMapper.selectById(patientId).getName();
            res.add(name);
        }

        return res;
    }

    @Override
    public List<RegisterRecord> getAllRegisterRecord() {
        List<RegisterRecord> list = registerRecordMapper.selectList(null);
        return list;
    }

    @Override
    public boolean pay(Integer recordId) {
        UpdateWrapper<RegisterRecord> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",recordId).eq("is_canceled",0).eq("is_hang_up",0).set("is_paid",1);
        return registerRecordMapper.update(null,updateWrapper)>0;
    }
}
