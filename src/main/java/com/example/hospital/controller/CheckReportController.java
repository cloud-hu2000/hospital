package com.example.hospital.controller;


import com.example.hospital.constant.Code;
import com.example.hospital.dao.impl.CheckReportDaoImpl;
import com.example.hospital.dto.Result;
import com.example.hospital.entity.CheckReport;
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
@RequestMapping("/check-report")
public class CheckReportController {

    @Autowired
    private CheckReportDaoImpl checkReportDaoImpl;

    // 添加
    @PostMapping
    public Result insert(@RequestBody CheckReport checkReport) {
        System.out.println("json:" + checkReport);
        boolean flag = checkReportDaoImpl.insert(checkReport);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    // 删除
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id) {
        boolean flag = checkReportDaoImpl.delete(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    // 按id修改
    @PutMapping
    public Result update(@RequestBody CheckReport checkReport) {
        System.out.println("json:" + checkReport);
        boolean flag = checkReportDaoImpl.update(checkReport);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    // 按id查询
    @GetMapping("/id/{id}")
    public Result getByID(@PathVariable int id) {
        CheckReport checkReport = checkReportDaoImpl.getByID(id);
        Integer code = checkReport != null ? Code.GET_OK : Code.GET_ERR;
        String msg = checkReport != null ? "数据查询成功！" : "数据查询失败，请重试！";
        return new Result(code, checkReport, msg);
    }

    // 查找全部
    @GetMapping
    public Result getAll() {
        List<CheckReport> list = checkReportDaoImpl.getAll();
        Integer code = list != null ? Code.GET_OK : Code.GET_ERR;
        String msg = list != null ? "数据查询成功！" : "数据查询失败，请重试！";
        return new Result(code, list, msg);
    }

    // 分页查询(1页10条记录)
    @GetMapping("/page")
    public Result getPage() {
        List<CheckReport> list = checkReportDaoImpl.getPage();
        Integer code = list != null ? Code.GET_OK : Code.GET_ERR;
        String msg = list != null ? "数据查询成功！" : "数据查询失败，请重试！";
        return new Result(code, list, msg);
    }
}

