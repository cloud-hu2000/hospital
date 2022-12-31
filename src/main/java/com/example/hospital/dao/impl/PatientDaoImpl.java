package com.example.hospital.dao.impl;

import com.example.hospital.entity.Patient;
import com.example.hospital.mapper.PatientMapper;
import com.example.hospital.dao.PatientDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
