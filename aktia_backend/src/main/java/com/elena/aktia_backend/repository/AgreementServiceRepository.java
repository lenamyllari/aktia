package com.elena.aktia_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elena.aktia_backend.model.AgreementService;

import java.util.Collection;

public interface AgreementServiceRepository extends JpaRepository<AgreementService, Long> {
	Collection<AgreementService> findByAgreementId(Long agreementId);
   }