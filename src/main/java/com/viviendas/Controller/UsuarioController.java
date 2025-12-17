package com.viviendas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.viviendas.Models.Usuario;
import com.viviendas.Service.UsuarioService;


@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioService servicio;

    @GetMapping("/registro")
    public String formularioRegistro(Model modelo) {
        modelo.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        servicio.guardarUsuario(usuario);
        return "redirect:/login?exito";
    }

    @GetMapping("/login")
    public String formularioLogin() {
        return "login";
    }


    
}
