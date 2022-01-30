package com.udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.constant.ViewConstant;
import com.udemy.model.ContactModel;
import com.udemy.service.ContactService;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/contacts")
@Log
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contactform")
	public String redirectContactForm(@RequestParam(name="id", required = true) int id, Model model) {
		ContactModel contactModel = id==0?new ContactModel():contactService.findContactById(id);
		model.addAttribute("contactModel", contactModel);
		return ViewConstant.CONTACT_FORM;
	}
	
	@GetMapping("/cancel")
	public String cancel() {
		return ViewConstant.REDIRECT_CONTACTS;
	}
	
	@PostMapping("/addcontact")
	public String addContact(@ModelAttribute(name="contactModel") ContactModel contactModel, Model model) {
		log.info("METHOD: addContact() -- PARAMS: "+contactModel);
		if(contactService.addContact(contactModel) != null) {
			model.addAttribute("result", 1);
		}else {
			model.addAttribute("result", 0);
		}
		return ViewConstant.REDIRECT_CONTACTS;
	}
	
	@GetMapping("/showcontacts")
	public ModelAndView showContacts() {
		ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username", user.getUsername());
		mav.addObject("contacts", contactService.listAllContacts());
		return mav;
	}
	
	@PreAuthorize("hasRole('ADMIN')")  // ó '@PreAuthorize("hasAuthority('ROLE_ADMIN')")'
	@GetMapping("/removecontact")    //Debería usarse Post pero se usa Get para no usar Ajax ni javascript en la vista
	public String removeContact(@RequestParam(name="id", required = true) int id) {
		contactService.removedContact(id);
		return ViewConstant.REDIRECT_CONTACTS;
	}
}
