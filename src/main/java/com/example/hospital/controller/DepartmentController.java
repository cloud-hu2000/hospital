package com.example.hospital.controller;


import com.example.hospital.constant.Code;
import com.example.hospital.dao.impl.DepartmentDaoImpl;
import com.example.hospital.dto.Result;
import com.example.hospital.entity.AuditResult;
import com.example.hospital.entity.Department;
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
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentDaoImpl departmentDaoImpl;

    // 添加科室
    @PostMapping
    public Result insert(@RequestBody Department department) {
        System.out.println("json:" + department);
        boolean flag = departmentDaoImpl.insert(department);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    // 按id删除科室
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id) {
        boolean flag = departmentDaoImpl.delete(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    // 按id修改科室信息
    @PutMapping
    public Result update(@RequestBody Department department) {
        System.out.println("json:" + department);
        boolean flag = departmentDaoImpl.update(department);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    // 按id查找科室
    @GetMapping("/id/{id}")
    public Result getByID(@PathVariable int id) {
        Department department = departmentDaoImpl.getByID(id);
        Integer code = department != null ? Code.GET_OK : Code.GET_ERR;
        String msg = department != null ? "数据查询成功！" : "数据查询失败，请重试！";
        return new Result(code, department, msg);
    }

    // 查找全部
    @GetMapping
    public Result getAll() {
        List<Department> list = departmentDaoImpl.getAll();
        Integer code = list != null ? Code.GET_OK : Code.GET_ERR;
        String msg = list != null ? "数据查询成功！" : "数据查询失败，请重试！";
        return new Result(code, list, msg);
    }

    // 分页查询(1页10条记录)
    @GetMapping("/page")
    public Result getPage() {
        List<Department> list = departmentDaoImpl.getPage();
        Integer code = list != null ? Code.GET_OK : Code.GET_ERR;
        String msg = list != null ? "数据查询成功！" : "数据查询失败，请重试！";
        return new Result(code, list, msg);
    }
}

