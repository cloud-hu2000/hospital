package com.example.hospital.controller;


import com.example.hospital.constant.Code;
import com.example.hospital.dao.impl.DrugDaoImpl;
import com.example.hospital.dto.Result;
import com.example.hospital.entity.AuditResult;
import com.example.hospital.entity.Drug;
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
@RequestMapping("/drug")
public class DrugController {

    @Autowired
    private DrugDaoImpl drugDaoImpl;

    // 添加药品
    @PostMapping
    public Result insertDrug(@RequestBody Drug drug) {
        boolean flag = drugDaoImpl.insertDrug(drug);
        System.out.println("json:" + drug);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    // 按id删除药品
    @DeleteMapping("/{id}")
    public Result deleteDrug(@PathVariable int id) {
        boolean flag = drugDaoImpl.deleteDrug(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    // 按id修改药品信息
    @PutMapping
    public Result updateDrug(@RequestBody Drug drug) {
        System.out.println("json:" + drug);
        boolean flag = drugDaoImpl.updateDrug(drug);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    // 按id查找药品
    @RequestMapping("/id/{id}")
    public Result getDrugByID(@PathVariable int id) {
        Drug drug = drugDaoImpl.getDrugByID(id);
        Integer code = drug != null ? Code.GET_OK : Code.GET_ERR;
        String msg = drug != null ? "数据查询成功！" : "数据查询失败，请重试！";
        return new Result(code, drug, msg);
    }

    // 查找全部药品
    @GetMapping
    public Result getAllDrug() {
        List<Drug> list = drugDaoImpl.getAllDrug();
        Integer code = list != null ? Code.GET_OK : Code.GET_ERR;
        String msg = list != null ? "数据查询成功！" : "数据查询失败，请重试！";
        return new Result(code, list, msg);
    }

    // 分页查询(1页10条记录)
    @RequestMapping("/page")
    public Result getPage() {
        List<Drug> list = drugDaoImpl.getPage();
        Integer code = list != null ? Code.GET_OK : Code.GET_ERR;
        String msg = list != null ? "数据查询成功！" : "数据查询失败，请重试！";
        return new Result(code, list, msg);
    }

}

