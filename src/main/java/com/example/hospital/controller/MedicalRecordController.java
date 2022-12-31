package com.example.hospital.controller;


import com.example.hospital.constant.Code;
import com.example.hospital.dao.impl.MedicalRecordDaoImpl;
import com.example.hospital.dto.Result;
import com.example.hospital.entity.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author CloudHu
 * @since 2022-12-28
 */
@RestController
@RequestMapping("/medical-record")
public class MedicalRecordController {
    @Autowired
    private MedicalRecordDaoImpl medicalRecordDaoImpl;

    // 添加病历信息
    @PostMapping
    public Result insert(@RequestBody MedicalRecord medicalRecord) {
        boolean flag = medicalRecordDaoImpl.insert(medicalRecord);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    // 根据id删除病历信息
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id) {
        boolean flag = medicalRecordDaoImpl.delete(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    // 根据id修改病历信息
    @PutMapping
    public Result update(@RequestBody MedicalRecord medicalRecord) {
        boolean flag = medicalRecordDaoImpl.update(medicalRecord);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    // 根据id查询病历
    @GetMapping("/id/{id}")
    public Result getByID(@PathVariable int id) {
        MedicalRecord medicalRecord = medicalRecordDaoImpl.getByID(id);
        Integer code = medicalRecord != null ? Code.GET_OK : Code.GET_ERR;
        String msg = medicalRecord != null ? "数据查询成功！" : "数据查询失败，请重试！";
        return new Result(code, medicalRecord, msg);
    }

    // 查找全部
    @GetMapping
    public Result getAll() {
        List<MedicalRecord> list = medicalRecordDaoImpl.getAll();
        Integer code = list != null ? Code.GET_OK : Code.GET_ERR;
        String msg = list != null ? "数据查询成功！" : "数据查询失败，请重试！";
        return new Result(code, list, msg);
    }
}

