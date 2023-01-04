package com.example.hospital.dao.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hospital.entity.CheckReport;
import com.example.hospital.mapper.CheckReportMapper;
import com.example.hospital.dao.CheckReportDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

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
public class CheckReportDaoImpl extends ServiceImpl<CheckReportMapper, CheckReport> implements CheckReportDao {
    @Autowired
    private CheckReportMapper checkReportMapper;

    public boolean insert(CheckReport checkReport) {
        boolean flag = checkReportMapper.insert(checkReport) > 0;
        return flag;
    }

    public boolean delete(int id) {
        boolean flag = checkReportMapper.deleteById(id) > 0;
        return flag;
    }

    public boolean update(CheckReport checkReport) {
        boolean flag = checkReportMapper.updateById(checkReport) > 0;
        return flag;
    }

    public CheckReport getByID(int id) {
        CheckReport checkReport = checkReportMapper.selectById(id);
        return checkReport;
    }

    public List<CheckReport> getAll() {
        List<CheckReport> list = checkReportMapper.selectList(null);
        return list;
    }

    public List<CheckReport> getPage(int num) {
        Page<CheckReport> page = new Page<>(num, 10);
        checkReportMapper.selectPage(page, null);
        return page.getRecords();
    }
}
