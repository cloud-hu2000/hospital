package com.example.hospital.controller;


import com.example.hospital.constant.Code;
import com.example.hospital.dao.impl.CheckReportDaoImpl;
import com.example.hospital.dto.Result;
import com.example.hospital.entity.CheckReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author CloudHu
 * @since 2022-12-28
 */
@RestController
@RequestMapping("/check-report")
public class CheckReportController {

    @Autowired
    private CheckReportDaoImpl checkReportDaoImpl;

    // 变更退款状态
    @RequestMapping("/changeRefunded/{id}")
    public Result changeRefunded(@PathVariable int id) {
        boolean flag = checkReportDaoImpl.changeRefunded(id);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    // 变更检查状态
    @RequestMapping("/changeChecked/{id}")
    public Result changeChecked(@PathVariable int id) {
        boolean flag = checkReportDaoImpl.changeChecked(id);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    // 变更支付状态
    @RequestMapping("/changePaid/{id}")
    public Result changePaid(@PathVariable int id) {
        boolean flag = checkReportDaoImpl.changePaid(id);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    // 检查单退费
    @RequestMapping("/refund/{id}")
    public Result checkReportRefund(@PathVariable int id) {
        boolean flag = checkReportDaoImpl.checkReportRefund(id);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    // 查看是否缴费
    @RequestMapping("/ispaid")
    public Result if_ispaid(@RequestBody CheckReport checkReport) {
        int flag = checkReportDaoImpl.if_ispaid(checkReport);
        Integer code = Code.GET_OK;
        String msg = flag == 0 ? "未缴费！" : "已缴费！";
        return new Result(code, flag, msg);
    }

    // 查看是否检查
    @RequestMapping("/ischecked")
    public Result if_ischecked(@RequestBody CheckReport checkReport) {
        int flag = checkReportDaoImpl.if_ischecked(checkReport);
        Integer code = Code.GET_OK;
        String msg = flag == 0 ? "未检查！" : "已检查！";
        return new Result(code, flag, msg);
    }

    // 查看是否退费
    @RequestMapping("/isrefunded")
    public Result if_isrefunded(@RequestBody CheckReport checkReport) {
        int flag = checkReportDaoImpl.if_isrefunded(checkReport);
        Integer code = Code.GET_OK;
        String msg = flag == 0 ? "未退费！" : "已退费！";
        return new Result(code, flag, msg);
    }

    // 添加
    @PostMapping
    public Result insert(@RequestBody CheckReport checkReport) {
        System.out.println("json:" + checkReport);
        boolean flag = checkReportDaoImpl.insert(checkReport);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    // 删除
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id) {
        boolean flag = checkReportDaoImpl.delete(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    // 按id修改
    @PutMapping
    public Result update(@RequestBody CheckReport checkReport) {
        System.out.println("json:" + checkReport);
        boolean flag = checkReportDaoImpl.update(checkReport);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    // 按id查询
    @GetMapping("/id/{id}")
    public Result getByID(@PathVariable int id) {
        CheckReport checkReport = checkReportDaoImpl.getByID(id);
        Integer code = checkReport != null ? Code.GET_OK : Code.GET_ERR;
        String msg = checkReport != null ? "数据查询成功！" : "数据查询失败，请重试！";
        return new Result(code, checkReport, msg);
    }

    // 查找全部
    @GetMapping
    public Result getAll() {
        List<CheckReport> list = checkReportDaoImpl.getAll();
        Integer code = list != null ? Code.GET_OK : Code.GET_ERR;
        String msg = list != null ? "数据查询成功！" : "数据查询失败，请重试！";
        return new Result(code, list, msg);
    }

    // 分页查询(1页10条记录)
    @GetMapping("/page")
    public Result getPage(@PathVariable int page) {
        List<CheckReport> list = checkReportDaoImpl.getPage(page);
        Integer code = list != null ? Code.GET_OK : Code.GET_ERR;
        String msg = list != null ? "数据查询成功！" : "数据查询失败，请重试！";
        return new Result(code, list, msg);
    }
}

