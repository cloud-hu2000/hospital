package com.example.hospital.controller;


import com.example.hospital.constant.Code;
import com.example.hospital.dao.impl.RegisterRecordDaoImpl;
import com.example.hospital.dto.Result;
import com.example.hospital.entity.RegisterRecord;
import com.example.hospital.entity.RegisterRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    /**
     * 取消挂号
     * @author CloudHu
     * @date 2023/1/3 13:51
     */
    @RequestMapping("/cancelRegister")
    public Result cancelRegister(Integer recordId){
        boolean flag = registerRecordDao.cancelRegister(recordId);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    /**
     * 取消挂号
     * @author CloudHu
     * @date 2023/1/3 13:51
     */
    @RequestMapping("/pay")
    public Result pay(Integer recordId){
        boolean flag = registerRecordDao.pay(recordId);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }


    /**
     * 挂号
     * @author CloudHu
     * @date 2023/1/4 15:19
     */
    @RequestMapping("/addRecord")
    public Result addRecord(@RequestBody RegisterRecord registerRecord){
        boolean flag = registerRecordDao.addRecord(registerRecord);
        return new Result(flag? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    /**
     * 查看挂号信息
     * @author CloudHu
     * @date 2023/1/4 15:19
     */
    @RequestMapping("/checkRecord")
    public Result checkRecord(int recordId){
        RegisterRecord registerRecord = registerRecordDao.checkRecord(recordId);
        return new Result(registerRecord==null? Code.GET_OK:Code.GET_OK,registerRecord);
    }

    /**
     * 医生完成诊断，返回后续的队列
     * @author CloudHu
     * @date 2023/1/4 15:19
     */
    @RequestMapping("/registerComplete")
    public Result registerComplete(int recordId,int doctorId){
        List list = registerRecordDao.registerComplete(recordId,doctorId);
        return new Result(list==null? Code.SAVE_OK:Code.SAVE_ERR,list);
    }

    @GetMapping
    public Result getAllRegisterRecord() {
        List<RegisterRecord> list = registerRecordDao.getAllRegisterRecord();
        Integer code = list != null ? Code.GET_OK : Code.GET_ERR;
        String msg = list != null ? "数据查询成功！" : "数据查询失败，请重试！";
        return new Result(code, list, msg);
    }




}

