package com.example.hospital.mapper;

import com.example.hospital.entity.Patient;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CloudHu
 * @since 2022-12-28
 */
@Mapper
public interface PatientMapper extends BaseMapper<Patient> {

}
