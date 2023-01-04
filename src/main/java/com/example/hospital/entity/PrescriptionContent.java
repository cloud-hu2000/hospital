package com.example.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
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
@TableName("prescription_content")
@AllArgsConstructor
public class PrescriptionContent implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 药单id
     */
    private Integer prescriptionId;

    /**
     * 药品id
     */
    private Integer drugId;

    /**
     * 拿药数量
     */
    private Integer count;


}
