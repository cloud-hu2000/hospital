package com.example.hospital.dto;

import com.example.hospital.entity.Department;
import com.example.hospital.entity.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CloudHu
 * @date 2023年01月04日 20:45
 */
@AllArgsConstructor
@Data
public class DepartmentAndStaff {
    private Department department;
    private List<Staff> staffs;

}
