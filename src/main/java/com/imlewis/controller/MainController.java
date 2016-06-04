package com.imlewis.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.imlewis.model.User;
import com.imlewis.repository.UserDao;

@Controller
public class MainController {
	
	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth.getPrincipal() != "anonymousUser") {
			UserDetails userDetails = (UserDetails) auth.getPrincipal();
			User user = userDao.findByEmail(userDetails.getUsername());
			model.addAttribute("user", user);
		}else{
			model.addAttribute("user", "null");
		}
		
		return "index";
	}

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			@RequestParam(value = "success", required = false) String success, HttpServletRequest request,
			Model model) {

		if (error != null) {
			model.addAttribute("error", "Invalid username and password");
		}
		if (logout != null) {
			model.addAttribute("msg", "You have been logout");
		}

		return "login";
	}
}
