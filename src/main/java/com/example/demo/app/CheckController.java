package com.example.demo.app;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
		
		//飲酒量合計を取得して状態を表示する
		long drinkAlc = drinkList.drinkSum();
		model.addAttribute("total", drinkAlc);
		
		//飲酒一覧を表示する
		model.addAttribute("drinkList", drink);
		
		return "check/index";
	}
	
	@PostMapping("/insert")
	public String recList(
			@Valid @ModelAttribute AlcForm form,
			BindingResult result,
			Model model) {
		
		return "check/index";
	}
	
//	private String drinkStatus(int alcohol) {
//		switch(alcohol) {
//		case (0...10):
//			break;
//		case (11...20):
//			break;
//		
//		}
//		return "";
//	}
	private AlcForm makeAlcForm(Alcohol alc) {
		AlcForm alcForm = new AlcForm();
		return alcForm;
	}

}
