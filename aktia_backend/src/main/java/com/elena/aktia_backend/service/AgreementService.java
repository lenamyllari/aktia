package com.elena.aktia_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.*;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.elena.aktia_backend.repository.AgreementRepository;
import com.elena.aktia_backend.model.Agreement;

@Service
public class AgreementService {

    @Autowired
    private AgreementRepository agreementRepository;

    public Collection<Agreement> findAll(){
        return agreementRepository.findAll();
    }

    public Agreement findById(Long id){
        return agreementRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Agreement save(Agreement agreement){
        return agreementRepository.save(agreement);
    }
    
    public Collection<Agreement> findByCustomerId(Long customerId){
    	return agreementRepository.findByCustomerId(customerId);
    }

   public void deleteById(Long id){
    	agreementRepository.deleteById(id);
    }

}