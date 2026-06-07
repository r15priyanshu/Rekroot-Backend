package com.anshuit.rekroot.services;

import com.anshuit.rekroot.dtos.CompanyDto;
import com.anshuit.rekroot.dtos.ContactDto;
import com.anshuit.rekroot.entities.Company;
import com.anshuit.rekroot.entities.Contact;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DataTransferServiceImpl implements DataTransferService {

    private final ModelMapper modelMapper;

    public DataTransferServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CompanyDto mapCompanyToCompanyDto(Company company) {
        return modelMapper.map(company, CompanyDto.class);
    }

    @Override
    public Company mapCompanyDtoToCompany(CompanyDto companyDto) {
        return modelMapper.map(companyDto, Company.class);
    }

    @Override
    public ContactDto mapContactToContactDto(Contact contact) {
        return modelMapper.map(contact, ContactDto.class);
    }

    @Override
    public Contact mapContactDtoToContact(ContactDto contactDto) {
        return modelMapper.map(contactDto, Contact.class);
    }
}
