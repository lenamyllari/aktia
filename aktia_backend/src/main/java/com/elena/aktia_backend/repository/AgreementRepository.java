package com.elena.aktia_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elena.aktia_backend.model.Agreement;

import java.util.List;
import java.util.Optional;

public interface AgreementRepository extends JpaRepository<Agreement, Long> {
	//List<Agreement> findAll(); 
	
	List<Agreement> findByCustomerId(Long customerId);
	 //Optional<Agreement> findByIdAndCustomerId(Long id, Long customerId);
	 
	// List<Agreement> findByAgreementType(int agreementType);
   }