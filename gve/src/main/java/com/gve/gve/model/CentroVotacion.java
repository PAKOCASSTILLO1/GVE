package com.gve.gve.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "centro_votacion")
public class CentroVotacion {

    @Id
    @Column(name = "cod_centro_votacion")
    private int cod_centro_votacion;

    private String nombre;

    // @Column(name = "ubicacion_geografica")
    // private Object ubicacionGeografica;

    private String direccion;
    private String telefono;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "FK_COD_DISTRITO_CENTRO_VOTACION", nullable = false, updatable = false)
    private DistritoElectoralCems cod_distrito;

    @Column(name = "fecha_creo")
    private Date fechaCreo;

    @Column(name = "fecha_modifico")
    private Date fechaModifico;

    private byte estado;


    public CentroVotacion() {
    }

    // public CentroVotacion(int cod_centro_votacion, String nombre, Object ubicacionGeografica, String direccion, String telefono, DistritoElectoralCems cod_distrito, Date fechaCreo, Date fechaModifico, byte estado) {
    //     this.cod_centro_votacion = cod_centro_votacion;
    //     this.nombre = nombre;
    //     this.ubicacionGeografica = ubicacionGeografica;
    //     this.direccion = direccion;
    //     this.telefono = telefono;
    //     this.cod_distrito = cod_distrito;
    //     this.fechaCreo = fechaCreo;
    //     this.fechaModifico = fechaModifico;
    //     this.estado = estado;
    // }

    public int getCod_centro_votacion() {
        return this.cod_centro_votacion;
    }

    public void setCod_centro_votacion(int cod_centro_votacion) {
        this.cod_centro_votacion = cod_centro_votacion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // public Object getUbicacionGeografica() {
    //     return this.ubicacionGeografica;
    // }

    // public void setUbicacionGeografica(Object ubicacionGeografica) {
    //     this.ubicacionGeografica = ubicacionGeografica;
    // }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public DistritoElectoralCems getCod_distrito() {
        return this.cod_distrito;
    }

    public void setCod_distrito(DistritoElectoralCems cod_distrito) {
        this.cod_distrito = cod_distrito;
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

    public CentroVotacion cod_centro_votacion(int cod_centro_votacion) {
        this.cod_centro_votacion = cod_centro_votacion;
        return this;
    }

    public CentroVotacion nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    // public CentroVotacion ubicacionGeografica(Object ubicacionGeografica) {
    //     this.ubicacionGeografica = ubicacionGeografica;
    //     return this;
    // }

    public CentroVotacion direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public CentroVotacion telefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public CentroVotacion cod_distrito(DistritoElectoralCems cod_distrito) {
        this.cod_distrito = cod_distrito;
        return this;
    }

    public CentroVotacion fechaCreo(Date fechaCreo) {
        this.fechaCreo = fechaCreo;
        return this;
    }

    public CentroVotacion fechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
        return this;
    }

    public CentroVotacion estado(byte estado) {
        this.estado = estado;
        return this;
    }

}
