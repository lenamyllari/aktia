package com.elena.aktia_backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.elena.aktia_backend.model.Agreement;
import com.elena.aktia_backend.service.AgreementService;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class AgreementController {
	private final Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private AgreementService agreementService;

    @GetMapping("/agreements")
    public Collection<Agreement> findAll(){
        return agreementService.findAll();
    }

    @GetMapping("/agreements/{id}")
    public Agreement findById(@PathVariable Long id){
        return agreementService.findById(id);
    }

    @PostMapping ("/agreements/add")
    public Agreement create(@RequestBody Agreement agreement){
    	log.info("Request to create agreement: {}", agreement);
        return agreementService.save(agreement);
    }

    @PutMapping("/agreements/{id}")
    public Agreement update(@RequestBody Agreement agreement){
    	log.info("Request to update agreement: {}", agreement);
        return agreementService.save(agreement);
    }
    
    @GetMapping("/agreements/customer/{id}")
    public Collection <Agreement> findByCustomerId(@PathVariable Long id){
        return agreementService.findByCustomerId(id);
    }

/*    @DeleteMapping("/agreements/{id}")
    public void deleteById(@PathVariable String id){
    	log.info("Request to delete agreement: {}", id);
    	agreementService.deleteById(id);
    }*/
}