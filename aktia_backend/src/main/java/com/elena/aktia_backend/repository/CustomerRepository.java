package com.elena.aktia_backend;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {
       Customer findByName(String name);
   }