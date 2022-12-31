package com.example.hospital.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
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
@TableName("drug")
public class Drug implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 药名
     */
    private String name;

    /**
     * 厂家名
     */
    private String manufactor;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 库存数量
     */
    private Integer inventory;

    @Override
    public String toString() {
        return "Drug{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufactor='" + manufactor + '\'' +
                ", price=" + price +
                ", inventory=" + inventory +
                '}';
    }
}
