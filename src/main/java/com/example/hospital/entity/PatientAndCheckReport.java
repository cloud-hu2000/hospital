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
 * @since 2023-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("patient_and_check_report")
public class PatientAndCheckReport implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 病人id
     */
    private Integer patientId;

    /**
     * 检验单id
     */
    private Integer checkReportId;


}
