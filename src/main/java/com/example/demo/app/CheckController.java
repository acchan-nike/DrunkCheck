package com.example.demo.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Alcohol;
import com.example.demo.entity.DrinkRecord;
import com.example.demo.repository.AlcoholDaoImpl;
import com.example.demo.repository.DrinkRecordImpl;

@Controller
@RequestMapping("/check")
public class CheckController {
	
	private final AlcoholDaoImpl alcohol;
	private final DrinkRecordImpl drinkList;
	
	@Autowired
	public CheckController(AlcoholDaoImpl alcohol, DrinkRecordImpl drinkList) {
		this.alcohol = alcohol;
		this.drinkList = drinkList;
	}
	
	@GetMapping
	public String alcList(AlcForm form, Model model) {
		List<Alcohol> list = alcohol.findAll();
		
		//酒一覧を表示する
		model.addAttribute("drinkSelect", list);
		
		model.addAttribute("name", "あっちゃん");
		model.addAttribute("status", "ほろ酔い");
		
		//飲酒一覧を取得する
		List<DrinkRecord> drink = drinkList.list();
		
		//飲酒一覧を表示する
		model.addAttribute("drinkList", drink);
		
		return "check/index";
	}

}
