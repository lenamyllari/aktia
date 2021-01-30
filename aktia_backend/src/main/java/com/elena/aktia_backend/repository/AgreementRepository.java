package com.elena.aktia_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elena.aktia_backend.model.Agreement;

import java.util.List;

public interface AgreementRepository extends JpaRepository<Agreement, Long> {
	
   }