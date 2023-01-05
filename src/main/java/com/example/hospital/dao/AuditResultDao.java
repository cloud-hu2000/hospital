package com.example.hospital.dao;

import com.example.hospital.entity.AuditResult;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CloudHu
 * @since 2022-12-28
 */
public interface AuditResultDao extends IService<AuditResult> {

    boolean isPassed(Integer id);
}
