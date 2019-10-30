package com.gve.gve.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Mesa {

    @Id
    @Column(name = "cod_mesa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_mesa;

    private int numero;

    private int centroVotacion;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "cod_centro_votacion", nullable = false, updatable = false)
    private CentroVotacion cod_centro_votacion;
    

    @Column(name = "fecha_creo")
    private Date fechaCreo = new Date();

    @Column(name = "fecha_modifico")
    private Date fechaModifico;

    private byte estado;

    public Mesa modified(Mesa body, CentroVotacion centroVotacion) {
        this.centroVotacion = centroVotacion.getCod_centro_votacion();
        this.numero = body.getNumero();
        this.cod_centro_votacion = centroVotacion;
        this.fechaModifico = new Date();
        return this;
    }

    public Mesa() {
    }

    public Mesa(int cod_mesa, int numero, int centroVotacion, CentroVotacion cod_centro_votacion, Date fechaCreo, Date fechaModifico, byte estado) {
        this.cod_mesa = cod_mesa;
        this.numero = numero;
        this.centroVotacion = centroVotacion;
        this.cod_centro_votacion = cod_centro_votacion;
        this.fechaCreo = fechaCreo;
        this.fechaModifico = fechaModifico;
        this.estado = estado;
    }

    public int getCod_mesa() {
        return this.cod_mesa;
    }

    public void setCod_mesa(int cod_mesa) {
        this.cod_mesa = cod_mesa;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCentroVotacion() {
        return this.centroVotacion;
    }

    public void setCentroVotacion(int centroVotacion) {
        this.centroVotacion = centroVotacion;
    }

    public CentroVotacion getCod_centro_votacion() {
        return this.cod_centro_votacion;
    }

    public void setCod_centro_votacion(CentroVotacion cod_centro_votacion) {
        this.cod_centro_votacion = cod_centro_votacion;
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

    public byte getEstado() {
        return this.estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    public Mesa cod_mesa(int cod_mesa) {
        this.cod_mesa = cod_mesa;
        return this;
    }

    public Mesa numero(int numero) {
        this.numero = numero;
        return this;
    }

    public Mesa centroVotacion(int centroVotacion) {
        this.centroVotacion = centroVotacion;
        return this;
    }

    public Mesa cod_centro_votacion(CentroVotacion cod_centro_votacion) {
        this.cod_centro_votacion = cod_centro_votacion;
        return this;
    }

    public Mesa fechaCreo(Date fechaCreo) {
        this.fechaCreo = fechaCreo;
        return this;
    }

    public Mesa fechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
        return this;
    }

    public Mesa estado(byte estado) {
        this.estado = estado;
        return this;
    }

}
