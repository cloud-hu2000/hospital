package com.example.hospital.dao.impl;

import com.example.hospital.entity.Staff;
import com.example.hospital.mapper.StaffMapper;
import com.example.hospital.dao.StaffDao;
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
public class StaffDaoImpl extends ServiceImpl<StaffMapper, Staff> implements StaffDao {

}
