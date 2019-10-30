package com.gve.gve.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Departamento {

    @Id
    @Column(name = "cod_departamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_departamento;

    private String nombre;

    @Column(name = "codigo_departamento")
    private String codigoDepartamento;

    public Departamento modified(Departamento body){
        this.nombre = body.getNombre();
        this.codigoDepartamento = body.getCodigoDepartamento();
        return this;
    }

    // @Column(name = "ubicacion_geografica")
    // private Object ubicacionGeografica;


    public Departamento() {
    }

    public Departamento(int cod_departamento, String nombre, String codigoDepartamento) {
        this.cod_departamento = cod_departamento;
        this.nombre = nombre;
        this.codigoDepartamento = codigoDepartamento;
    }

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

}
