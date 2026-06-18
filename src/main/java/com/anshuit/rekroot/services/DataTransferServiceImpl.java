package com.anshuit.rekroot.services;

import com.anshuit.rekroot.dtos.CompanyDto;
import com.anshuit.rekroot.dtos.ContactDto;
import com.anshuit.rekroot.dtos.JobDto;
import com.anshuit.rekroot.entities.Company;
import com.anshuit.rekroot.entities.Contact;
import com.anshuit.rekroot.entities.Job;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataTransferServiceImpl implements DataTransferService {

    private final ModelMapper modelMapper;

    @Override
    public CompanyDto mapCompanyToCompanyDto(Company company, boolean fetchFull) {
        CompanyDto companyDto = new CompanyDto();

        //AUDIT RELATED
        companyDto.setCreatedBy(company.getCreatedBy());
        companyDto.setCreatedAt(company.getCreatedAt());
        companyDto.setUpdatedBy(company.getUpdatedBy());
        companyDto.setUpdatedAt(company.getUpdatedAt());

        //ENTITY RELATED
        companyDto.setCompanyId(company.getCompanyId());
        companyDto.setName(company.getName());
        companyDto.setLogo(company.getLogo());
        companyDto.setIndustry(company.getIndustry());
        companyDto.setSize(company.getSize());
        companyDto.setRating(company.getRating());
        companyDto.setLocations(company.getLocations());
        companyDto.setFounded(company.getFounded());
        companyDto.setDescription(company.getDescription());
        companyDto.setEmployees(company.getEmployees());
        companyDto.setWebsite(company.getWebsite());

        //FOR FULL/COMPLETE MAPPING
        if (fetchFull) {
            List<JobDto> jobDtos = company.getJobs().stream().map(job -> mapJobToJobDto(job, false)).toList();
            companyDto.setJobs(jobDtos);
        } else {
            companyDto.setJobs(List.of());
        }
        return companyDto;
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

    @Override
    public JobDto mapJobToJobDto(Job job, boolean fetchFull) {
        JobDto jobDto = new JobDto();

        //AUDIT RELATED
        jobDto.setCreatedBy(job.getCreatedBy());
        jobDto.setCreatedAt(job.getCreatedAt());
        jobDto.setUpdatedBy(job.getUpdatedBy());
        jobDto.setUpdatedAt(job.getUpdatedAt());

        //ENTITY RELATED
        jobDto.setJobId(job.getJobId());
        jobDto.setTitle(job.getTitle());
        jobDto.setLocation(job.getLocation());
        jobDto.setWorkType(job.getWorkType());
        jobDto.setJobType(job.getJobType());
        jobDto.setCategory(job.getCategory());
        jobDto.setExperienceLevel(job.getExperienceLevel());
        jobDto.setSalaryMin(job.getSalaryMin());
        jobDto.setSalaryMax(job.getSalaryMax());
        jobDto.setSalaryCurrency(job.getSalaryCurrency());
        jobDto.setSalaryPeriod(job.getSalaryPeriod());
        jobDto.setDescription(job.getDescription());
        jobDto.setRequirements(job.getRequirements());
        jobDto.setBenefits(job.getBenefits());
        jobDto.setPostedDate(job.getPostedDate());
        jobDto.setApplicationDeadline(job.getApplicationDeadline());
        jobDto.setApplicationsCount(job.getApplicationsCount());
        jobDto.setFeatured(job.isFeatured());
        jobDto.setUrgent(job.isUrgent());
        jobDto.setRemote(job.isRemote());
        jobDto.setStatus(job.getStatus());

        if (fetchFull) {
            jobDto.setCompany(mapCompanyToCompanyDto(job.getCompany(),false));
        } else {
            jobDto.setCompany(null);
        }
        return jobDto;
    }

    @Override
    public Job mapJobDtoToJob(JobDto jobDto) {
        return modelMapper.map(jobDto, Job.class);
    }
}
