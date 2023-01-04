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
@TableName("check_report")
public class CheckReport implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 检验项目
     */
    private String name;

    /**
     * 出单时间
     */
    private String createTime;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 是否缴费，0为未缴费，1为已缴费
     */
    private Integer isPaid;

    /**
     * 是否做过检查，0为未检查，1为已检查
     */
    private Integer isChecked;

    /**
     * 是否退费，0为未退费，1为已退费
     */
    private Integer isRefunded;

    /**
     * 开单医生id

     */
    private Integer createDoctorId;

    /**
     * 负责检查的医生id
     */
    private Integer checkDoctorId;


}
