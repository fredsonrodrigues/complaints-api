package com.obvio.complaintsapi.BO;

        import com.obvio.complaintsapi.model.Company;
        import com.obvio.complaintsapi.model.Complaint;
        import com.obvio.complaintsapi.repository.ComplaintRepository;
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
    public List<CountCompanyResponse> getComplaintsbyCity(String city) {
        List<CountCompanyResponse> ccr = new ArrayList<>();
        Set<Company> companyList = new HashSet<>();

        for (Complaint c : cr.findByCity(city)) {
            companyList.add(c.getCompany());
        }

        for (Company comp: companyList) {
            CountCompanyResponse cc = new CountCompanyResponse();
            cc.setCompany(comp.getName());
            cc.setCount(String.valueOf(cr.countByCompanyAndCity(comp.getCnpj(), city)));
            ccr.add(cc);
        }
        return ccr;
    }

    @Override
    public List<Complaint> getComplaintsbyCompany(String company) {
        return cr.findByCompany(company);
    }

    @Override
    public List<Complaint> getComplaintsbyCompanyAndCity(String company, String city) {
        return cr.findByCompanyAndCity(company, city);
    }
}
