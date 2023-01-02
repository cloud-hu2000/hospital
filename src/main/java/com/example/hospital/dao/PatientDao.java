package com.example.hospital.dao;

import com.example.hospital.entity.Patient;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CloudHu
 * @since 2022-12-28
 */
public interface PatientDao extends IService<Patient> {

    boolean insertPatient(Patient patient);

    boolean deletePatient(int id);

    boolean updatePatient(Patient patient);

    Patient getPatientByID(int id);

    List<Patient> getAllPatient();
}
