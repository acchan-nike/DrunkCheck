package com.example.demo.app;

import java.math.BigDecimal;
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
import com.example.demo.entity.User;
import com.example.demo.repository.AlcoholDaoImpl;
import com.example.demo.repository.DrinkRecordDaoImpl;
import com.example.demo.repository.UserDaoImpl;

@Controller
@RequestMapping("/drunkcheck")
public class CheckController {
	
	private final AlcoholDaoImpl alcohol;
	private final DrinkRecordDaoImpl drinkList;
	private final UserDaoImpl user;
	private final int testId = 1;
	
	@Autowired
	public CheckController(AlcoholDaoImpl alcohol, DrinkRecordDaoImpl drinkList, UserDaoImpl user) {
		this.alcohol = alcohol;
		this.drinkList = drinkList;
		this.user = user;
	}
	
	@GetMapping
	public String alcList(AlcForm form, Model model) {
		List<Alcohol> list = alcohol.findAll();
		
		//酒一覧を表示する
		model.addAttribute("drinkSelect", list);

		String name = user.userName(testId);
		model.addAttribute("name", name);
		model.addAttribute("user_id", testId);

		//飲酒量合計を取得して状態を表示する
		BigDecimal drinkAlc = drinkList.drinkSum(testId);
		model.addAttribute("status", drinkStatus(drinkAlc));
		
		//飲酒一覧を取得する
		List<DrinkRecord> drink = drinkList.list(testId);
		
		
		//飲酒一覧を表示する
		model.addAttribute("drinkList", drink);
		
		return "drunkcheck/index";
	}
	
	@PostMapping("/insert")
	public String recList(
			@Valid @ModelAttribute AlcForm form,
			BindingResult result,
			Model model) {
		DrinkRecord drink = drinkInsert(form);
		drinkList.insert(drink);
		
		return "redirect:/drunkcheck";
	}
	
	private String drinkStatus(BigDecimal alcohol) {
		String status;
		int i = alcohol.intValue();

		if(i < 5) {
			status = "爽快";
		} else if (i < 10) {
			status = "ほろ酔い";
		} else if (i < 15) {
			status = "酩酊初期";
		} else if (i < 30) {
			status = "酩酊";
		} else if (i < 40) {
			status = "泥酔";
		} else {
			status = "昏睡";
		}
		
		return status;
	}

	private DrinkRecord drinkInsert(AlcForm form) {
		DrinkRecord rec = new DrinkRecord();
		
		rec.setUser_id(form.getUser_id());
		rec.setType_id(form.getType_id());
		rec.setQuantity(form.getQuantity());
		
		return rec;
	}
}
