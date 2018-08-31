package com.obvio.complaintsapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
public class Complaint {

    @Id
    private String id;

    private String name;

    private String cpf;

    private String title;

    private String description;

    private Location location;

    private Company company;
}
