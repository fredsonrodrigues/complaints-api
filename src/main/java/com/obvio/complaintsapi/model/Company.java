package com.obvio.complaintsapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class Company {

    private String cnpj;
    private String name;
}
