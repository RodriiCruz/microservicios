package com.practica.servicio.users.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.practica.servicio.users.entity.User;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@RepositoryRestResource(path = "users")
public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findByUsername(String username);
}
