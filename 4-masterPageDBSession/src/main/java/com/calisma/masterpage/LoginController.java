package com.calisma.masterpage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	DB db = new DB();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	
	// user login
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public String userLogin(
			@RequestParam String mail,
			@RequestParam String pass,
			@RequestParam(defaultValue = "") String remember,
			HttpServletRequest req,
			HttpServletResponse res) {
		
		try {
			String query = "select * from user where mail = ? and pass = ?";
			PreparedStatement pre = db.preBaglan(query);
			pre.setString(1, mail);
			pre.setString(2, DB.MD5(pass));
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				int id = rs.getInt("uid");
				req.getSession().setAttribute("name", name);
				req.getSession().setAttribute("surname", surname);
				req.getSession().setAttribute("uid", id);
				
				// cerez kontrol
				if (!remember.equals("")) {
					Cookie cookie = new Cookie("userCookie", DB.sifrele(""+id, 2));
					cookie.setMaxAge(60);
					res.addCookie(cookie);
				}
				
				return "redirect:dashboard";
			}else {
				System.out.println("kullanıcı adı yada şifre hatalı ");
			}
		} catch (Exception e) {
			System.err.println("SQL Hatasi : " + e);
		}
		
		return "login";
	}
	
	// logout fnc
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest req) {
		//req.getSession().invalidate(); // tüm sessionları sil
		req.getSession().removeAttribute("uid"); // tekil session silme
		return "redirect:/";
	}
	
	
}
