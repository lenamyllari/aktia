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
        Stream.of(new Customer("Matti Meikäläinen", "eka"), new Customer("Pekka Vanhanen", "toka"), new Customer("Maija Poppanen", "kolmas"),
                new Customer("Anni Toivonen", "neljas"), new Customer("Elena Mylläri", "viides")).forEach(customer ->
                customerRepository.save(customer)
        );
        
        Customer customer = customerRepository.findByName("Matti Meikäläinen");
       Agreement a = new Agreement(100, LocalDateTime.now(), customer);
       agreementRepository.save(a);
       Agreement b = new Agreement(200, LocalDateTime.now(), customer);
       agreementRepository.save(b);
        customerRepository.save(customer);
        
        Customer customer2 = customerRepository.findByName("Pekka Vanhanen");
        Agreement c = new Agreement(100, LocalDateTime.now(), customer2);
        agreementRepository.save(c);
        Agreement d = new Agreement(200, LocalDateTime.now(), customer2);
        agreementRepository.save(d);
        customerRepository.save(customer2);
 
        Customer customer3 = customerRepository.findByName("Anni Toivonen");
        Agreement e = new Agreement(100, LocalDateTime.now(), customer3);
        agreementRepository.save(e);
        Agreement f = new Agreement(300, LocalDateTime.now(), customer3);
        agreementRepository.save(d);
        customerRepository.save(customer3);
        
        Customer customer4 = customerRepository.findByName("Elena Mylläri");
        Agreement g = new Agreement(100, LocalDateTime.now(), customer4);
        agreementRepository.save(g);
        Agreement i = new Agreement(300, LocalDateTime.now(), customer4);
        agreementRepository.save(i);
        customerRepository.save(customer4);
        
        Customer customer5 = customerRepository.findByName("Maija Poppanen");
        Agreement j = new Agreement(100, LocalDateTime.now(), customer5);
        agreementRepository.save(j);
        Agreement k = new Agreement(300, LocalDateTime.now(), customer5);
        agreementRepository.save(k);
        customerRepository.save(customer5);
        

        
        Agreement agr1 = agreementRepository.findById(new Long(6)).get();
        AgreementService as1 = new AgreementService(1, 5.0, agr1);
        agreementServiceRepository.save(as1);
        agreementRepository.save(agr1);
        
        agreementRepository.findAll().forEach(System.out::println);
        customerRepository.findAll().forEach(System.out::println);
        agreementServiceRepository.findAll().forEach(System.out::println);
    }
}
