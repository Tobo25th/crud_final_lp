package com.viviendas.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/registro", "/login", "/css/**", "/js/**", "/funciones.js").permitAll() // Permite acceso libre
                .anyRequest().authenticated() // Todas las demás rutas requieren autenticación
            )
            .formLogin(form -> form
                .loginPage("/login") // Especifica la página de login 
                .defaultSuccessUrl("/viviendas") // Se redirige a esta pagina luego de loguearse correctamente
                .failureUrl("/login?error") // Se redirige a esta pagina si hay un error de autenticación
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout") // Se redirige aca después de cerrar sesión
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
