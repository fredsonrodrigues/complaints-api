package com.obvio.complaintsapi.resources;

import com.obvio.complaintsapi.BO.IComplaintBO;
import com.obvio.complaintsapi.model.Complaint;
import com.obvio.complaintsapi.responses.CountCompanyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaint")
public class ComplaintResource {

    @Autowired
    private IComplaintBO complaintBO;

    // ENDPOINTS CRIADOS PARA ALIMENTAR O BANCO
    @GetMapping("/")
    public List<Complaint> getComplaints(){
        return complaintBO.getAllComplaints();
    }

    @PostMapping("/add")
    public Complaint saveComplaint(@RequestBody Complaint c){
        return complaintBO.saveComplaint(c);
    }

    @PutMapping("/edit")
    public Complaint updateComplaint(@RequestBody Complaint c){
        return complaintBO.editComplaint(c);
    }

    @DeleteMapping("/del/{id}")
    public void deleteComplaint(@PathVariable("id") String id){
        complaintBO.deleteComplaint(id);
    }
    // ENDPOINTS CRIADOS PARA ALIMENTAR O BANCO

    @GetMapping("/ByCity/{city}")
    public List<CountCompanyResponse> getComplaintsByCity(@PathVariable("city") String city){
        return complaintBO.getComplaintsbyCity(city);
    }

    @GetMapping("/ByCompany/{company}")
    public List<Complaint> getComplaintsByCompany(@PathVariable("company") String company){
        return complaintBO.getComplaintsbyCompany(company);
    }

    @GetMapping("/ByCompany/{company}/{city}")
    public List<Complaint> getComplaintsByCompanyAndCity(@PathVariable("company") String company, @PathVariable("city") String city){
        return complaintBO.getComplaintsbyCompanyAndCity(company, city);
    }
}
