package com.example.hospital.dao.impl;

import com.example.hospital.entity.Patient;
import com.example.hospital.entity.Patient;
import com.example.hospital.mapper.PatientMapper;
import com.example.hospital.dao.PatientDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hospital.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class PatientDaoImpl extends ServiceImpl<PatientMapper, Patient> implements PatientDao {

    @Autowired
    private PatientMapper patientMapper;

    public boolean insertPatient(Patient patient) {
        boolean flag = patientMapper.insert(patient) > 0;
        return flag;
    }

    public boolean deletePatient(int id) {
        boolean flag = patientMapper.deleteById(id) > 0;
        return flag;
    }

    public boolean updatePatient(Patient patient) {
        boolean flag = patientMapper.updateById(patient) > 0;
        return flag;

    }

    public Patient getPatientByID(int id) {
        Patient patient = patientMapper.selectById(id);
        return patient;
    }

    public List<Patient> getAllPatient() {
        List<Patient> list = patientMapper.selectList(null);
        return list;
    }
}
