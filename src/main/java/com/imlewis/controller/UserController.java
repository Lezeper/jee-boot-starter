package com.imlewis.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imlewis.model.User;
import com.imlewis.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// Create and Update
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseBody
	public String create(@Valid @ModelAttribute("user") User user, BindingResult result) {
		
		if(result.hasErrors())	
            return "index";
		
        userService.save(user);
        	
		return "User succesfully created! <br><a href='/'>Back</a>";
	}
}
