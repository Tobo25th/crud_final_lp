package com.viviendas.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viviendas.Models.Viviendas;
import com.viviendas.Repository.RepositorioViviendas;

@Service
public class VivendaService implements ViviendaServicioInterface {
    @Autowired
    private RepositorioViviendas repositorio;

    @Override
    public List<Viviendas> listar() {
        return repositorio.findAll();
    }
    @Override
    public void guardarVivienda(Viviendas vivienda) {
        repositorio.save(vivienda);
    }

    @Override
    public void actualizarVivienda(Viviendas vivienda) {
        repositorio.save(vivienda);
    }

    @Override
    public Viviendas obtenerViviendaPorId(int id) {
        return repositorio.findById(id).get();
    }

    @Override
    public void eliminarVivienda(int id){
        repositorio.deleteById(id);
    }

}