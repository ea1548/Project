package com.mealkit.food;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FoodController {
	

	@RequestMapping("/korea")
	public String korea() {
		return "/koreanfood/koreanfood";
	}
	
	@RequestMapping("/chinese")
	public String chinese() {
		return "/chinesefood/chinesefood";
	}
	
	@RequestMapping("/japanesefood")
	public String japanese() {
		return "/japanesefood/japanesefood";
	}
	
	@RequestMapping("/western")
	public String western() {
		return "/westernfood/westernfood";
	}
	
}
