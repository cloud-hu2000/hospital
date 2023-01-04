package com.example.hospital.dao.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hospital.entity.AuditResult;
import com.example.hospital.entity.Department;
import com.example.hospital.mapper.DepartmentMapper;
import com.example.hospital.dao.DepartmentDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author CloudHu
 * @since 2022-12-28
 */
@Service
public class DepartmentDaoImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentDao {

    @Autowired
    private DepartmentMapper departmentMapper;

    public boolean insert(Department department) {
        boolean flag = departmentMapper.insert(department) > 0;
        return flag;
    }

    public boolean delete(int id) {
        boolean flag = departmentMapper.deleteById(id) > 0;
        return flag;
    }

    public boolean update(Department department) {
        return departmentMapper.updateById(department) > 0;
    }

    public Department getByID(int id) {
        Department department = departmentMapper.selectById(id);
        return department;
    }

    public List<Department> getAll() {
        List<Department> list = departmentMapper.selectList(null);
        return list;
    }

    public List<Department> getPage(int num) {
        Page<Department> page = new Page<>(num, 10);
        departmentMapper.selectPage(page, null);
        return page.getRecords();
    }
}
