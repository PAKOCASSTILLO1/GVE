package com.gve.gve.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tipo_fiscal")
public class TipoFiscal {

    @Id
    @Column(name = "cod_tipo_fiscal")
    private int cod_tipo_fiscal;

    private String nombre;
    private byte estado;

    @Column(name = "usuario_creo")
    private int usuarioCreo;

    @Column(name = "fecha_creo")
    private Date fechaCreo;

    @Column(name = "usuario_modifico")
    private Integer usuarioModifico;

    @Column(name = "fecha_modifico")
    private Date fechaModifico;

    public TipoFiscal() {
    }

    public TipoFiscal(int cod_tipo_fiscal, String nombre, byte estado, int usuarioCreo, Date fechaCreo, Integer usuarioModifico, Date fechaModifico) {
        this.cod_tipo_fiscal = cod_tipo_fiscal;
        this.nombre = nombre;
        this.estado = estado;
        this.usuarioCreo = usuarioCreo;
        this.fechaCreo = fechaCreo;
        this.usuarioModifico = usuarioModifico;
        this.fechaModifico = fechaModifico;
    }

    public int getCod_tipo_fiscal() {
        return this.cod_tipo_fiscal;
    }

    public void setCod_tipo_fiscal(int cod_tipo_fiscal) {
        this.cod_tipo_fiscal = cod_tipo_fiscal;
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

    public int getUsuarioCreo() {
        return this.usuarioCreo;
    }

    public void setUsuarioCreo(int usuarioCreo) {
        this.usuarioCreo = usuarioCreo;
    }

    public Date getFechaCreo() {
        return this.fechaCreo;
    }

    public void setFechaCreo(Date fechaCreo) {
        this.fechaCreo = fechaCreo;
    }

    public Integer getUsuarioModifico() {
        return this.usuarioModifico;
    }

    public void setUsuarioModifico(Integer usuarioModifico) {
        this.usuarioModifico = usuarioModifico;
    }

    public Date getFechaModifico() {
        return this.fechaModifico;
    }

    public void setFechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
    }

    public TipoFiscal cod_tipo_fiscal(int cod_tipo_fiscal) {
        this.cod_tipo_fiscal = cod_tipo_fiscal;
        return this;
    }

    public TipoFiscal nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public TipoFiscal estado(byte estado) {
        this.estado = estado;
        return this;
    }

    public TipoFiscal usuarioCreo(int usuarioCreo) {
        this.usuarioCreo = usuarioCreo;
        return this;
    }

    public TipoFiscal fechaCreo(Date fechaCreo) {
        this.fechaCreo = fechaCreo;
        return this;
    }

    public TipoFiscal usuarioModifico(Integer usuarioModifico) {
        this.usuarioModifico = usuarioModifico;
        return this;
    }

    public TipoFiscal fechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
        return this;
    }

}
