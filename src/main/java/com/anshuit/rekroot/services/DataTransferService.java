package com.anshuit.rekroot.services;

import com.anshuit.rekroot.dtos.CompanyDto;
import com.anshuit.rekroot.dtos.ContactDto;
import com.anshuit.rekroot.dtos.JobDto;
import com.anshuit.rekroot.entities.Company;
import com.anshuit.rekroot.entities.Contact;
import com.anshuit.rekroot.entities.Job;

public interface DataTransferService {
    CompanyDto mapCompanyToCompanyDto(Company company, boolean fetchFull);

    Company mapCompanyDtoToCompany(CompanyDto companyDto);

    ContactDto mapContactToContactDto(Contact contact);

    Contact mapContactDtoToContact(ContactDto contactDto);

    JobDto mapJobToJobDto(Job job, boolean fetchFull);

    Job mapJobDtoToJob(JobDto jobDto);
}
