package com.anshuit.rekroot.services;

import com.anshuit.rekroot.entities.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Optional<Company> getCompanyByCompanyIdOptional(int companyId);

    Company getCompanyByCompanyId(int companyId);

    List<Company> getAllCompanies();
}
