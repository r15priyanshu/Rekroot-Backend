package com.anshuit.rekroot.controllers;

import com.anshuit.rekroot.dtos.ContactDto;
import com.anshuit.rekroot.entities.Contact;
import com.anshuit.rekroot.services.ContactService;
import com.anshuit.rekroot.services.DataTransferService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    private final DataTransferService dataTransferService;

    @PostMapping("/contacts")
    public ResponseEntity<ContactDto> createContact(@Valid @RequestBody ContactDto contactDto) {
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

    @GetMapping("/contacts/{contactId}")
    public ResponseEntity<ContactDto> getContactById(@Validated @Positive(message = "ContactId must be greater than 0.") @PathVariable int contactId) {
        Contact contact = contactService.getContactByContactId(contactId);
        ContactDto contactDto = dataTransferService.mapContactToContactDto(contact);
        return new ResponseEntity<>(contactDto, HttpStatus.OK);
    }
}
