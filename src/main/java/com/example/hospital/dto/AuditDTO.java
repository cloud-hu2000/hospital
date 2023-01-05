package com.example.hospital.dto;

import com.example.hospital.entity.CheckReport;
import com.example.hospital.entity.MedicalRecord;
import com.example.hospital.entity.Prescription;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author CloudHu
 * @date 2023年01月05日 16:27
 */
@Data
@AllArgsConstructor
public class AuditDTO {

    private MedicalRecord medicalRecord;

    private BackToFrontPrescription backToFrontPrescription;

}
