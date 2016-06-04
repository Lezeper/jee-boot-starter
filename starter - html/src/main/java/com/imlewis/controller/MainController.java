package com.imlewis.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
		
		String username = "null";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.getPrincipal() != "anonymousUser"){
			UserDetails userDetails = (UserDetails)auth.getPrincipal();
			username = userDetails.getUsername();
		}
		model.addAttribute("username", username);
        return "index";
    }
	
	@RequestMapping("/login")
	public String login(String logout, Model model){
		model.addAttribute("logout", logout);
		return "login";
	}
	
	@RequestMapping("/admin")
	public String admin(){
		return "admin/index";
	}
}
