package com.example.hospital.controller;


import com.example.hospital.constant.Code;
import com.example.hospital.dao.impl.StaffDaoImpl;
import com.example.hospital.dto.DepartmentAndStaff;
import com.example.hospital.dto.Result;
import com.example.hospital.entity.Staff;
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
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffDaoImpl staffDaoImpl;

    // 添加员工
    @PostMapping
    public Result insertStaff(@RequestBody Staff staff) {
        boolean flag = staffDaoImpl.insertStaff(staff);
        System.out.println("json:" + staff);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    // 按id删除员工
    @DeleteMapping("/{id}")
    public Result deleteStaff(@PathVariable int id) {
        boolean flag = staffDaoImpl.deleteStaff(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    // 按id修改员工信息
    @PutMapping
    public Result updateStaff(@RequestBody Staff staff) {
        System.out.println("json:" + staff);
        boolean flag = staffDaoImpl.updateStaff(staff);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    // 按id查找员工
    @GetMapping("/id/{id}")
    public Result getStaffByID(@PathVariable int id) {
        Staff staff = staffDaoImpl.getStaffByID(id);
        Integer code = staff != null ? Code.GET_OK : Code.GET_ERR;
        String msg = staff != null ? "数据查询成功！" : "数据查询失败，请重试！";
        return new Result(code, staff, msg);
    }

    // 查找全部员工
    @GetMapping
    public Result getAllStaff() {
        List<Staff> list = staffDaoImpl.getAllStaff();
        Integer code = list != null ? Code.GET_OK : Code.GET_ERR;
        String msg = list != null ? "数据查询成功！" : "数据查询失败，请重试！";
        return new Result(code, list, msg);
    }

    // 查找全部医生
    @GetMapping("/doctor")
    public Result getAllDoctor() {
        List<DepartmentAndStaff> list = staffDaoImpl.getAllDoctor();
        Integer code = list != null ? Code.GET_OK : Code.GET_ERR;
        String msg = list != null ? "数据查询成功！" : "数据查询失败，请重试！";
        return new Result(code, list, msg);
    }
}

