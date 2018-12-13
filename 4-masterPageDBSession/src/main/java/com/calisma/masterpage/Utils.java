package com.calisma.masterpage;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Utils {

	public static String loginValidate(HttpServletRequest req, String page) {
		
		if (req.getCookies() != null) {
			Cookie[] dizi = req.getCookies();
			for (Cookie item : dizi) {
				if (item.getName().equals("userCookie")) {
					String id = item.getValue();
					req.getSession().setAttribute("uid", DB.sifreCoz(id, 2));
					break;
				}
			}
		}

		boolean statu = req.getSession().getAttribute("uid") == null;
		if(statu) {
			return "redirect:/";
		}else {
			return page;
		}
	} 
	
	
	
	
}
