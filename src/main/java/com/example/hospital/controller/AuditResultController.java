package com.example.hospital.controller;


import com.example.hospital.constant.Code;
import com.example.hospital.dao.impl.AuditResultDaoImpl;
import com.example.hospital.dto.Result;
import com.example.hospital.entity.AuditResult;
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
@RequestMapping("/audit-result")
public class AuditResultController {
    @Autowired
    private AuditResultDaoImpl auditResultDaoImpl;

    @RequestMapping("/isPassed/{id}")
    public Result isPassed(@PathVariable Integer id){
        boolean flag = auditResultDaoImpl.isPassed(id);
        return new Result(flag? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    // 新增
    @PostMapping
    public Result insertAuditResult(@RequestBody AuditResult auditResult) {
        boolean flag = auditResultDaoImpl.insertAuditResult(auditResult);
        System.out.println("json:" + auditResult);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    // 删除
    @DeleteMapping("/{id}")
    public Result deleteAuditResult(@PathVariable int id) {
        boolean flag = auditResultDaoImpl.deleteAuditResult(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    // 修改
    @PutMapping
    public Result updateAuditResult(@RequestBody AuditResult auditResult) {
        System.out.println("json:" + auditResult);
        boolean flag = auditResultDaoImpl.updateAuditResult(auditResult);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }


    // 查找所有
    @GetMapping
    public Result getAllAuditResult() {
        List<AuditResult> list = auditResultDaoImpl.getAllAuditResult();
        Integer code = list != null ? Code.GET_OK : Code.GET_ERR;
        String msg = list != null ? "数据查询成功！" : "数据查询失败，请重试！";
        return new Result(code, list, msg);
    }

    // 分页查询(1页10条记录)
    @GetMapping("/page")
    public Result getPage(@PathVariable int page) {
        List<AuditResult> list = auditResultDaoImpl.getPage(page);
        Integer code = list != null ? Code.GET_OK : Code.GET_ERR;
        String msg = list != null ? "数据查询成功！" : "数据查询失败，请重试！";
        return new Result(code, list, msg);
    }


}

