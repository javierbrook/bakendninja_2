package com.udemy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.model.ContactModel;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

	@GetMapping("/checkrest")
	public ResponseEntity<ContactModel> checkrest(){
		ContactModel cm = new ContactModel(2, "Pedro", "Perez", "123456", "Madrid");
		return new ResponseEntity<ContactModel>(cm, HttpStatus.OK);
	}
}
