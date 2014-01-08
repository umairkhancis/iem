package com.netpace.iem.umair.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netpace.iem.umair.model.User;
import com.netpace.iem.umair.repository.UserRepository;

@Controller
public class UserController {
	User user;
	UserRepository userRepository;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "user/login";
	}
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
 
		model.addAttribute("error", "true");
		return "user/login";
 
	}
	

//	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
//	public String userLogin(@RequestParam String username,
//							@RequestParam String password, 
//							ModelMap model) {
//
//		user = userRepository.validate(username, password);
//		if (user != null) {
//			model.addAttribute("username", user.getUsername());
//			return "user/welcome";
//		}
//
//		model.addAttribute("isPostBack", true);
//		return "user/login";
//	}
}
