package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.udemy.constant.ViewConstant;
import com.udemy.model.UserCredential;

import lombok.extern.java.Log;

@Log
@Controller
public class LoginController {
	
	@GetMapping("/")
	public String redirectToLogin() {
		log.info("METHOD: redirectToLogin()");
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String showLoginForm(Model model, 
			                    @RequestParam(name="error", required=false) String error,
			                    @RequestParam(name="logout", required=false) String logout) {
		log.info("METHOD: showLoginForm() -- PARAMS: error="+error+", logout="+logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("userCredentials", new UserCredential());
		log.info("Returning to login view");
		return ViewConstant.LOGIN;
	}
	
	@PostMapping("/loginCheck")
	public String loginCheck(@ModelAttribute(name="userCredentials") UserCredential userCredential) {
		log.info("METHOD: loginCheck() -- PARAMS: "+userCredential);
		if(userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")) {
			log.info("Returning to contacts view");
			return ViewConstant.REDIRECT_CONTACTS;
		}
		log.info("Redirect to login view");
		return "redirect:/login?error"; //Se le pasa 'error' para que inicialice la variable error
	}
	
}
