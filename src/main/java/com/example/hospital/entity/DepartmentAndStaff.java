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
@TableName("department_and_staff")
public class DepartmentAndStaff implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 科室id
     */
    private Integer departmentId;

    /**
     * 职工id
     */
    private Integer staffId;


}
