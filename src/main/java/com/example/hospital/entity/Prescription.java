package com.example.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

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
@TableName("prescription")
public class Prescription implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 出单时间
     */
    private String  createTime;

    /**
     * 是否拿药，0为未拿，1为已拿
     */
    private Integer isReceived;

    /**
     * 是否付费，0为未付费，1为已付费
     */
    private Integer isPaid;

    /**
     * 患者id
     */
    private Integer patientId;

    /**
     * 开单医生id
     */
    private Integer doctorId;


}
