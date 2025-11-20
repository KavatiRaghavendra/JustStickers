package com.example.juststickers.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.juststickers.entity.Contact;
public interface ContactRepo extends JpaRepository<Contact, Long> {


}
