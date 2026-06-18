package com.anshuit.rekroot.services;

import com.anshuit.rekroot.entities.Company;
import com.anshuit.rekroot.enums.ErrorResponseDetailsEnum;
import com.anshuit.rekroot.exceptions.CustomException;
import com.anshuit.rekroot.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public Optional<Company> getCompanyByCompanyIdOptional(int companyId) {
        return companyRepository.findById(companyId);
    }

    @Override
    public Company getCompanyByCompanyId(int companyId) {
        return getCompanyByCompanyIdOptional(companyId).orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, ErrorResponseDetailsEnum.COMPANY_NOT_FOUND_WITH_ID, companyId));
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}
