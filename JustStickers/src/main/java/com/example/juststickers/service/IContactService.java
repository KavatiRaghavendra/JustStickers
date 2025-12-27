package com.example.juststickers.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.juststickers.dto.ContactRequestDto;
import com.example.juststickers.dto.ContactResponseDto;

@Service
public interface IContactService {


     boolean saveContact(ContactRequestDto contactRequestDto);

	List<ContactResponseDto> getAllOpenMessages();

	void updateMessageStatus(Long contactId, String closedMessage);
	
	
}
