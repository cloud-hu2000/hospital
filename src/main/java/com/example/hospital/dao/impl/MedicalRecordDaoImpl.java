package com.example.hospital.dao.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hospital.entity.AuditResult;
import com.example.hospital.entity.MedicalRecord;
import com.example.hospital.mapper.MedicalRecordMapper;
import com.example.hospital.dao.MedicalRecordDao;
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
public class MedicalRecordDaoImpl extends ServiceImpl<MedicalRecordMapper, MedicalRecord> implements MedicalRecordDao {
    @Autowired
    private MedicalRecordMapper medicalRecordMapper;

    public boolean insert(MedicalRecord medicalRecord) {
        return medicalRecordMapper.insert(medicalRecord) > 0;
    }

    public boolean delete(int id) {
        return medicalRecordMapper.deleteById(id) > 0;
    }

    public boolean update(MedicalRecord medicalRecord) {
        return medicalRecordMapper.updateById(medicalRecord) > 0;
    }

    public MedicalRecord getByID(int id) {
        return medicalRecordMapper.selectById(id);
    }

    public List<MedicalRecord> getAll() {
        return medicalRecordMapper.selectList(null);
    }

    public List<MedicalRecord> getPage(int num) {
        Page<MedicalRecord> page = new Page<>(num, 10);
        medicalRecordMapper.selectPage(page, null);
        return page.getRecords();
    }
}
