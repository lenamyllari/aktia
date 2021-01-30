package com.elena.aktia_backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.Collection;

import com.elena.aktia_backend.model.Agreement;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

	@Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String ssn;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Collection <Agreement> agreement;
    
	@Override
	public String toString() {
		return this.name;
	}
}