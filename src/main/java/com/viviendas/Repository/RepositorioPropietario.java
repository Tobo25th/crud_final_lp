package com.viviendas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viviendas.Models.Propietario;

@Repository
public interface RepositorioPropietario extends JpaRepository<Propietario, Integer> {    
}
