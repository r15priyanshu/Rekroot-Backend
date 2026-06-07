package com.anshuit.rekroot.services;

import com.anshuit.rekroot.dtos.CompanyDto;
import com.anshuit.rekroot.dtos.ContactDto;
import com.anshuit.rekroot.entities.Company;
import com.anshuit.rekroot.entities.Contact;

public interface DataTransferService {
    CompanyDto mapCompanyToCompanyDto(Company company);

    Company mapCompanyDtoToCompany(CompanyDto companyDto);

    ContactDto mapContactToContactDto(Contact contact);

    Contact mapContactDtoToContact(ContactDto contactDto);
}
