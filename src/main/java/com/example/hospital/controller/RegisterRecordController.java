package com.example.hospital.controller;


import com.example.hospital.constant.Code;
import com.example.hospital.dao.impl.RegisterRecordDaoImpl;
import com.example.hospital.dto.Result;
import com.example.hospital.entity.RegisterRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CloudHu
 * @since 2022-12-28
 */
@RestController
@RequestMapping("/register-record")
public class RegisterRecordController {
    @Autowired
    RegisterRecordDaoImpl registerRecordDao;
    @RequestMapping("/addRecord")
    public Result addRecord(RegisterRecord registerRecord){
        boolean flag = registerRecordDao.addRecord(registerRecord);
        return new Result(flag? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @RequestMapping("/checkRecord")
    public Result checkRecord(int patientId){
        RegisterRecord registerRecord = registerRecordDao.checkRecord(patientId);
        return new Result(registerRecord==null? Code.GET_OK:Code.GET_OK,registerRecord);
    }


}

