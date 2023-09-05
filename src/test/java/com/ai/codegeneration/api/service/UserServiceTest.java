package com.ai.codegeneration.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ai.codegeneration.api.entity.UserEntity;
import com.ai.codegeneration.api.repository.UserRepository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserService.class})
@ExtendWith(SpringExtension.class)
class UserServiceTest {
    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    /**
     * Method under test: {@link UserService#register(UserEntity)}
     */
    @Test
    void testRegister() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setId(1L);
        userEntity.setPassword("iloveyou");
        userEntity.setUsername("janedoe");
        when(userRepository.save(Mockito.<UserEntity>any())).thenReturn(userEntity);
        when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

        UserEntity user = new UserEntity();
        user.setEmail("jane.doe@example.org");
        user.setId(1L);
        user.setPassword("iloveyou");
        user.setUsername("janedoe");
        assertSame(userEntity, userService.register(user));
        verify(userRepository).save(Mockito.<UserEntity>any());
        verify(passwordEncoder).encode(Mockito.<CharSequence>any());
        assertEquals("secret", user.getPassword());
    }

    /**
     * Method under test: {@link UserService#login(String, String)}
     */
    @Test
    void testLogin() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setId(1L);
        userEntity.setPassword("iloveyou");
        userEntity.setUsername("janedoe");
        when(userRepository.findByUsername(Mockito.<String>any())).thenReturn(userEntity);
        when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any())).thenReturn(true);
        assertSame(userEntity, userService.login("janedoe", "iloveyou"));
        verify(userRepository).findByUsername(Mockito.<String>any());
        verify(passwordEncoder).matches(Mockito.<CharSequence>any(), Mockito.<String>any());
    }

    /**
     * Method under test: {@link UserService#login(String, String)}
     */
    @Test
    void testLogin2() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setId(1L);
        userEntity.setPassword("iloveyou");
        userEntity.setUsername("janedoe");
        when(userRepository.findByUsername(Mockito.<String>any())).thenReturn(userEntity);
        when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any())).thenReturn(false);
        assertNull(userService.login("janedoe", "iloveyou"));
        verify(userRepository).findByUsername(Mockito.<String>any());
        verify(passwordEncoder).matches(Mockito.<CharSequence>any(), Mockito.<String>any());
    }

    /**
     * Method under test: {@link UserService#findUserById(Long)}
     */
    @Test
    void testFindUserById() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setId(1L);
        userEntity.setPassword("iloveyou");
        userEntity.setUsername("janedoe");
        Optional<UserEntity> ofResult = Optional.of(userEntity);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertSame(userEntity, userService.findUserById(1L));
        verify(userRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link UserService#updateUser(UserEntity)}
     */
    @Test
    void testUpdateUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setId(1L);
        userEntity.setPassword("iloveyou");
        userEntity.setUsername("janedoe");
        when(userRepository.save(Mockito.<UserEntity>any())).thenReturn(userEntity);

        UserEntity user = new UserEntity();
        user.setEmail("jane.doe@example.org");
        user.setId(1L);
        user.setPassword("iloveyou");
        user.setUsername("janedoe");
        assertSame(userEntity, userService.updateUser(user));
        verify(userRepository).save(Mockito.<UserEntity>any());
    }

    /**
     * Method under test: {@link UserService#deleteUser(Long)}
     */
    @Test
    void testDeleteUser() {
        doNothing().when(userRepository).deleteById(Mockito.<Long>any());
        userService.deleteUser(1L);
        verify(userRepository).deleteById(Mockito.<Long>any());
    }
}

