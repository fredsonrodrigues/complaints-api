package com.obvio.complaintsapi.repository;

import com.obvio.complaintsapi.model.Company;
import com.obvio.complaintsapi.model.Complaint;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintRepository extends MongoRepository<Complaint, String> {

    Complaint findComplaintById(String id);

    @Query("{'location.city': ?0}")
    List<Complaint> findByLocation(String city);

    @Query(value = "{'company.id': ?0, 'location.city': ?1}", count = true)
    int countByCompanyAndCity(String company, String city);

    @Query("{'company.cnpj': ?0}")
    List<Complaint> findByCompany(String company);

    @Query(value = "{'company.id': ?0, 'location.city': ?1}", count = false)
    List<Complaint> findByCompanyAndCity(String company, String city);
}
