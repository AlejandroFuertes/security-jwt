package com.oms;

import com.oms.entity.ERole;
import com.oms.entity.RoleEntity;
import com.oms.entity.UserEntity;
import com.oms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

/**
 * @author: Alejandro Fuertes
 */
@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Bean
	CommandLineRunner init() {
        return args -> {
			UserEntity userEntityAdmin = UserEntity.builder()
					.username("alejandro")
					.password(passwordEncoder.encode("123"))
                    .email("ale@gmail.com")
					.roles(Set.of(RoleEntity.builder().name(ERole.valueOf(ERole.ADMIN.name())).build()))
					.build();

			UserEntity userEntityUser = UserEntity.builder()
					.username("angy")
					.password(passwordEncoder.encode("456"))
					.email("angy@gmail.com")
					.roles(Set.of(RoleEntity.builder().name(ERole.valueOf(ERole.USER.name())).build()))
					.build();

			UserEntity userEntityInvited = UserEntity.builder()
					.username("emi")
					.password(passwordEncoder.encode("789"))
					.email("emi@gmail.com")
					.roles(Set.of(RoleEntity.builder().name(ERole.valueOf(ERole.INVITED.name())).build()))
					.build();

			userRepository.save(userEntityAdmin);
			userRepository.save(userEntityUser);
			userRepository.save(userEntityInvited);
		};
	}

}
