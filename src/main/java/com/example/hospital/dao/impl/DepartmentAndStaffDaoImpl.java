package com.example.hospital.dao.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.hospital.entity.Department;
import com.example.hospital.entity.DepartmentAndStaff;
import com.example.hospital.mapper.DepartmentAndStaffMapper;
import com.example.hospital.dao.DepartmentAndStaffDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author CloudHu
 * @since 2022-12-28
 */
@Service
public class DepartmentAndStaffDaoImpl extends ServiceImpl<DepartmentAndStaffMapper, DepartmentAndStaff> implements DepartmentAndStaffDao {
    @Autowired
    private DepartmentAndStaffMapper departmentAndStaffMapper;

    public boolean insert(DepartmentAndStaff departmentAndStaff) {
        return departmentAndStaffMapper.insert(departmentAndStaff) > 0;
    }

    public boolean deleteByStaffID(int staffId) {
        Map<String, Object> map = new HashMap<>();
        map.put("staff_id", staffId);
        return departmentAndStaffMapper.deleteByMap(map) > 0;
    }

    public boolean updateByStaffID(DepartmentAndStaff departmentAndStaff) {
        UpdateWrapper<DepartmentAndStaff> updateWrapper = new UpdateWrapper<>();
        int staffId = departmentAndStaff.getStaffId();
        updateWrapper.eq("staff_id", staffId);
        return departmentAndStaffMapper.update(departmentAndStaff, updateWrapper) > 0;
    }

    public List<DepartmentAndStaff> getAll() {
        return departmentAndStaffMapper.selectList(null);
    }

}
