package com.obvio.complaintsapi.repository;

import com.obvio.complaintsapi.model.Complaint;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintRepository extends MongoRepository<Complaint, String> {

    Complaint findComplaintById(String id);

    List<Complaint> findByCity(String city);

    @Query("{'company.name': ?0}")
    List<Complaint> findByCompany(String company);

    @Query(value = "{'company.name': ?0, 'city': ?1}", count = true)
    List<Complaint> findByCompanyAndCity(String company, String city);
}
