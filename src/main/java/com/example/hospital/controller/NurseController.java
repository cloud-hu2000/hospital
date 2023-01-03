package com.example.hospital.controller;

import com.example.hospital.constant.Code;
import com.example.hospital.dao.impl.RegisterRecordDaoImpl;
import com.example.hospital.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CloudHu
 * @date 2023年01月03日 12:51
 * 护士Controller
 */

@RestController
@RequestMapping("/nurse")
public class NurseController {

    @Autowired
    RegisterRecordDaoImpl registerRecordDao;

    @RequestMapping("/hang-up")
    public Result hangUp(Integer id){
        boolean flag = registerRecordDao.hangUp(id);
        return new Result(flag? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @RequestMapping("/cancel-hang-up")
    public Result cancelHangUp(Integer id){
        boolean flag = registerRecordDao.cancelHangUp(id);
        return new Result(flag? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }
}
