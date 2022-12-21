package com.mealkit.freeboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreeBoardReController {
	
	@RequestMapping("/freeboard/comment")
	public String comment() {
		return "freeboard/comment";
	}
	
	
	
}
