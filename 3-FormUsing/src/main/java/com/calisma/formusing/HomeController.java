package com.calisma.formusing;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController { 
	
	List<User> ls = new ArrayList<User>();
	
	public HomeController() {
		System.out.println(" HomeController is Called");
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("data", ls);
		return "home";
	}
	
	
	//user insert
	@RequestMapping(value = "/userInsert", method = RequestMethod.POST)
	public String userinsert(User us, Model model){
		if(us.getMail().equals("")) {
			model.addAttribute("hata", "Lütfen mail adresi giriniz!");
		}else {
			if (us.getPass().equals("")) {
				us.setPass("123");
			}
			ls.add(us);
		}
		model.addAttribute("data", ls);
		return "home";
	}
	
}
