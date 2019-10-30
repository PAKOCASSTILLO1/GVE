package com.gve.gve.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Municipio {

    @Id
    @Column(name = "cod_municipio")
    private int codMunicipio;

    private String nombre;

    @Column(name = "codigo_municipio")
    private String codigoMunicipio;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "FK_COD_DEPARTAMENTO_MUNICIPIO", nullable = false, updatable = false)
    private Departamento cod_departamento;

    // @Column(name = "ubicacion_geografica_cabecera")
    // private Object ubicacionGeograficaCabecera;

    public Municipio() {
    }

    // public Municipio(int codMunicipio, String nombre, String codigoMunicipio, Departamento cod_departamento, Object ubicacionGeograficaCabecera) {
    //     this.codMunicipio = codMunicipio;
    //     this.nombre = nombre;
    //     this.codigoMunicipio = codigoMunicipio;
    //     this.cod_departamento = cod_departamento;
    //     this.ubicacionGeograficaCabecera = ubicacionGeograficaCabecera;
    // }

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

    // public Object getUbicacionGeograficaCabecera() {
    //     return this.ubicacionGeograficaCabecera;
    // }

    // public void setUbicacionGeograficaCabecera(Object ubicacionGeograficaCabecera) {
    //     this.ubicacionGeograficaCabecera = ubicacionGeograficaCabecera;
    // }

    public Municipio codMunicipio(int codMunicipio) {
        this.codMunicipio = codMunicipio;
        return this;
    }

    public Municipio nombre(String nombre) {
        this.nombre = nombre;
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

    // public Municipio ubicacionGeograficaCabecera(Object ubicacionGeograficaCabecera) {
    //     this.ubicacionGeograficaCabecera = ubicacionGeograficaCabecera;
    //     return this;
    // }

}
