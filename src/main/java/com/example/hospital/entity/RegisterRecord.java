package com.example.hospital.entity;

import java.math.BigDecimal;
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
@TableName("register_record")
public class RegisterRecord implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 创建挂号记录的时间
     */
    private String createTime;

    /**
     * 就诊时间
     */
    private String visitTime;

    /**
     * 挂号费
     */
    private BigDecimal fee;

    /**
     * 是否缴费，0为未缴费，1为已缴费
     */
    private Integer isPaid;

    /**
     * 是否挂起,0为未挂起，1为挂起
     */
    private Integer isHangUp;

    /**
     * 是否取消,1为取消
     */
    private Integer isCanceled;

    /**
     * 是否完成问诊，0为未完成，1为已完成
     */
    private Integer isCompleted;

    /**
     * 是否退费，0为未退费，1为已退费
     */
    private Integer isRefunded;

    /**
     * 病人id
     */
    private Integer patientId;

    /**
     * 医生id
     */
    private Integer doctorId;

    /**
     * 科室id
     */
    private Integer departmentId;


}
