package com.viviendas.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viviendas.Models.Barrio;
import com.viviendas.Repository.RepositorioBarrio;

@Service
public class BarrioService implements BarrioServicioInterface {
    @Autowired
    private RepositorioBarrio repositorio;
    @Override
    public List<Barrio> listar() {
        return repositorio.findAll();
    }
    @Override
    public Barrio obtenerPorId(int id) {
        return repositorio.findById(id).orElse(null);
    }
    
}