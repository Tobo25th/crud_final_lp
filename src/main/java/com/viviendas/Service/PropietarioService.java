package com.viviendas.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viviendas.Models.Propietario;
import com.viviendas.Repository.RepositorioPropietario;
@Service
public class PropietarioService implements PropietarioServicioInterface {
    @Autowired
    private RepositorioPropietario repositorio;
    @Override
    public List<Propietario> listar() {
        return repositorio.findAll();
    }
    @Override
    public Propietario obtenerPorId(int id) {
        return repositorio.findById(id).orElse(null);
    }
    
}
