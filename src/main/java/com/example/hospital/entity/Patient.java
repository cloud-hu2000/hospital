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
@TableName("patient")
public class Patient implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 账号名
     */
    //private String nickname;

    /**
     * 密码
     */
    private String password;

    /**
     * 患者姓名
     */
    private String name;

    /**
     * 患者性别
     */
    private String sex;

    /**
     * 患者年龄
     */
    private Integer age;

    /**
     * 患者电话
     */
    private String phone;

    /**
     * 患者身份证号
     */
    private String idNumber;


}
