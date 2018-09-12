package com.obvio.complaintsapi.BO;

import com.obvio.complaintsapi.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICompanyBO {

    List<Company> getAllCompanies();
}
