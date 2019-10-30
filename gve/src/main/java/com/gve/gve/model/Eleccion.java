package com.gve.gve.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Eleccion {
    @Id
    @Column(name = "cod_eleccion")
    private int cod_eleccion;

    @Column(name = "fecha_eleccion")
    private Date fechaEleccion;

    @Column(name = "objeto_elección")
    private String objetoElección;

    @Column(name = "fecha_segunda_vuelta")
    private Date fechaSegundaVuelta;

    @Column(name = "numero_decreto")
    private String numeroDecreto;

    @Column(name = "fecha_creo")
    private Date fechaCreo;

    @Column(name = "fecha_modifico")
    private Date fechaModifico;


    public Eleccion() {
    }

    public Eleccion(int cod_eleccion, Date fechaEleccion, String objetoElección, Date fechaSegundaVuelta, String numeroDecreto, Date fechaCreo, Date fechaModifico) {
        this.cod_eleccion = cod_eleccion;
        this.fechaEleccion = fechaEleccion;
        this.objetoElección = objetoElección;
        this.fechaSegundaVuelta = fechaSegundaVuelta;
        this.numeroDecreto = numeroDecreto;
        this.fechaCreo = fechaCreo;
        this.fechaModifico = fechaModifico;
    }

    public int getCod_eleccion() {
        return this.cod_eleccion;
    }

    public void setCod_eleccion(int cod_eleccion) {
        this.cod_eleccion = cod_eleccion;
    }

    public Date getFechaEleccion() {
        return this.fechaEleccion;
    }

    public void setFechaEleccion(Date fechaEleccion) {
        this.fechaEleccion = fechaEleccion;
    }

    public String getObjetoElección() {
        return this.objetoElección;
    }

    public void setObjetoElección(String objetoElección) {
        this.objetoElección = objetoElección;
    }

    public Date getFechaSegundaVuelta() {
        return this.fechaSegundaVuelta;
    }

    public void setFechaSegundaVuelta(Date fechaSegundaVuelta) {
        this.fechaSegundaVuelta = fechaSegundaVuelta;
    }

    public String getNumeroDecreto() {
        return this.numeroDecreto;
    }

    public void setNumeroDecreto(String numeroDecreto) {
        this.numeroDecreto = numeroDecreto;
    }

    public Date getFechaCreo() {
        return this.fechaCreo;
    }

    public void setFechaCreo(Date fechaCreo) {
        this.fechaCreo = fechaCreo;
    }

    public Date getFechaModifico() {
        return this.fechaModifico;
    }

    public void setFechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
    }

    public Eleccion cod_eleccion(int cod_eleccion) {
        this.cod_eleccion = cod_eleccion;
        return this;
    }

    public Eleccion fechaEleccion(Date fechaEleccion) {
        this.fechaEleccion = fechaEleccion;
        return this;
    }

    public Eleccion objetoElección(String objetoElección) {
        this.objetoElección = objetoElección;
        return this;
    }

    public Eleccion fechaSegundaVuelta(Date fechaSegundaVuelta) {
        this.fechaSegundaVuelta = fechaSegundaVuelta;
        return this;
    }

    public Eleccion numeroDecreto(String numeroDecreto) {
        this.numeroDecreto = numeroDecreto;
        return this;
    }

    public Eleccion fechaCreo(Date fechaCreo) {
        this.fechaCreo = fechaCreo;
        return this;
    }

    public Eleccion fechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
        return this;
    }

}
