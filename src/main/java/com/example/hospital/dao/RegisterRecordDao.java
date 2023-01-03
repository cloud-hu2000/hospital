package com.example.hospital.dao;

import com.example.hospital.entity.RegisterRecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CloudHu
 * @since 2022-12-28
 */
public interface RegisterRecordDao extends IService<RegisterRecord> {
    public boolean addRecord(RegisterRecord registerRecord);

    RegisterRecord checkRecord(int PatientId);

    boolean hangUp(Integer id);

    boolean cancelHangUp(Integer id);

    boolean cancelRegister(Integer recordId);
}
