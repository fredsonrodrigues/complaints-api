package com.obvio.complaintsapi.repository;

import com.obvio.complaintsapi.model.Complaint;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends MongoRepository<Complaint, String> {

    Complaint findComplaintById(String id);
}
