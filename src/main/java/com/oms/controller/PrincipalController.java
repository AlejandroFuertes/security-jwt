package com.oms.controller;

import com.oms.entity.ERole;
import com.oms.entity.RoleEntity;
import com.oms.entity.UserEntity;
import com.oms.mapper.CreateUserDTO;
import com.oms.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: Alejandro Fuertes
 */
@RestController
public class PrincipalController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/createUser")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDTO createUserDTO) {

        Set<RoleEntity> roles = createUserDTO.getRoles().stream().map(role -> RoleEntity.builder()
                    .name(ERole.valueOf(role))
                    .build()).collect(Collectors.toSet());

        UserEntity userEntity = UserEntity.builder()
                .username(createUserDTO.getUsername())
                .password(passwordEncoder.encode(createUserDTO.getPassword()))
                .email(createUserDTO.getEmail())
                .roles(roles)
                .build();

        userRepository.save(userEntity);

        return ResponseEntity.ok(userEntity);
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam String id) {
        userRepository.deleteById(Long.parseLong(id));

        return "User deleted:  ".concat(id);
    }

}
