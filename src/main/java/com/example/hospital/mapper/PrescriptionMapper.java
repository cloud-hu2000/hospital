package com.example.hospital.mapper;

import com.example.hospital.entity.Prescription;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CloudHu
 * @since 2022-12-28
 */
@Mapper
public interface PrescriptionMapper extends BaseMapper<Prescription> {

    @Update("UPDATE prescription SET is_paid=1 WHERE id = #{id}")
    int pay(Integer id);

    @Update("UPDATE prescription SET is_received=1 WHERE id = #{id}")
    int receive(Integer id);


}
