package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.DrinkRecord;

public interface DrinkRecordDao {
	
	List<DrinkRecord> list();
	
	long drinkSum();

}
