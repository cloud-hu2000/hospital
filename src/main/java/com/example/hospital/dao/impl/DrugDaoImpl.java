package com.example.hospital.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hospital.entity.AuditResult;
import com.example.hospital.entity.Drug;
import com.example.hospital.mapper.DrugMapper;
import com.example.hospital.dao.DrugDao;
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
public class DrugDaoImpl extends ServiceImpl<DrugMapper, Drug> implements DrugDao {

    @Autowired
    private DrugMapper drugMapper;

    public boolean insertDrug(Drug drug) {
        boolean flag = drugMapper.insert(drug) > 0;
        return flag;
    }

    public boolean deleteDrug(int id) {
        boolean flag = drugMapper.deleteById(id) > 0;
        return flag;
    }

    public boolean updateDrug(Drug drug) {
        boolean flag = drugMapper.updateById(drug) > 0;
        return flag;

    }

    public Drug getDrugByID(int id) {
        Drug drug = drugMapper.selectById(id);
        return drug;
    }

    public List<Drug> getDrugByName(Drug drug) {
        String name = drug.getName();
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.like("name", name);
        List<Drug> list = drugMapper.selectList(wrapper);
        return list;
    }

    public List<Drug> getAllDrug() {
        List<Drug> list = drugMapper.selectList(null);
        return list;
    }

    public List<Drug> getPage(int num) {
        Page<Drug> page = new Page<>(num, 10);
        drugMapper.selectPage(page, null);
        return page.getRecords();
    }


}
