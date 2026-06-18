package com.anshuit.rekroot.controllers;

import com.anshuit.rekroot.dtos.CompanyDto;
import com.anshuit.rekroot.entities.Company;
import com.anshuit.rekroot.services.CompanyService;
import com.anshuit.rekroot.services.DataTransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    private final DataTransferService dataTransferService;

    @GetMapping("/companies")
    public ResponseEntity<List<CompanyDto>> getAllCompanies(@RequestParam(name = "fetchFull") boolean fetchFull) {
        List<Company> allCompanies = companyService.getAllCompanies();
        List<CompanyDto> allCompaniesDto = allCompanies.stream().map(company -> dataTransferService.mapCompanyToCompanyDto(company, fetchFull)).toList();
        return new ResponseEntity<>(allCompaniesDto, HttpStatus.OK);
    }

    @GetMapping("/companies/{companyId}")
    public ResponseEntity<CompanyDto> getCompanyByCompanyId(@PathVariable int companyId, @RequestParam(name = "fetchFull") boolean fetchFull) {
        Company company = companyService.getCompanyByCompanyId(companyId);
        CompanyDto companyDto = dataTransferService.mapCompanyToCompanyDto(company, fetchFull);
        return new ResponseEntity<>(companyDto, HttpStatus.OK);
    }
}
