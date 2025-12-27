package com.example.juststickers.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import com.example.juststickers.Repo.ContactRepo;
import com.example.juststickers.constants.ApplicationConstants;
import com.example.juststickers.dto.ContactRequestDto;
import com.example.juststickers.dto.ContactResponseDto;
import com.example.juststickers.entity.Contact;
import com.example.juststickers.exception.ResourceNotFoundException;
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
        contact.setStatus(ApplicationConstants.OPEN_MESSAGE);
        return contact;
    }

	@Override
	public List<ContactResponseDto> getAllOpenMessages() {
		List<Contact> contact=contactRepo.findContactByStatusWithNativeQuery(ApplicationConstants.OPEN_MESSAGE);
		   return contact.stream().map(this::mapToContactResponseDTO).collect(Collectors.toList());

	}
	

	private ContactResponseDto mapToContactResponseDTO(Contact contact) {
        ContactResponseDto responseDTO = new ContactResponseDto(
                contact.getContactId(),
                contact.getName(),
                contact.getEmail(),
                contact.getMobileNumber(),
                contact.getMessage(),
                contact.getStatus()
        );
        return responseDTO;
    }

	 @Override
	    public void updateMessageStatus(Long contactId, String status) {
	        Contact contact = contactRepo.findById(contactId).orElseThrow(
	                () -> new ResourceNotFoundException("Contact", "ContactID", contactId.toString())
	        );
	        contact.setStatus(status);
	        contactRepo.save(contact);
	    }
}
