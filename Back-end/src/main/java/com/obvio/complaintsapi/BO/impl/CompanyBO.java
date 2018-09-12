package com.obvio.complaintsapi.BO.impl;

import com.obvio.complaintsapi.BO.ICompanyBO;
import com.obvio.complaintsapi.model.Company;
import com.obvio.complaintsapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyBO implements ICompanyBO {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}
