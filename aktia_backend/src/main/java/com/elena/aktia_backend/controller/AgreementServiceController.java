package com.elena.aktia_backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.elena.aktia_backend.model.AgreementService;
import com.elena.aktia_backend.service.AgreementServiceService;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class AgreementServiceController {
	private final Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private AgreementServiceService agreementServiceService;

    @GetMapping("/agreementServices")
    public Collection<AgreementService> findAll(){
        return agreementServiceService.findAll();
    }

    @GetMapping("/agreementServices/{id}")
    public AgreementService findById(@PathVariable Long id){
        return agreementServiceService.findById(id);
    }

    @PostMapping("/agreementServices/add")
    public AgreementService create(@RequestBody AgreementService agreementService){
    	log.info("Request to create agreementService: {}", agreementService);
        return agreementServiceService.save(agreementService);
    }

    @PutMapping("/agreementServices/{id}")
    public AgreementService update(@RequestBody AgreementService agreementService){
    	log.info("Request to update agreementService: {}", agreementService);
        return agreementServiceService.save(agreementService);
    }
    
    @GetMapping("/agreementsServices/agreement/{id}")
    public Collection <AgreementService> findByAgreementId(@PathVariable Long id){
        return agreementServiceService.findByAgreementId(id);
    }

/*    @DeleteMapping("/agreementServices/{id}")
    public void deleteById(@PathVariable String id){
    	log.info("Request to delete agreementService: {}", id);
    	agreementServiceService.deleteById(id);
    }*/
}