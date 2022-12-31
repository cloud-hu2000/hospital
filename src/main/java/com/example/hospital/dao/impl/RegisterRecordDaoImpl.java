package com.example.hospital.dao.impl;

import com.example.hospital.entity.RegisterRecord;
import com.example.hospital.mapper.RegisterRecordMapper;
import com.example.hospital.dao.RegisterRecordDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RegisterRecordDaoImpl extends ServiceImpl<RegisterRecordMapper, RegisterRecord> implements RegisterRecordDao {

    @Autowired
    RegisterRecordMapper registerRecordMapper;
    public boolean addRecord(RegisterRecord registerRecord){
        return registerRecordMapper.insert(registerRecord)>0;
    }

    @Override
    public RegisterRecord checkRecord(int PatientId) {
        return registerRecordMapper.selectById(PatientId);
    }
}
