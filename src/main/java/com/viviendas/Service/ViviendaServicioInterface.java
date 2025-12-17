package com.viviendas.Service;

import java.util.List;

import com.viviendas.Models.Viviendas;

public interface ViviendaServicioInterface {

     public List<Viviendas> listar();
     public void guardarVivienda(Viviendas vivienda);
     public void actualizarVivienda(Viviendas vivienda);
     public Viviendas obtenerViviendaPorId(int id);
     public void eliminarVivienda(int id);
}
