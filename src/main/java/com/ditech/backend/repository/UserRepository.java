package com.ditech.backend.repository;

import com.ditech.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA para la entidad {@link User}.
 * Proporciona operaciones CRUD básicas y consultas derivadas sobre la base de datos.
 *
 * Extiende {@link JpaRepository}, lo cual incluye métodos como:
 * - save()
 * - findById()
 * - findAll()
 * - deleteById()
 * - existsById()
 */
public interface UserRepository extends JpaRepository<User, Long> {
}