package com.example.juststickers.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.juststickers.entity.Contact;
public interface ContactRepo extends JpaRepository<Contact, Long> {

	
	@Query(value="select * from contacts c where c.status = :openMessage ",
			nativeQuery=true)
	List<Contact> findContactByStatusWithNativeQuery(@Param("openMessage")String openMessage);


}
