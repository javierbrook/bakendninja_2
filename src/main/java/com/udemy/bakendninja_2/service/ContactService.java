package com.udemy.bakendninja_2.service;

import java.util.List;

import com.udemy.bakendninja_2.model.ContactModel;

public interface ContactService {
	
	ContactModel addContact(ContactModel contactModel);
	
	List<ContactModel> listAllContacts();
	
	ContactModel findContactById(int id);
	
	void removedContact(int contact);
}
