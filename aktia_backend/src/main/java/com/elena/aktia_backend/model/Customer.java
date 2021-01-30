package com.elena.aktia_backend;

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

//@Data
//@NoArgsConstructor
@Builder
@Data
@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
//@Table
//@ToString
//@Entity
//@Getter
//@Setter
//@Builder
//@RequiredArgsConstructor
@Table(name = "customer")
public class Customer {



	@Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    private String customer_id;
    

	
	@Override
	public String toString() {
		return this.name;
	}
}