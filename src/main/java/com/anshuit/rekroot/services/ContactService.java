package com.anshuit.rekroot.services;

import com.anshuit.rekroot.entities.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    Contact createContact(Contact contact);

    Optional<Contact> getContactByContactIdOptional(int contactId);

    Contact getContactByContactId(int contactId);

    List<Contact> getAllContacts();
}
