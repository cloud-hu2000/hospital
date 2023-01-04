package com.example.hospital.dao.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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

    public boolean checkReportRefund(Integer checkReportID){
        CheckReport checkReport=checkReportMapper.selectById(checkReportID);

        // 没有付款
        if (checkReport.getIsPaid()<=0){
            return false;
        }

        // 付款但是已经检查
        if (checkReport.getIsChecked()>0){
            return false;
        }

        // 付款未检查
        System.out.println("模拟支付退款接口");
        UpdateWrapper<CheckReport> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",checkReportID).set("is_refunded",1);
        checkReportMapper.update(null,updateWrapper);
        return true;
    }

    // 查看是否支付状态
    public int if_ispaid(CheckReport checkReport) {
        int id = checkReport.getId();
        CheckReport temp = checkReportMapper.selectById(id);
        return temp.getIsPaid();
    }

    // 查看是否检查状态
    public int if_ischecked(CheckReport checkReport) {
        int id = checkReport.getId();
        CheckReport temp = checkReportMapper.selectById(id);
        return temp.getIsChecked();
    }

    // 检查是否退款状态
    public int if_isrefunded(CheckReport checkReport) {
        int id = checkReport.getId();
        CheckReport temp = checkReportMapper.selectById(id);
        return temp.getIsRefunded();
    }

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
