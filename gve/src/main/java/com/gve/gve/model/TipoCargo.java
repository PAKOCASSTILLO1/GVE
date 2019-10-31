package com.gve.gve.model;

import javax.persistence.*;

@Entity
@Table(name = "tipo_cargo")
public class TipoCargo {

    @Id
    @Column(name = "cod_tipo_cargo")
    private int cod_tipo_cargo;
    private String nombre;
    private byte estado =1;

    public TipoCargo() {
    }

    public TipoCargo(int cod_tipo_cargo, String nombre, byte estado) {
        this.cod_tipo_cargo = cod_tipo_cargo;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getCod_tipo_cargo() {
        return this.cod_tipo_cargo;
    }

    public void setCod_tipo_cargo(int cod_tipo_cargo) {
        this.cod_tipo_cargo = cod_tipo_cargo;
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

    public TipoCargo cod_tipo_cargo(int cod_tipo_cargo) {
        this.cod_tipo_cargo = cod_tipo_cargo;
        return this;
    }

    public TipoCargo nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public TipoCargo estado(byte estado) {
        this.estado = estado;
        return this;
    }

}
