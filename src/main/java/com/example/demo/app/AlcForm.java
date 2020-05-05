package com.example.demo.app;

import java.time.LocalDateTime;

import javax.validation.constraints.Digits;

public class AlcForm {
	
	@Digits(integer = 3, fraction = 0)
	private int vol;
	
	private int alcVol;

	private String name;
	
	private LocalDateTime time;
	
	public AlcForm() {}
	
	public AlcForm(
			int vol,
			int alcVol,
			String name,
			LocalDateTime time) {
		this.vol = vol;
		this.name = name;
		this.time = time;
		
	}

	public int getVol() {
		return vol;
	}

	public void setVol(int vol) {
		this.vol = vol;
	}

	public int getAlcVol() {
		return alcVol;
	}

	public void setAlcVol(int alcVol) {
		this.alcVol = alcVol;
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
