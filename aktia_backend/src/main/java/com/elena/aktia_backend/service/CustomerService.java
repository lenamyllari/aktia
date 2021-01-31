package com.elena.aktia_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.*;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.elena.aktia_backend.repository.CustomerRepository;
import com.elena.aktia_backend.model.Customer;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Collection<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Customer findById(Long id){
        return customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteById(Long id){
    	customerRepository.deleteById(id);
    }

}