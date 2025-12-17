package com.viviendas.Service;

import java.util.List;
import com.viviendas.Models.Propietario;

public interface PropietarioServicioInterface {

    public List<Propietario> listar();
    public Propietario obtenerPorId(int id);
   
}
