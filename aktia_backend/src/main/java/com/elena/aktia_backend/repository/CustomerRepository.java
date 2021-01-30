package com.elena.aktia_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elena.aktia_backend.model.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
       Customer findByName(String name);
   }