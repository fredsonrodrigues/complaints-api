package com.obvio.complaintsapi.resources;

import com.obvio.complaintsapi.BO.ICompanyBO;
import com.obvio.complaintsapi.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyResource {

    @Autowired
    private ICompanyBO companyBO;

    @CrossOrigin
    @GetMapping("/")
    public List<Company> getComplaints(){
        return companyBO.getAllCompanies();
    }
}
