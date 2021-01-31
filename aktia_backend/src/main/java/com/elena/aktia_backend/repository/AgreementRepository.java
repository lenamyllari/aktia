package com.elena.aktia_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elena.aktia_backend.model.Agreement;

import java.util.List;
import java.util.Optional;
import java.util.Collection;

public interface AgreementRepository extends JpaRepository<Agreement, Long> {
	//List<Agreement> findAll(); 
	//Agreement findById(Long id);
	Collection<Agreement> findByCustomerId(Long customerId);
	 //Optional<Agreement> findByIdAndCustomerId(Long id, Long customerId);
	 
	// List<Agreement> findByAgreementType(int agreementType);
   }