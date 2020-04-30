package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Alcohol;

public interface AlcoholDao {

	List<Alcohol> findAll();
	
	Alcohol find();

}
