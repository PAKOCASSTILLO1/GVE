package com.gve.gve.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rol {

    @Id
    @Column(name = "cod_role")
    private int cod_role;
    private String nombre;
    private String estado;

    public Rol() {
    }

    public Rol(int cod_role, String nombre, String estado) {
        this.cod_role = cod_role;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getCod_role() {
        return this.cod_role;
    }

    public void setCod_role(int cod_role) {
        this.cod_role = cod_role;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Rol cod_role(int cod_role) {
        this.cod_role = cod_role;
        return this;
    }

    public Rol nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Rol estado(String estado) {
        this.estado = estado;
        return this;
    }

}
