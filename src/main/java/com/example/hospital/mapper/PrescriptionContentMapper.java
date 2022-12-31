package com.example.hospital.mapper;

import com.example.hospital.entity.PrescriptionContent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CloudHu
 * @since 2022-12-30
 */
@Mapper
public interface PrescriptionContentMapper extends BaseMapper<PrescriptionContent> {

}
