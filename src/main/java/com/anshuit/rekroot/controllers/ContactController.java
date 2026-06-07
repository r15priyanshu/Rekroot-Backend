package com.anshuit.rekroot.controllers;

import com.anshuit.rekroot.dtos.ContactDto;
import com.anshuit.rekroot.entities.Contact;
import com.anshuit.rekroot.services.ContactService;
import com.anshuit.rekroot.services.DataTransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    private final DataTransferService dataTransferService;

    @PostMapping("/contacts")
    public ResponseEntity<ContactDto> createContact(@RequestBody ContactDto contactDto) {
        Contact contact = dataTransferService.mapContactDtoToContact(contactDto);
        Contact createdContact = contactService.createContact(contact);
        ContactDto createdContactDto = dataTransferService.mapContactToContactDto(createdContact);
        return new ResponseEntity<>(createdContactDto, HttpStatus.CREATED);
    }

    @GetMapping("/contacts")
    public ResponseEntity<List<ContactDto>> getAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        List<ContactDto> contactDtos = contacts.stream().map(contact -> dataTransferService.mapContactToContactDto(contact)).toList();
        return new ResponseEntity<>(contactDtos, HttpStatus.OK);
    }
}
