package com.obvio.complaintsapi.resources;

import com.obvio.complaintsapi.bo.IComplaintBO;
import com.obvio.complaintsapi.model.Complaint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaint")
public class ComplaintResource {

    @Autowired
    private IComplaintBO complaintBO;

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
}
