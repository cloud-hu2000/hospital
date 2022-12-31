package com.example.hospital.dao.impl;

import com.example.hospital.entity.Drug;
import com.example.hospital.mapper.DrugMapper;
import com.example.hospital.dao.DrugDao;
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
public class DrugDaoImpl extends ServiceImpl<DrugMapper, Drug> implements DrugDao {

}
