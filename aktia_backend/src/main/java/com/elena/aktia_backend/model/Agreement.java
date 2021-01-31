package com.elena.aktia_backend.model;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "customerAgreement")
public class Agreement {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private int agreementType;
    @NonNull
    private LocalDateTime startDateTime;
    @Nullable
    private LocalDateTime endDateTime;
    
    //fetch=FetchType.EAGER, 
    @NonNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer", referencedColumnName = "id")
    private Customer customer;
}