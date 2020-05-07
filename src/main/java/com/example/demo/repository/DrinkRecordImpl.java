package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Alcohol;
import com.example.demo.entity.DrinkRecord;

@Repository
public class DrinkRecordImpl implements DrinkRecordDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public DrinkRecordImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<DrinkRecord> list() {
		String sql = "SELECT id, user_id, name, quantity FROM drink_record " + 
				"INNER JOIN alcohol_type ON drink_record.type_id = alcohol_type.type_id " +
				"ORDER BY id DESC";
		
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<DrinkRecord> list = new ArrayList<DrinkRecord>();
		
		for(Map<String, Object> recordList : resultList) {
			DrinkRecord drink = new DrinkRecord();
			drink.setId((int)recordList.get("id"));
			drink.setUser_id((int)recordList.get("user_id"));
			drink.setQuantity((BigDecimal)recordList.get("quantity"));
			
			Alcohol alcohol = new Alcohol();
			alcohol.setName((String)recordList.get("name"));
			drink.setName(alcohol.getName());
			
			list.add(drink);
		}

		return list;
	}
	
	@Override
	public BigDecimal drinkSum() {
		String sql = "SELECT SUM(quantity * volume / (833 * weight)) * 100 AS total FROM drink_record " +
				"JOIN user ON drink_record.user_id = user.user_id " + 
				"JOIN alcohol_type ON drink_record.type_id = alcohol_type.type_id";
		
		Map<String, Object> result = jdbcTemplate.queryForMap(sql);
		BigDecimal drinkResult;
		
		drinkResult = (BigDecimal)result.get("total");
		
		return drinkResult;
	}

}
