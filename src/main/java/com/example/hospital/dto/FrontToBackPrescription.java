package com.example.hospital.dto;

import com.example.hospital.entity.Prescription;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author CloudHu
 * @date 2022年12月30日 23:30
 * 从前端传来的药单数据，包含药品id和数量
 */
@Data
public class FrontToBackPrescription extends Prescription {

    /**
     * 药品清单为
     * <"id",Integer>
     * <"count",Integer>
     */
    private List<Map<String,Integer>> drugs;
}
