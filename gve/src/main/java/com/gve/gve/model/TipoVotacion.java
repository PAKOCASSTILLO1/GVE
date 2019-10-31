package com.gve.gve.model;

import javax.persistence.*;

@Entity
@Table(name = "tipo_votacion")
public class TipoVotacion {

    @Id
    @Column(name = "cod_tipo_votacion")
    private int codTipoVotacion;

    private String nombre;
    private String descripcion;
    private byte estado =1;

    public TipoVotacion() {
    }

    public TipoVotacion(int codTipoVotacion, String nombre, String descripcion, byte estado) {
        this.codTipoVotacion = codTipoVotacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getCodTipoVotacion() {
        return this.codTipoVotacion;
    }

    public void setCodTipoVotacion(int codTipoVotacion) {
        this.codTipoVotacion = codTipoVotacion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte getEstado() {
        return this.estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    public TipoVotacion codTipoVotacion(int codTipoVotacion) {
        this.codTipoVotacion = codTipoVotacion;
        return this;
    }

    public TipoVotacion nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public TipoVotacion descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public TipoVotacion estado(byte estado) {
        this.estado = estado;
        return this;
    }

}
