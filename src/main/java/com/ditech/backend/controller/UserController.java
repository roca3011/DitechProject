package com.ditech.backend.controller;

import com.ditech.backend.model.User;
import com.ditech.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * Controlador REST que expone los endpoints para la gestión de usuarios.
 * Permite operaciones CRUD como crear, consultar, y eliminar usuarios.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Crea un nuevo usuario.
     *
     * @param user el objeto {@link User} recibido en el cuerpo de la solicitud
     * @return una respuesta HTTP 201 Created con la ubicación del nuevo recurso y el objeto usuario creado en el cuerpo
     */
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userService.saveUser(user);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedUser.getId())
            .toUri();

        // Retorna 201 Created con ubicación del recurso
        return ResponseEntity.created(location).body(savedUser);
    }

    /**
     * Obtiene la lista de todos los usuarios registrados.
     *
     * @return una lista de objetos {@link User}
     */
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Obtiene un usuario por su ID.
     *
     * @param id el identificador único del usuario
     * @return una respuesta HTTP 200 OK con el usuario si existe, o 404 Not Found si no se encuentra
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param id el identificador único del usuario a eliminar
     * @return una respuesta HTTP 204 No Content si fue eliminado, o 404 Not Found si no existe
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userService.getUserById(id).isPresent()) {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
