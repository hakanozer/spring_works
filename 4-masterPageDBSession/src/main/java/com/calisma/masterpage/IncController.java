package com.calisma.masterpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IncController {
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu() {
		return "inc/menu";
	}
	
	@RequestMapping(value = "/header", method = RequestMethod.GET)
	public String header() {
		return "inc/header";
	}

}
