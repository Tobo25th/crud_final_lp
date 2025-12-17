package com.viviendas.Service;

import com.viviendas.Models.Usuario;

public interface UsuarioServicioInterface {
    public void guardarUsuario(Usuario usuario);
    public Usuario autenticarUsuario(String email, String contrasena);
    public Usuario buscarUsuario(String email);
}
