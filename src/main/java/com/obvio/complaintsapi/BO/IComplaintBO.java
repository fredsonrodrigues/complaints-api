package com.obvio.complaintsapi.BO;

import com.obvio.complaintsapi.model.Complaint;
import com.obvio.complaintsapi.responses.CountCityResponse;
import com.obvio.complaintsapi.responses.CountCompanyResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IComplaintBO {

    List<Complaint> getAllComplaints();

    List<Complaint> getAllComplaintsByCompany(String company);

    Complaint saveComplaint(Complaint complaint);

    Complaint editComplaint(Complaint complaint);

    void deleteComplaint(String id);

    List<CountCompanyResponse> getComplaintsbyCity(String city);

    List<CountCityResponse> getComplaintsbyCompany(String company);

    List<Complaint> getComplaintsbyCompanyAndCity(String company, String city);
}
