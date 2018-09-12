package com.obvio.complaintsapi.responses;

import lombok.Data;

@Data
public class CountCityResponse {

    public String city;
    public String state;
    public String complaints;
}