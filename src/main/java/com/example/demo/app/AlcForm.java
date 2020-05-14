package com.example.demo.app;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class AlcForm {
	
	private int type_id;
	
	private int user_id;
	
	@Digits(integer = 3, fraction = 0)
	@Max(999)
	@Min(1)
	private BigDecimal quantity;
	
	private String name;
	
	private LocalDateTime time;
	
	public AlcForm() {}
	
	public AlcForm(
			int uid,
			int tid,
			BigDecimal vol,
			String name,
			LocalDateTime time) {
		this.user_id = uid;
		this.type_id = tid;
		this.quantity = vol;
		this.name = name;
		this.time = time;
		
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

}
