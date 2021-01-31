package com.elena.aktia_backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.elena.aktia_backend.model.Customer;
import com.elena.aktia_backend.service.CustomerService;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class CustomerController {
	private final Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

    @GetMapping("/customers")
    public Collection<Customer> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer findById(@PathVariable Long id){
        return customerService.findById(id);
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer){
    	log.info("Request to create customer: {}", customer);
        return customerService.save(customer);
    }

    @PutMapping("/{id}")
    public Customer update(@RequestBody Customer customer){
    	log.info("Request to update customer: {}", customer);
        return customerService.save(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
    	log.info("Request to delete customer: {}", id);
    	customerService.deleteById(id);
    }
}