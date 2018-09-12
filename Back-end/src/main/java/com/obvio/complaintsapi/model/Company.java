package com.obvio.complaintsapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "company")
@Data
public class Company {

    @Id
    private String id;
    private String cnpj;
    private String name;
}
