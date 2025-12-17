package com.viviendas.Service;

import java.util.List;
import com.viviendas.Models.Barrio;

public interface BarrioServicioInterface {

    public List<Barrio> listar();
    public Barrio obtenerPorId(int id);
   
}
