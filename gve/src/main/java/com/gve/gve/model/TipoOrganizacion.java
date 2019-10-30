package com.gve.gve.model;

import javax.persistence.*;

@Entity
@Table(name = "tipo_organizacion", schema = "GVE", catalog = "")
public class TipoOrganizacion {

    @Id
    @Column(name = "cod_tipo_organizacion")
    private int cod_tipo_organizacion;

    private String nombre;
    private byte estado;

    public TipoOrganizacion() {
    }

    public TipoOrganizacion(int cod_tipo_organizacion, String nombre, byte estado) {
        this.cod_tipo_organizacion = cod_tipo_organizacion;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getCod_tipo_organizacion() {
        return this.cod_tipo_organizacion;
    }

    public void setCod_tipo_organizacion(int cod_tipo_organizacion) {
        this.cod_tipo_organizacion = cod_tipo_organizacion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getEstado() {
        return this.estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    public TipoOrganizacion cod_tipo_organizacion(int cod_tipo_organizacion) {
        this.cod_tipo_organizacion = cod_tipo_organizacion;
        return this;
    }

    public TipoOrganizacion nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public TipoOrganizacion estado(byte estado) {
        this.estado = estado;
        return this;
    }

}
