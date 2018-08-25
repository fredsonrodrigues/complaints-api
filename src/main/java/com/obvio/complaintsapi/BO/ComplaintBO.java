package com.obvio.complaintsapi.BO;

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
    public Complaint saveComplaint(Complaint complaint) { return cr.save(complaint); }

    @Override
    public Complaint editComplaint(Complaint complaint) { return cr.save(complaint); }

    @Override
    public void deleteComplaint(String id) {
        Complaint c = cr.findComplaintById(id);
        cr.delete(c);
    }

    @Override
    public List<Complaint> getComplaintsbyCity(String city) { return cr.findByCity(city); }

    @Override
    public List<Complaint> getComplaintsbyCompany(String company) { return cr.findByCompany(company); }

    @Override
    public List<Complaint> getComplaintsbyCompanyAndCity(String company, String city) {
        return cr.findByCompanyAndCity(company, city);
    }
}
