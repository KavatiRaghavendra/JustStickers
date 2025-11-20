package com.example.juststickers.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "contacts")
public class Contact {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long contactId;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "mobile_number", length = 10)
    private String mobileNumber;

    @Column(name = "message", length = 500)
    private String message;

     @Column(name = "status", length = 50)
    private String status = "Pending";

}
