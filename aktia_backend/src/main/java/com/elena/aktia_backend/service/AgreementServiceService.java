package com.elena.aktia_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.*;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.elena.aktia_backend.repository.AgreementServiceRepository;
import com.elena.aktia_backend.model.AgreementService;

@Service
public class AgreementServiceService {

    @Autowired
    private AgreementServiceRepository agreementServiceRepository;

    public Collection<AgreementService> findAll(){
        return agreementServiceRepository.findAll();
    }

    public AgreementService findById(Long id){
        return agreementServiceRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public AgreementService save(AgreementService agreementService){
        return agreementServiceRepository.save(agreementService);
    }

    public void deleteById(Long id){
    	agreementServiceRepository.deleteById(id);
    }

}