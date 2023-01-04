package com.example.hospital.dao;

import com.example.hospital.dto.DepartmentAndStaff;
import com.example.hospital.entity.Staff;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CloudHu
 * @since 2022-12-28
 */
public interface StaffDao extends IService<Staff> {

    boolean insertStaff(Staff staff);

    boolean deleteStaff(int id);

    boolean updateStaff(Staff staff);

    Staff getStaffByID(int id);

    List<Staff> getAllStaff();

    List<DepartmentAndStaff> getAllDoctor();
}
