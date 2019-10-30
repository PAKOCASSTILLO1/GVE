package com.gve.gve.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comite_ejecutivo_nacional")
public class ComiteEjecutivoNacional {

    @Id
    @Column(name = "cod_comite_ejecutivo")
    private int cod_comite_ejecutivo;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "FK_COD_ORGANIZACION_POLITICA_COMITE_E_N", nullable = false, updatable = false)
    private OrganizacionPolitica cod_organizacion_politica;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "FK_COD_TIPO_CARGO_COMITE_E_N", nullable = false, updatable = false)
    private TipoCargo cod_tipo_cargo;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "FK_COD_AFILIADO_COMITE_E_N", nullable = false, updatable = false)
    private Afiliado cod_afiliado;

    @Column(name = "fecha_creo")
    private Date fechaCreo;

    @Column(name = "fecha_modifico")
    private Date fechaModifico;

    private byte estado;

    public ComiteEjecutivoNacional() {
    }

    public ComiteEjecutivoNacional(int cod_comite_ejecutivo, OrganizacionPolitica cod_organizacion_politica, TipoCargo cod_tipo_cargo, Afiliado cod_afiliado, Date fechaCreo, Date fechaModifico, byte estado) {
        this.cod_comite_ejecutivo = cod_comite_ejecutivo;
        this.cod_organizacion_politica = cod_organizacion_politica;
        this.cod_tipo_cargo = cod_tipo_cargo;
        this.cod_afiliado = cod_afiliado;
        this.fechaCreo = fechaCreo;
        this.fechaModifico = fechaModifico;
        this.estado = estado;
    }

    public int getCod_comite_ejecutivo() {
        return this.cod_comite_ejecutivo;
    }

    public void setCod_comite_ejecutivo(int cod_comite_ejecutivo) {
        this.cod_comite_ejecutivo = cod_comite_ejecutivo;
    }

    public OrganizacionPolitica getCod_organizacion_politica() {
        return this.cod_organizacion_politica;
    }

    public void setCod_organizacion_politica(OrganizacionPolitica cod_organizacion_politica) {
        this.cod_organizacion_politica = cod_organizacion_politica;
    }

    public TipoCargo getCod_tipo_cargo() {
        return this.cod_tipo_cargo;
    }

    public void setCod_tipo_cargo(TipoCargo cod_tipo_cargo) {
        this.cod_tipo_cargo = cod_tipo_cargo;
    }

    public Afiliado getCod_afiliado() {
        return this.cod_afiliado;
    }

    public void setCod_afiliado(Afiliado cod_afiliado) {
        this.cod_afiliado = cod_afiliado;
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

    public ComiteEjecutivoNacional cod_comite_ejecutivo(int cod_comite_ejecutivo) {
        this.cod_comite_ejecutivo = cod_comite_ejecutivo;
        return this;
    }

    public ComiteEjecutivoNacional cod_organizacion_politica(OrganizacionPolitica cod_organizacion_politica) {
        this.cod_organizacion_politica = cod_organizacion_politica;
        return this;
    }

    public ComiteEjecutivoNacional cod_tipo_cargo(TipoCargo cod_tipo_cargo) {
        this.cod_tipo_cargo = cod_tipo_cargo;
        return this;
    }

    public ComiteEjecutivoNacional cod_afiliado(Afiliado cod_afiliado) {
        this.cod_afiliado = cod_afiliado;
        return this;
    }

    public ComiteEjecutivoNacional fechaCreo(Date fechaCreo) {
        this.fechaCreo = fechaCreo;
        return this;
    }

    public ComiteEjecutivoNacional fechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
        return this;
    }

    public ComiteEjecutivoNacional estado(byte estado) {
        this.estado = estado;
        return this;
    }

}
