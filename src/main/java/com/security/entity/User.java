package com.security.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/* generationtype identity hace que los id se generen autoincrementando */

	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "lastname", nullable = false)
	private String lastname;

	@Column(name = "phone_number", length = 16)
	private String phoneNumber;

	@Column(name = "address", nullable = false)
	private String address;

}
