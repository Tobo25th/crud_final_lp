package com.viviendas.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table (name = "viviendas")
public class Viviendas {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
@Column(name = "calle",nullable = false, length = 50)
private String calle;
@Column(name = "numero",nullable = false,length = 5)
private Integer nro;
@Column(name = "titular",nullable = true,length = 40)
private String titular;
@ManyToOne
    @JoinColumn(name = "propietario",nullable = false)
private Propietario propietario;
@Column(name = "habitantes",nullable = false,length = 2)
private Integer habitantes;
@ManyToOne
    @JoinColumn(name = "barrio",nullable = false)
        private Barrio barrio;

public Viviendas(){}

public void setCalle(String calle) {
    this.calle = calle;
}
public void setBarrio(Barrio barrio){
    this.barrio = barrio;
}
public void setHabitantes(Integer habitantes) {
    this.habitantes = habitantes;
}
public void setId(Integer id) {
    this.id = id;
}
public void setNro(Integer nro) {
    this.nro = nro;
}
public void setTitular(String titular) {
    this.titular = titular;
}
public void setPropietario(Propietario propietario) {
    this.propietario = propietario;
}
public String getCalle() {
    return calle;
}
public Integer getHabitantes() {
    return habitantes;
}
public Integer getId() {
    return id;
}
public Integer getNro() {
    return nro;
}
public String getTitular(){
    return titular;
}
public Propietario getPropietario() {
    return propietario;
}
public Barrio getBarrio() {
    return barrio;  
}

}
