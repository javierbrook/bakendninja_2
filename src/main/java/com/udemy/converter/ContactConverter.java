package com.udemy.converter;

import org.springframework.stereotype.Component;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactConverter.
 */
@Component
public class ContactConverter {
	
	/**
	 * Convert contact model to contact.
	 *
	 * @param contactModel the contact model
	 * @return the contact
	 */
	public Contact convertContactModelToContact(ContactModel contactModel) {
		Contact contact = new Contact();
		contact.setId(contactModel.getId());
		contact.setCity(contactModel.getCity());
		contact.setFirstname(contactModel.getFirstname());
		contact.setLastname(contactModel.getLastname());
		contact.setTelephone(contactModel.getTelephone());
		return contact;
	}
	
	/**
	 * Convert contact to contact model.
	 *
	 * @param contact the contact
	 * @return the contact model
	 */
	public ContactModel convertContactToContactModel(Contact contact) {
		ContactModel contactModel = new ContactModel();
		contactModel.setId(contact.getId());
		contactModel.setCity(contact.getCity());
		contactModel.setFirstname(contact.getFirstname());
		contactModel.setLastname(contact.getLastname());
		contactModel.setTelephone(contact.getTelephone());
		return contactModel;
	}
	
}
