package com.example.hospital.mapper;

import com.example.hospital.dto.patientCheck;
import com.example.hospital.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CloudHu
 * @since 2022-12-28
 */
@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {
}
