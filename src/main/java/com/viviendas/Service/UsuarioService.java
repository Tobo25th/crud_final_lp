package com.viviendas.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.viviendas.Models.Usuario;
import com.viviendas.Repository.RepositorioUsuario;

@Service
public class UsuarioService implements UsuarioServicioInterface {
    @Autowired
    private RepositorioUsuario repositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Usuario autenticarUsuario(String email, String contrasena) {
        return repositorio.findByEmailAndContrasena(email, contrasena);
    }

    @Override
    public Usuario buscarUsuario(String email) {
        return repositorio.findByEmail(email);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        repositorio.save(usuario);
    }
}