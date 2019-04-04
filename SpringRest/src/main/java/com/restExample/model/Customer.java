package com.restExample.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
    @JsonProperty("Customer_Id")
    private Long custId;

    @JsonProperty("Customer_name")
    private String name;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("Date_of_birth")
    private Date dateOfBirth;

    public Customer(){};


    public Customer(Long custId, String name, String email) {
        this.custId = custId;
        this.name = name;
        this.email = email;
//        this.dateOfBirth = dateOfBirth;

    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
