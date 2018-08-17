package com.obvio.complaintsapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Complaint {

    @Id
    private String id;

    private String name;

    private String cpf;

    private String title;

    private String description;

    private String city;

    private String state;

    private String company;
}
