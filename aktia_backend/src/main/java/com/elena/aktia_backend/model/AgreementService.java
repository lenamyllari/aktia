package com.elena.aktia_backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "agreementService")
public class AgreementService {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private int serviceType;
    @NonNull
    private double serviceFee;
    
    @NonNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agreement", referencedColumnName = "id")
    private Agreement agreement;
}