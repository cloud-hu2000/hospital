package com.example.hospital.controller;


import com.example.hospital.constant.Code;
import com.example.hospital.dao.impl.PatientDaoImpl;
import com.example.hospital.dao.impl.PrescriptionDaoImpl;
import com.example.hospital.dao.impl.RegisterRecordDaoImpl;
import com.example.hospital.dto.Result;
import com.example.hospital.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientDaoImpl patientDaoImpl;

    @Autowired
    private RegisterRecordDaoImpl registerRecordDao;



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
    // 添加患者
    @PostMapping
    public Result insertPatient(@RequestBody Patient patient) {
        boolean flag = patientDaoImpl.insertPatient(patient);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    // 按id删除患者
    @DeleteMapping("/{id}")
    public Result deletePatient(@PathVariable int id) {
        boolean flag = patientDaoImpl.deletePatient(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    // 按id修改患者信息
    @PutMapping
    public Result updatePatient(@RequestBody Patient patient) {
        boolean flag = patientDaoImpl.updatePatient(patient);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    // 按id查找患者
    @GetMapping("/id/{id}")
    public Result getPatientByID(@PathVariable int id) {
        Patient patient = patientDaoImpl.getPatientByID(id);
        Integer code = patient != null ? Code.GET_OK : Code.GET_ERR;
        String msg = patient != null ? "数据查询成功！" : "数据查询失败，请重试！";
        return new Result(code, patient, msg);
    }

    // 查找全部患者
    @GetMapping
    public Result getAllPatient() {
        List<Patient> list = patientDaoImpl.getAllPatient();
        Integer code = list != null ? Code.GET_OK : Code.GET_ERR;
        String msg = list != null ? "数据查询成功！" : "数据查询失败，请重试！";
        return new Result(code, list, msg);
    }


}

