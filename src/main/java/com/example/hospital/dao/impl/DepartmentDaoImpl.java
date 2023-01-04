package com.example.hospital.dao.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hospital.dto.patientCheck;
import com.example.hospital.entity.AuditResult;
import com.example.hospital.entity.CheckReport;
import com.example.hospital.entity.Department;
import com.example.hospital.entity.Patient;
import com.example.hospital.mapper.CheckReportMapper;
import com.example.hospital.mapper.DepartmentMapper;
import com.example.hospital.dao.DepartmentDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hospital.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class DepartmentDaoImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentDao {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private CheckReportMapper checkReportMapper;

    @Autowired
    private PatientMapper patientMapper;


    public List<patientCheck> find(Integer department_id) {
        List<patientCheck> list=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        map.put("is_checked",0);
        map.put("department_id",department_id);
        List<CheckReport> checkReports=checkReportMapper.selectByMap(map);
        for (CheckReport checkReport:checkReports){
            // 初始化patientCheck对象
            patientCheck patientCheck=new patientCheck();
            // 检查项目放进去
            String checkname=checkReport.getName();
            patientCheck.setCheckName(checkname);
            // 处理患者信息
            int patientId=checkReport.getPatientId();
            Patient patient=patientMapper.selectById(patientId);
            // 患者姓名放进去
            String name=patient.getName();
            patientCheck.setName(name);
            // 患者性别放进去
            String sex=patient.getSex();
            patientCheck.setSex(sex);
            // 患者年龄放进去
            int age=patient.getAge();
            patientCheck.setAge(age);

            // 把这个patientCheck对象放到结果列表里面
            list.add(patientCheck);
        }
        return list;
    }

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
