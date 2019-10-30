package com.gve.gve.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Departamento {

    @Id
    @Column(name = "cod_departamento")
    private int cod_departamento;

    private String nombre;

    @Column(name = "codigo_departamento")
    private String codigoDepartamento;

    // @Column(name = "ubicacion_geografica")
    // private Object ubicacionGeografica;

    public Departamento() {
    }

    // public Departamento(int cod_departamento, String nombre, String codigoDepartamento, Object ubicacionGeografica) {
    //     this.cod_departamento = cod_departamento;
    //     this.nombre = nombre;
    //     this.codigoDepartamento = codigoDepartamento;
    //     this.ubicacionGeografica = ubicacionGeografica;
    // }

    public int getCod_departamento() {
        return this.cod_departamento;
    }

    public void setCod_departamento(int cod_departamento) {
        this.cod_departamento = cod_departamento;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoDepartamento() {
        return this.codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    // public Object getUbicacionGeografica() {
    //     return this.ubicacionGeografica;
    // }

    // public void setUbicacionGeografica(Object ubicacionGeografica) {
    //     this.ubicacionGeografica = ubicacionGeografica;
    // }

    public Departamento cod_departamento(int cod_departamento) {
        this.cod_departamento = cod_departamento;
        return this;
    }

    public Departamento nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Departamento codigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
        return this;
    }

    // public Departamento ubicacionGeografica(Object ubicacionGeografica) {
    //     this.ubicacionGeografica = ubicacionGeografica;
    //     return this;
    // }

}
