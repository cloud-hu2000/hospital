package com.example.hospital.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hospital.dto.DepartmentAndStaff;
import com.example.hospital.entity.Department;
import com.example.hospital.entity.Staff;
import com.example.hospital.mapper.DepartmentMapper;
import com.example.hospital.mapper.StaffMapper;
import com.example.hospital.dao.StaffDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CloudHu
 * @since 2022-12-28
 */
@Service
public class StaffDaoImpl extends ServiceImpl<StaffMapper, Staff> implements StaffDao {

    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private DepartmentMapper departmentMapper;



    public boolean insertStaff(Staff staff) {
        boolean flag = staffMapper.insert(staff) > 0;
        return flag;
    }

    public boolean deleteStaff(int id) {
        boolean flag = staffMapper.deleteById(id) > 0;
        return flag;
    }

    public boolean updateStaff(Staff staff) {
        boolean flag = staffMapper.updateById(staff) > 0;
        return flag;

    }

    public Staff getStaffByID(int id) {
        Staff staff = staffMapper.selectById(id);
        return staff;
    }

    public List<Staff> getAllStaff() {
        List<Staff> list = staffMapper.selectList(null);
        return list;
    }

    @Override
    public List<DepartmentAndStaff> getAllDoctor() {
        List<DepartmentAndStaff> res = new ArrayList<>();
        List<Department> departments = departmentMapper.selectList(null);

        for (Department department : departments) {

            List<Staff> staffList = new ArrayList<>();
            QueryWrapper<Staff>queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("department_id", department.getId());
            List<Staff> staffs = staffMapper.selectList(queryWrapper);
            for (Staff staff : staffs) {
                staffList.add(staff);
            }
            DepartmentAndStaff departmentAndStaff = new DepartmentAndStaff(department,staffList);
            res.add(departmentAndStaff);
        }
        return res;
    }


}
