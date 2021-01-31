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
        Stream.of(new Customer("Matti Meikäläinen", "123456-1234"), new Customer("Pelle Svanlös", "234567-2345"), new Customer("Maija Poppanen", "345678-3456"),
                new Customer("Tom Sawyer", "567890-4321"), new Customer("Jane Aire", "098765-1234")).forEach(customer ->
                customerRepository.save(customer)
        );
        
        String [] customerNames = {"Matti Meikäläinen", "Pelle Svanlös", "Tom Sawyer", "Jane Aire","Maija Poppanen"};
        
        for (int i = 0; i < customerNames.length; i++) {
        	Customer customer = customerRepository.findByName(customerNames[i]);
            Agreement a = new Agreement(100, LocalDateTime.now(), customer);
            agreementRepository.save(a);
            Agreement b = new Agreement(i*200, LocalDateTime.now(), customer);
            agreementRepository.save(b);
             customerRepository.save(customer);
        }

        
        for(int n=1; n <10; n++) {
            Agreement agr1 = agreementRepository.findById(new Long(n)).get();
            AgreementService as1 = new AgreementService(1, 5.0, agr1);
            AgreementService as2 = new AgreementService(n+3, n+15.0, agr1);
            agreementServiceRepository.save(as1);
            agreementServiceRepository.save(as2);
            agreementRepository.save(agr1);
        }
        

        
        agreementRepository.findAll().forEach(System.out::println);
        customerRepository.findAll().forEach(System.out::println);
        agreementServiceRepository.findAll().forEach(System.out::println);
    }
}
