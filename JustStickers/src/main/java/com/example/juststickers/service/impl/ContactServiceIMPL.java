package com.example.juststickers.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.juststickers.Repo.ContactRepo;
import com.example.juststickers.dto.ContactRequestDto;
import com.example.juststickers.entity.Contact;
import com.example.juststickers.service.IContactService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactServiceIMPL implements IContactService {
 
         private final  ContactRepo contactRepo;
     
    @Override
    public boolean saveContact(ContactRequestDto contactRequestDto) {
       Contact contact = transformToEntity(contactRequestDto);
        contactRepo.save(contact);
        return true;
    }

     private Contact transformToEntity(ContactRequestDto contactRequestDto) {
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactRequestDto, contact);
        contact.setStatus("OPEN");
        return contact;
    }
    
}
