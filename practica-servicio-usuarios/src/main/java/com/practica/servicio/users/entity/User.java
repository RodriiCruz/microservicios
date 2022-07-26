package com.practica.servicio.users.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = -7837580187684272563L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, length = 20)
	private String username;
	private String password;
	private boolean enabled;
	private String name;
	private String surname;

	@Column(unique = true)
	private String email;

	@ManyToMany(fetch = FetchType.LAZY)
	private List<Role> roles;
}
