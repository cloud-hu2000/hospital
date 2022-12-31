package com.example.hospital.dto;

import com.example.hospital.entity.Drug;
import com.example.hospital.entity.Prescription;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CloudHu
 * @date 2022年12月31日 12:53
 * 传向的药单数据，包含完整药品和数量
 */
@Data
public class BackToFrontPrescription {

    private Prescription prescription;
    private List<Drug> drugList;
    private List<Integer> countList;

    public BackToFrontPrescription() {
        drugList = new ArrayList<>();
        countList = new ArrayList<>();
    }
}
