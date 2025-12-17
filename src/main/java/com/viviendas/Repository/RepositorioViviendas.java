package com.viviendas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.viviendas.Models.Viviendas;

@Repository
public interface RepositorioViviendas extends JpaRepository<Viviendas, Integer> {
}