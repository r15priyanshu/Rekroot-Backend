package com.anshuit.rekroot.services;

import com.anshuit.rekroot.entities.Contact;
import com.anshuit.rekroot.repositories.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

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
        contact.setCreatedBy("SYSTEM");
        contact.setCreatedAt(Instant.now());
        return this.saveOrUpdateContact(contact);
    }

    @Override
    public Contact getContactById(int id) {
        return null;
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}
