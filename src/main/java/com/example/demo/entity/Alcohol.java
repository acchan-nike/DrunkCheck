package com.example.demo.entity;

import java.math.BigDecimal;

public class Alcohol {
	private int type_id;
	private String name;
	private BigDecimal vol;
		
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getVol() {
		return vol;
	}
	public void setVol(BigDecimal vol) {
		this.vol = vol;
	}

}
