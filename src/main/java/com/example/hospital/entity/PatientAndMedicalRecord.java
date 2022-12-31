package com.example.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author CloudHu
 * @since 2022-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("patient_and_medical_record")
public class PatientAndMedicalRecord implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 病人id
     */
    private Integer patientId;

    /**
     * 病历id
     */
    private Integer medicalRecordId;


}
