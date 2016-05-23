package com.imlewis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imlewis.dao.UserDao;
import com.imlewis.model.User;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping
	public String getAllUser(Model model){
		List<User> users = (List<User>) userDao.findAll();
		model.addAttribute("users", users);
		return "admin/index";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			User user = new User(id);
			userDao.delete(user);
		} catch (Exception ex) {
			return "Error deleting the user:" + ex.toString();
		}
		return "User succesfully deleted!";
	}

	@RequestMapping("/get-by-email")
	@ResponseBody
	public String getByEmail(String email) {
		String userId;
		try {
			User user = userDao.findByEmail(email);
			userId = String.valueOf(user.getUserId());
		} catch (Exception ex) {
			return "User not found";
		}
		return "The user id is: " + userId;
	}
}
