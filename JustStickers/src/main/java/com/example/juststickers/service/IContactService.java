package com.example.juststickers.service;
import org.springframework.stereotype.Service;

import com.example.juststickers.dto.ContactRequestDto;
@Service
public interface IContactService {


	 boolean saveContact(ContactRequestDto contactRequestDto);
}
