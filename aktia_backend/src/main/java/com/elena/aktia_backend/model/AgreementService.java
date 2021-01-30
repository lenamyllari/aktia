package com.elena.aktia_backend;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "agreementService")
public class AgreementService {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private int serviceType;
    private float serviceFee;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agreement", referencedColumnName = "id")
    private Agreement agreement;
}