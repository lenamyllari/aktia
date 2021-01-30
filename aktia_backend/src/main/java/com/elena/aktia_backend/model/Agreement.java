package com.elena.aktia_backend;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "customerAgreement")
public class Agreement {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private int agreementType;
    private LocalDateTime startDateTime;
    @Nullable
    private LocalDateTime endDateTime;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer", referencedColumnName = "id")
    private Customer customer;
}