package com.obvio.complaintsapi.bo;

import com.obvio.complaintsapi.model.Complaint;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IComplaintBO {

    List<Complaint> getAllComplaints();

    List<Complaint> getAllComplaintsByCompany(String company);

    Complaint saveComplaint(Complaint complaint);

    Complaint editComplaint(Complaint complaint);

    void deleteComplaint(String id);
}
