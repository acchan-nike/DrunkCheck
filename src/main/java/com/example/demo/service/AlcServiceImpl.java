package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.entity.Alcohol;

public class AlcServiceImpl implements AlcService {
	
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public AlcServiceImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Alcohol> findAll() {
		String sql = "SELECT name, volume, quantity, datetime FROM alcohol_type INNER JOIN "
				+ "drink_record ON alcohol_type.type_id = drink_record.type_id";
		
		List<Map<String, Object>> list = null;
		return null;
	}

}
