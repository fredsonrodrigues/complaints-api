package com.obvio.complaintsapi.repository;

import com.obvio.complaintsapi.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends MongoRepository<Company, String> {


}
