package com.gadget.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class CustomerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	// @NotBlank(message = "Name is mandatory")
	private String name;
	private String email;
	private String gender;

	@OneToMany(mappedBy = "customerEntities", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnoreProperties("customerEntities")
	private List<ProductEntity> productList;

	public CustomerEntity(String name, String email, String gender) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

}
