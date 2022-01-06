package com.udemy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContactModel {

	private int id;
	private String firstname;
	private String lastname;
	private String telephone;
	private String city;
	
}
