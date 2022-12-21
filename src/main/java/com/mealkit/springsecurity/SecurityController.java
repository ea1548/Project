package com.mealkit.springsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

	@RequestMapping("/403_errorPage")
	public String ErrorPage_403() {
		return "/login/403_errorPage";
	}
}
