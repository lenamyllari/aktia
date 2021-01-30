package com.elena.aktia_backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.elena.aktia_backend.model.Customer;
import com.elena.aktia_backend.repository.CustomerRepository;
import com.elena.aktia_backend.model.Agreement;
import com.elena.aktia_backend.repository.AgreementRepository;
import com.elena.aktia_backend.model.AgreementService;
import com.elena.aktia_backend.repository.AgreementServiceRepository;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;
import java.time.LocalDateTime;


@Component
class Initializer implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final AgreementRepository agreementRepository;
    private final AgreementServiceRepository agreementServiceRepository;

    public Initializer(CustomerRepository repository, AgreementRepository agreementRep, AgreementServiceRepository agreementServiceRep) {
        this.customerRepository = repository;
        this.agreementRepository = agreementRep;
        this.agreementServiceRepository = agreementServiceRep;
    }

    @Override
    public void run(String... strings) {
        Stream.of(new Customer("Matti Meikäläinen", "eka"), new Customer("Pekka VAnhanen", "toka"), new Customer("Maija Poppanen", "kolmas"),
                new Customer("Anni Toivonen", "neljas")).forEach(customer ->
                customerRepository.save(customer)
        );
        
      /* Customer customer = customerRepository.findByname("Matti Meikäläinen");
        Customer customer2 = customerRepository.findByname("Anni Toivonen");
        Agreement a = Agreement.builder().agreementType(100)
                .startDateTime(LocalDateTime.now())
                .build();
        customer.setAgreements(Collections.singleton(a));
        customerRepository.save(customer);*/
        /*Stream.of(new Agreement(100, LocalDateTime.now(), customer), 
        		new Agreement(200, LocalDateTime.now(), customer), 
        		new Agreement(300, LocalDateTime.now(), customer2),
                new Agreement(400, LocalDateTime.now(), customer2)).forEach(agreement ->
                agreementRepository.save(agreement)
        );
        
        Agreement agreement = agreementRepository.findByType(100);
        Agreement agreement2 = agreementRepository.findByType(200);
        Stream.of(new AgreementService(1, 5.0, agreement), 
        		new AgreementService(1, 15.0, agreement), 
        		new AgreementService(2, 25.0, agreement2),
                new AgreementService(3, 35.0, agreement2)).forEach(agreementService ->
                agreementServiceRepository.save(agreementService)
        );*/


        customerRepository.findAll().forEach(System.out::println);
    }
}
