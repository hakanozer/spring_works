package com.calisma.giris;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/iletisim", method = RequestMethod.GET)
	public ModelAndView iletisim() {
		ModelAndView md = new ModelAndView();
		md.addObject("Bu sadece bir yazıdır");
		return md;
	}
	
	
}
