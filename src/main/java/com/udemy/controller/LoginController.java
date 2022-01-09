package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.constant.ViewConstant;

import lombok.extern.java.Log;

@Log
@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String showLoginForm(Model model, 
			                    @RequestParam(name="error", required=false) String error,
			                    @RequestParam(name="logout", required=false) String logout) {
		log.info("METHOD: showLoginForm() -- PARAMS: error="+error+", logout="+logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		log.info("Returning to login view");
		return ViewConstant.LOGIN;
	}
	
	@GetMapping({"/logincheck","/"})
	public String loginCheck() {
		log.info("METHOD: loginCheck()");
		log.info("Returning to contacts view");
		return ViewConstant.REDIRECT_CONTACTS;				
	}
	
}
