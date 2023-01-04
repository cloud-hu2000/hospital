package com.example.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("medical_record")
public class MedicalRecord implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 病历书写时间
     */
    private String createTime;

    /**
     * 药敏史
     */
    private String drugSensitivityHistory;

    /**
     * 现病史
     */
    private String presentIllnessHistory;

    /**
     * 主诉
     */
    private String chiefComplaint;

    /**
     * 科室id
     */
    private Integer departmentId;

    /**
     * 填写医生id
     */
    private Integer doctorId;


}
