package com.example.hospital.dao;

import com.example.hospital.dto.AuditDTO;
import com.example.hospital.dto.BackToFrontPrescription;
import com.example.hospital.dto.FrontToBackPrescription;
import com.example.hospital.entity.Prescription;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CloudHu
 * @since 2022-12-28
 */
public interface PrescriptionDao extends IService<Prescription> {

    boolean addPrescription(FrontToBackPrescription frontToBackPrescription);

    BackToFrontPrescription checkPrescription(Integer prescriptionId);

    boolean pay(Integer id);

    boolean receive(Integer id);

    boolean drugRefund(Integer prescriptionId);

    boolean isPaid(Integer id);

    boolean isReceived(Integer id);

    boolean isDistributed(Integer id);

    List<AuditDTO> getUnauditedPrescription();

    boolean distribute(Integer id);

}
