package com.obvio.complaintsapi.bo;

import com.obvio.complaintsapi.model.Complaint;
import com.obvio.complaintsapi.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintBO implements IComplaintBO {

    @Autowired
    private ComplaintRepository cr;


    @Override
    public List<Complaint> getAllComplaints() {
        return cr.findAll();
    }

    @Override
    public List<Complaint> getAllComplaintsByCompany(String company) {
        return null;
    }

    @Override
    public Complaint saveComplaint(Complaint complaint) {
        return cr.save(complaint);
    }

    @Override
    public Complaint editComplaint(Complaint complaint) {
        return cr.save(complaint);
    }

    @Override
    public void deleteComplaint(String id) {
        Complaint c = cr.findComplaintById(id);
        cr.delete(c);
    }
}
