package com.example.hospital.dao.impl;

import com.example.hospital.entity.Department;
import com.example.hospital.mapper.DepartmentMapper;
import com.example.hospital.dao.DepartmentDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CloudHu
 * @since 2022-12-28
 */
@Service
public class DepartmentDaoImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentDao {

}
