package com.anshuit.rekroot.services;

import com.anshuit.rekroot.entities.Contact;

import java.util.List;

public interface ContactService {
    Contact createContact(Contact contact);

    Contact getContactById(int id);

    List<Contact> getAllContacts();
}
