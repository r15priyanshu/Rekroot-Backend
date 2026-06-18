package com.anshuit.rekroot.services;

import com.anshuit.rekroot.entities.Contact;
import com.anshuit.rekroot.enums.ErrorResponseDetailsEnum;
import com.anshuit.rekroot.exceptions.CustomException;
import com.anshuit.rekroot.repositories.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    private Contact saveOrUpdateContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact createContact(Contact contact) {
        contact.setStatus("NEW");
        return this.saveOrUpdateContact(contact);
    }

    @Override
    public Optional<Contact> getContactByContactIdOptional(int contactId) {
        return contactRepository.findById(contactId);
    }

    @Override
    public Contact getContactByContactId(int contactId) {
        return getContactByContactIdOptional(contactId).orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, ErrorResponseDetailsEnum.CONTACT_NOT_FOUND_WITH_ID, contactId));
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}
