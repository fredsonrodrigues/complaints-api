package com.obvio.complaintsapi.BO.impl;

import com.obvio.complaintsapi.BO.IComplaintBO;
import com.obvio.complaintsapi.model.Company;
import com.obvio.complaintsapi.model.Complaint;
import com.obvio.complaintsapi.model.Location;
import com.obvio.complaintsapi.repository.ComplaintRepository;
import com.obvio.complaintsapi.responses.CountCityResponse;
import com.obvio.complaintsapi.responses.CountCompanyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ComplaintBO implements IComplaintBO {

    @Autowired
    private ComplaintRepository cr;

    // --- Métodos criados para alimentar a base ----
    @Override
    public List<Complaint> getAllComplaints() {
        return cr.findAll();
    }

    @Override
    public List<Complaint> getAllComplaintsByCompany(String company) {
        return null;
    }

    @Override
    public Complaint saveComplaint(Complaint complaint) { return cr.save(complaint); }

    @Override
    public Complaint editComplaint(Complaint complaint) { return cr.save(complaint); }

    @Override
    public void deleteComplaint(String id) {
        Complaint c = cr.findComplaintById(id);
        cr.delete(c);
    }

    // ---- Métodos criados para alimentar a base -----

    @Override
    public Set<Location> getAllLocations() {
        Set<Location> locations = new HashSet<>();

        for (Complaint c : cr.findAll()) {
            locations.add(c.getLocation());
        }
        return locations;
    }

    @Override
    public List<CountCompanyResponse> getComplaintsbyCity(String city) {
        List<CountCompanyResponse> ccr = new ArrayList<>();
        Set<Company> companyList = new HashSet<>();

        for (Complaint c : cr.findByLocation(city)) {
            companyList.add(c.getCompany());
        }

        for (Company comp: companyList) {
            CountCompanyResponse cc = new CountCompanyResponse();
            cc.setCompany(comp.getName());
            cc.setComplaints(String.valueOf(cr.countByCompanyAndCity(comp.getId(), city)));
            ccr.add(cc);
        }
        return ccr;
    }

    @Override
    public List<CountCityResponse> getComplaintsbyCompany(String company) {
        List<CountCityResponse> countCityResponses = new ArrayList<>();
        Set<Location> locationsList = new HashSet<>();

        for (Complaint c : cr.findByCompany(company)) {
            locationsList.add(c.getLocation());
        }

        for (Location loc: locationsList) {
            CountCityResponse ccr = new CountCityResponse();
            ccr.setCity(loc.getCity());
            ccr.setState(loc.getState());
            ccr.setComplaints(String.valueOf(cr.countByCompanyAndCity(company, loc.getCity())));
            countCityResponses.add(ccr);
        }
        return countCityResponses;
    }

    @Override
    public List<Complaint> getComplaintsbyCompanyAndCity(String company, String city) {
        return cr.findByCompanyAndCity(company, city);
    }
}
