package com.example.demo.entity;

import java.time.LocalDateTime;

public class DrinkRecord {
	private int id;
	private int user_id;
	private int type_id;
	private String name;
	private int quantity;
	private int alc_total;
	private LocalDateTime date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getAlc_total() {
		return alc_total;
	}
	public void setAlc_total(int alc_total) {
		this.alc_total = alc_total;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}
