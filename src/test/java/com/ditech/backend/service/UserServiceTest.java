package com.ditech.backend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.ditech.backend.model.User;
import com.ditech.backend.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("Debe guardar un usuario correctamente")
    void testSaveUser() {
        // Arrange
        User user = new User();
        user.setUsername("test");

        given(userRepository.save(user)).willReturn(user);

        // Act
        User saved = userService.saveUser(user);

        // Assert
        assertNotNull(saved, "El usuario guardado no debe ser null");
        assertEquals("test", saved.getUsername(), "El nombre de usuario guardado no coincide");
    }

    @Test
    @DisplayName("Debe obtener todos los usuarios")
    void testGetAllUsers() {
        // Arrange
        User user1 = new User();
        user1.setUsername("user1");

        User user2 = new User();
        user2.setUsername("user2");

        given(userRepository.findAll()).willReturn(Arrays.asList(user1, user2));

        // Act
        List<User> users = userService.getAllUsers();

        // Assert
        assertEquals(2, users.size(), "Debe retornar 2 usuarios");
    }

    @Test
    @DisplayName("Debe encontrar un usuario por ID si existe")
    void testGetUserById() {
        // Arrange
        User user = new User();
        user.setId(1L);

        given(userRepository.findById(1L)).willReturn(Optional.of(user));

        // Act
        Optional<User> found = userService.getUserById(1L);

        // Assert
        assertTrue(found.isPresent(), "El usuario debe estar presente");
        assertEquals(1L, found.get().getId(), "El ID del usuario no coincide");
    }

    @Test
    @DisplayName("Debe eliminar un usuario por ID")
    void testDeleteUser() {
        // Act
        userService.deleteUser(1L);

        // Assert
        verify(userRepository, times(1)).deleteById(1L);
    }
}
