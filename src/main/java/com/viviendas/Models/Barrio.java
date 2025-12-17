package com.viviendas.Models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Barrio")
public class Barrio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;
    @OneToMany(mappedBy = "barrio",cascade = {CascadeType.ALL},orphanRemoval = true)
    protected Set<Viviendas> viviendas;
    public Barrio() {
    }


    public void setNombreBarrio(String barrio) {
        this.nombre = barrio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setIdBarrio(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
