package com.calisma.bootrest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired DriverManagerDataSource xyz;
	
	DB db = new DB();

	@RequestMapping(value = "/allUser", method = RequestMethod.GET)
	public HashMap<String, Object> allUser() {
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("users", dataResult());
		return hm;
	}
	
	
	public List<User> dataResult() {
		List<User> ls = new ArrayList<User>();
		try {
			String query = "select * from user";
			ResultSet rs = db.preBaglan(query).executeQuery();
			while(rs.next()) {
				User us = new User();
				us.setUid(rs.getInt("uid"));
				us.setName(rs.getString("name"));
				us.setSurname(rs.getString("surname"));
				us.setMail(rs.getString("mail"));
				us.setPass(rs.getString("pass"));
				ls.add(us);
			}
		} catch (Exception e) {
			System.err.println("Hata : " + e);
		}
		return ls;
	}
	
	
	// insert user
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public HashMap<String, Object> insert(@RequestBody User us) {
		HashMap<String, Object> hm = new HashMap<>();
		try {
			String query = "insert into user values(null, ?, ?, ?, ?)";
			PreparedStatement pre = db.preBaglan(query);
			pre.setString(1, us.getName());
			pre.setString(2, us.getSurname());
			pre.setString(3, us.getMail());
			pre.setString(4, DB.MD5(us.getPass()));
			int statu = pre.executeUpdate();
			if(statu > 0) {
				hm.put("statu", true);
				hm.put("message", "Ekleme işlemi başarılı");
			}else {
				hm.put("statu", false);
				hm.put("message", "Ekleme işlemi sırasında bir hata oluştu");
			}
		} catch (Exception e) {
			System.err.println("Hata : " + e);
		}
		return hm;
	}
	
	// delete user
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public HashMap<String, Object> delete(int id) {
		HashMap<String, Object> hm = new HashMap<>();
		try {
			String query = "delete from user where uid = ?";
			PreparedStatement pre = xyz.getConnection().prepareStatement(query);
			pre.setInt(1, id);
			int statu = pre.executeUpdate();
			if (statu > 0) {
				hm.put("statu", true);
				hm.put("message", "Silme işlemi başarılı");
			}else {
				hm.put("statu", false);
				hm.put("message", "Silme hatasi");
			}
		} catch (Exception e) {
			System.err.println("delete error : " + e);
			hm.put("statu", false);
			hm.put("message", "Silme hatasi");
		}
		return hm;
	}
	
	
	
}
