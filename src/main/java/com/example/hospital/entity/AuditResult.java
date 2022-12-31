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
 * @since 2022-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("audit_result")
public class AuditResult implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 药剂师id
     */
    private Integer pharmacistId;

    /**
     * 药单id
     */
    private Integer prescriptionId;

    /**
     * 是否通过，0为未通过，1为通过
     */
    private Integer isPassed;

    /**
     * 审核意见
     */
    private String auditComment;


}
