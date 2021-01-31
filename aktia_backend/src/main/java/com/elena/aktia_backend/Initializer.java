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
        
       Customer customer = customerRepository.findByName("Matti Meikäläinen");
        Agreement a = Agreement.builder().agreementType(100)
                .startDateTime(LocalDateTime.now())
                .customer(customer)
                .build();
        customer.setAgreements(Collections.singleton(a));
        customerRepository.save(customer);

        
       
        Customer customer2 = customerRepository.findByName("Anni Toivonen");
        Agreement c = Agreement.builder().agreementType(200)
                .startDateTime(LocalDateTime.now())
                .customer(customer2)
                .build();
        customer.setAgreements(Collections.singleton(c));
        customerRepository.save(customer2);
        
        
        agreementRepository.findAll().forEach(System.out::println);
        customerRepository.findAll().forEach(System.out::println);
    }
}
