package com.viviendas.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.viviendas.Models.CustomUserDetails;
import com.viviendas.Models.Usuario;
import com.viviendas.Repository.RepositorioUsuario;
@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("Buscando usuario con email: " + email); 
        Usuario usuario = repositorioUsuario.findByEmail(email);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con el email: " + email);
        }
        System.out.println("Usuario encontrado: " + usuario.getEmail()); 
        return new CustomUserDetails(usuario);
}
}
