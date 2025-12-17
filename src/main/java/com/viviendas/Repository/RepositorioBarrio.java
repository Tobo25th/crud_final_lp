package com.viviendas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viviendas.Models.Barrio;

@Repository
public interface RepositorioBarrio extends JpaRepository<Barrio, Integer> {    
}
