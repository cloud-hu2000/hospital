package com.example.hospital.dao.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hospital.entity.AuditResult;
import com.example.hospital.mapper.AuditResultMapper;
import com.example.hospital.dao.AuditResultDao;
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
public class AuditResultDaoImpl extends ServiceImpl<AuditResultMapper, AuditResult> implements AuditResultDao {

    @Autowired
    private AuditResultMapper auditResultMapper;

    public boolean insertAuditResult(AuditResult auditResult) {
        boolean flag = auditResultMapper.insert(auditResult) > 0;
        return flag;
    }

    public boolean deleteAuditResult(int id) {
        boolean flag = auditResultMapper.deleteById(id) > 0;
        return flag;
    }

    public boolean updateAuditResult(AuditResult auditResult) {
        boolean flag = auditResultMapper.updateById(auditResult) > 0;
        return flag;
    }

    public List<AuditResult> getAllAuditResult() {
        List<AuditResult> list = auditResultMapper.selectList(null);
        return list;
    }

    public List<AuditResult> getPage(int num) {
        Page<AuditResult> page = new Page<>(num, 10);
        auditResultMapper.selectPage(page, null);
        return page.getRecords();
    }

    @Override
    public boolean isPassed(Integer id) {
        return auditResultMapper.selectById(id).getIsPassed()==1;
    }
}
