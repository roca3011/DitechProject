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

    /**
     * Verifica si existe un usuario con el username especificado.
     *
     * @param username Nombre de usuario a verificar.
     * @return true si existe, false en caso contrario.
     */
    boolean existsByUsername(String username);

    /**
     * Verifica si existe un usuario con el email especificado.
     *
     * @param email Email a verificar.
     * @return true si existe, false en caso contrario.
     */
    boolean existsByEmail(String email);
}