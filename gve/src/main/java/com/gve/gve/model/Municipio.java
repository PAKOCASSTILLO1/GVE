package com.gve.gve.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Municipio {

    @Id
    @Column(name = "cod_municipio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codMunicipio;

    private String nombre;
    private int departamento;

    @Column(name = "codigo_municipio")
    private String codigoMunicipio;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "cod_departamento", nullable = false, updatable = false)
    private Departamento cod_departamento;

    public Municipio modified(Municipio body, Departamento departamento) {
        this.nombre = body.getNombre();
        this.codigoMunicipio = body.getCodigoMunicipio();
        this.departamento = departamento.getCod_departamento();
        this.cod_departamento = departamento;
        return this;
    }

    // @Column(name = "ubicacion_geografica_cabecera")
    // private Object ubicacionGeograficaCabecera;


    public Municipio() {
    }

    public Municipio(int codMunicipio, String nombre, int departamento, String codigoMunicipio, Departamento cod_departamento) {
        this.codMunicipio = codMunicipio;
        this.nombre = nombre;
        this.departamento = departamento;
        this.codigoMunicipio = codigoMunicipio;
        this.cod_departamento = cod_departamento;
    }

    public int getCodMunicipio() {
        return this.codMunicipio;
    }

    public void setCodMunicipio(int codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public String getCodigoMunicipio() {
        return this.codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public Departamento getCod_departamento() {
        return this.cod_departamento;
    }

    public void setCod_departamento(Departamento cod_departamento) {
        this.cod_departamento = cod_departamento;
    }

    public Municipio codMunicipio(int codMunicipio) {
        this.codMunicipio = codMunicipio;
        return this;
    }

    public Municipio nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Municipio departamento(int departamento) {
        this.departamento = departamento;
        return this;
    }

    public Municipio codigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
        return this;
    }

    public Municipio cod_departamento(Departamento cod_departamento) {
        this.cod_departamento = cod_departamento;
        return this;
    }

}
