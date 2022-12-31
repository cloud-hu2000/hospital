package com.example.hospital.controller;


import com.example.hospital.constant.Code;
import com.example.hospital.dao.impl.PrescriptionDaoImpl;
import com.example.hospital.dto.BackToFrontPrescription;
import com.example.hospital.dto.FrontToBackPrescription;
import com.example.hospital.dto.Result;
import com.example.hospital.entity.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CloudHu
 * @since 2022-12-28
 */
@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionDaoImpl prescriptionDao;

    @RequestMapping("/addPrescription")
    public Result addPrescription(@RequestBody FrontToBackPrescription frontToBackPrescription){
        boolean flag = prescriptionDao.addPrescription(frontToBackPrescription);
        return new Result(flag? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @RequestMapping("/checkPrescription/{id}")
    public Result checkPrescription(@PathVariable Integer id){
        BackToFrontPrescription prescription = prescriptionDao.checkPrescription(id);
        return new Result(prescription==null? Code.GET_OK:Code.GET_ERR,prescription);
    }

    @RequestMapping("/pay/{id}")
    public Result pay(@PathVariable Integer id){
        boolean flag = prescriptionDao.pay(id);
        return new Result(flag? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @RequestMapping("/receive/{id}")
    public Result receive(@PathVariable Integer id){
        boolean flag = prescriptionDao.receive(id);
        return new Result(flag? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }
}

