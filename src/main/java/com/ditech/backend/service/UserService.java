package com.ditech.backend.service;

import com.ditech.backend.model.User;
import com.ditech.backend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio encargado de la lógica de negocio para la gestión de usuarios.
 * Encapsula el acceso al repositorio y ofrece operaciones CRUD básicas.
 */
@Service
public class UserService {
    private final UserRepository userRepository;

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    /**
     * Constructor del servicio de usuarios.
     *
     * @param userRepository Repositorio JPA para la entidad User.
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Guarda un nuevo usuario en la base de datos.
     *
     * @param user Objeto User que se desea persistir.
     * @return Usuario persistido con ID generado.
     * @throws IllegalArgumentException si el ID no es null, o si el username o email ya existen.
     */
    public User saveUser(User user) {
        log.info("Guardando usuario: username={}, email={}", user.getUsername(), user.getEmail());

        if (user.getId() != null) {
            throw new IllegalArgumentException("El ID debe ser null para crear un nuevo usuario");
        }

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("El nombre de usuario ya está en uso");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("El email ya está registrado");
        }

        User saved = userRepository.save(user);
        log.debug("Usuario guardado con ID={}", saved.getId());
        return saved;
    }

    /**
     * Recupera la lista de todos los usuarios almacenados en la base de datos.
     *
     * @return Lista de usuarios.
     */
    public List<User> getAllUsers() {
        log.info("Recuperando todos los usuarios");
        List<User> users = userRepository.findAll();
        log.debug("Se recuperaron {} usuarios", users.size());
        return users;
    }

    /**
     * Busca un usuario por su identificador único.
     *
     * @param id ID del usuario.
     * @return Optional con el usuario si existe, vacío si no se encuentra.
     */
    public Optional<User> getUserById(Long id) {
        log.info("Buscando usuario con ID={}", id);
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            log.debug("Usuario encontrado: {}", userOpt.get().getUsername());
        } else {
            log.warn("Usuario con ID={} no encontrado", id);
        }
        return userOpt;
    }

    /**
     * Elimina un usuario según su identificador único.
     *
     * @param id ID del usuario a eliminar.
     */
    public void deleteUser(Long id) {
        log.info("Eliminando usuario con ID={}", id);
        userRepository.deleteById(id);
        log.debug("Usuario con ID={} eliminado", id);
    }
}
