package com.calisma.users;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String userOpen(Model model) {
		model.addAttribute("data", "Spring mvc and Data");
		return "user";
	}

}
