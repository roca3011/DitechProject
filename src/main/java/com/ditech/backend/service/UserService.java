package com.ditech.backend.service;

import com.ditech.backend.model.User;
import com.ditech.backend.repository.UserRepository;
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

    /**
     * Constructor del servicio de usuarios.
     *
     * @param userRepository Repositorio JPA para la entidad User.
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Guarda un nuevo usuario o actualiza uno existente.
     *
     * @param user Objeto User que se desea persistir.
     * @return Usuario persistido con ID generado si es nuevo.
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Recupera la lista de todos los usuarios almacenados en la base de datos.
     *
     * @return Lista de usuarios.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Busca un usuario por su identificador único.
     *
     * @param id ID del usuario.
     * @return Optional con el usuario si existe, vacío si no se encuentra.
     */
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Elimina un usuario según su identificador único.
     *
     * @param id ID del usuario a eliminar.
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
