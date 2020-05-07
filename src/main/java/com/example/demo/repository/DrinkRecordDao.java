package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.entity.DrinkRecord;

public interface DrinkRecordDao {
	
	List<DrinkRecord> list(int id);
	
	BigDecimal drinkSum(int id);
	
	void insert(DrinkRecord drink);

}
