package com.obvio.complaintsapi.responses;

import com.obvio.complaintsapi.model.Company;
import lombok.Data;

@Data
public class CountCompanyResponse {

    public Company company;
    public String complaints;
}
