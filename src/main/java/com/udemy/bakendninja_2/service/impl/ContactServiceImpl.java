package com.udemy.bakendninja_2.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.bakendninja_2.converter.ContactConverter;
import com.udemy.bakendninja_2.entity.Contact;
import com.udemy.bakendninja_2.model.ContactModel;
import com.udemy.bakendninja_2.repository.ContactRepository;
import com.udemy.bakendninja_2.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepository contactRepository;
	@Autowired
	private ContactConverter contactConverter;
	
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		return contactConverter.convertContactToContactModel(contactRepository.save(contactConverter.convertContactModelToContact(contactModel)));
	}

	@Override
	public List<ContactModel> listAllContacts() {
		List<Contact> contacts = contactRepository.findAll();
		List<ContactModel> contactsModel = new ArrayList<ContactModel>();
		for(Contact contact : contacts) {
			contactsModel.add(contactConverter.convertContactToContactModel(contact));
		}
		return contactsModel;
	}

	@Override
	public ContactModel findContactById(int id) {
		return contactConverter.convertContactToContactModel(contactRepository.findById(id));
	}

	@Override
	public void removedContact(int id) {
		Contact contact = contactRepository.findById(id);
		if(contact != null) {
			contactRepository.delete(contact);
		}
	}

}
