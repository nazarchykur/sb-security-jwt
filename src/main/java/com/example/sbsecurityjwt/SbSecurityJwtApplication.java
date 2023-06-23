package com.example.sbsecurityjwt;

import com.example.sbsecurityjwt.auth.AuthenticationService;
import com.example.sbsecurityjwt.auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.example.sbsecurityjwt.security.Role.ADMIN;
import static com.example.sbsecurityjwt.security.Role.MANAGER;

@SpringBootApplication
public class SbSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbSecurityJwtApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AuthenticationService service) {
        return args -> {
            var admin = RegisterRequest.builder()
                    .firstname("admin")
                    .lastname("first")
                    .email("admin@mail.com")
                    .password("password")
                    .role(ADMIN)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());

            var manager = RegisterRequest.builder()
                    .firstname("manager")
                    .lastname("first")
                    .email("manager@mail.com")
                    .password("password")
                    .role(MANAGER)
                    .build();
            System.out.println("Manager token: " + service.register(manager).getAccessToken());

        };
    }
}
