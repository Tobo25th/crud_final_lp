package com.viviendas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viviendas.Models.Usuario;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Integer> {
    Usuario findByEmailAndContrasena(String email, String contrasena);

    Usuario findByEmail(String email);
}
