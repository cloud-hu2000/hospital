package com.example.hospital;

import cn.hutool.json.JSONUtil;
import com.alibaba.druid.support.json.JSONUtils;
import com.example.hospital.entity.Drug;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class HospitalApplicationTests {

	@Test
	void contextLoads() throws ParseException {
		Map<Drug,Integer>map = new HashMap<>();
		Drug drug = new Drug();
		drug.setId(1);
		drug.setInventory(2);
		drug.setManufactor("哈药六厂");
		drug.setName("布洛芬");
		drug.setPrice(new BigDecimal(12.50));
		map.put(drug,1);
		String s = JSONUtil.toJsonStr(drug);
		System.out.println(s);

		Long timeLong = Long.parseLong(String.valueOf(System.currentTimeMillis()));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//要转换的时间格式
		Date date;
		date = sdf.parse(sdf.format(timeLong));
		System.out.println(sdf.format(date));
	}

}
