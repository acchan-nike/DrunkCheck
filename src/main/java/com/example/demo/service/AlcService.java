package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Alcohol;
import com.example.demo.entity.DrinkRecord;

public interface AlcService {
	
	List<Alcohol> findAll();
	
	void insert(DrinkRecord drink);

}
