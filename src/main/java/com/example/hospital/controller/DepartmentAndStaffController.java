package com.example.hospital.controller;


import com.example.hospital.constant.Code;
import com.example.hospital.dao.impl.DepartmentAndStaffDaoImpl;
import com.example.hospital.dto.Result;
import com.example.hospital.entity.DepartmentAndStaff;
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
@RequestMapping("/department-and-staff")
public class DepartmentAndStaffController {
    @Autowired
    private DepartmentAndStaffDaoImpl departmentAndStaffDaoImpl;

    // 添加
    @PostMapping
    public Result insert(@RequestBody DepartmentAndStaff departmentAndStaff) {
        boolean flag = departmentAndStaffDaoImpl.insert(departmentAndStaff);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    // 按照员工id进行关系的删除
    @DeleteMapping("/{staff_id}")
    public Result deleteByStaffID(@PathVariable int staff_id) {
        boolean flag = departmentAndStaffDaoImpl.deleteByStaffID(staff_id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    // 按照员工id进行关系的修改
    @PutMapping
    public Result updateByStaffID(@RequestBody DepartmentAndStaff departmentAndStaff) {
        boolean flag = departmentAndStaffDaoImpl.updateByStaffID(departmentAndStaff);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    // 查找全部
    @GetMapping
    public Result getAll() {
        List<DepartmentAndStaff> list = departmentAndStaffDaoImpl.getAll();
        Integer code = list != null ? Code.GET_OK : Code.GET_ERR;
        String msg = list != null ? "数据查询成功！" : "数据查询失败，请重试！";
        return new Result(code, list, msg);
    }

}

