package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Alcohol;

@Repository
public class AlcoholDaoImpl implements AlcoholDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AlcoholDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Alcohol find() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<Alcohol> findAll() {
		String sql = "SELECT type_id, name, volume FROM alcohol_type";
		
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<Alcohol> list = new ArrayList<Alcohol>();
		
		for(Map<String, Object> drinkList : resultList) {
			Alcohol alcohol = new Alcohol();
			alcohol.setType_id((int)drinkList.get("type_id"));
			alcohol.setName((String)drinkList.get("name"));
			alcohol.setVol((BigDecimal)drinkList.get("volume"));
			
			list.add(alcohol);
		}
		
		return list;
	}

}
