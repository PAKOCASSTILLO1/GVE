package com.gve.gve.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Candidato {
    @Id
    @Column(name = "cod_candidato")
    private int cod_candidato;

    private int tipoVotacion;
    private int organizacionPolitica;
    private int afiliado;
    private int tipoCargo;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "cod_tipo_votacion", nullable = false, updatable = false)
    private TipoVotacion cod_tipo_votacion;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "cod_organizacion_politica", nullable = false, updatable = false)
    private OrganizacionPolitica cod_organizacion_politica;

    @Column(name = "fecha_creo")
    private Date fechaCreo;

    @Column(name = "fecha_modifico")
    private Date fechaModifico;

    private byte estado =1;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "cod_afiliado", nullable = false, updatable = false)
    private Afiliado cod_afiliado;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "cod_tipo_cargo", nullable = false, updatable = false)
    private TipoCargo cod_tipo_cargo;


    public Candidato() {
    }

    public Candidato(int cod_candidato, int tipoVotacion, int organizacionPolitica, int afiliado, int tipoCargo, TipoVotacion cod_tipo_votacion, OrganizacionPolitica cod_organizacion_politica, Date fechaCreo, Date fechaModifico, byte estado, Afiliado cod_afiliado, TipoCargo cod_tipo_cargo) {
        this.cod_candidato = cod_candidato;
        this.tipoVotacion = tipoVotacion;
        this.organizacionPolitica = organizacionPolitica;
        this.afiliado = afiliado;
        this.tipoCargo = tipoCargo;
        this.cod_tipo_votacion = cod_tipo_votacion;
        this.cod_organizacion_politica = cod_organizacion_politica;
        this.fechaCreo = fechaCreo;
        this.fechaModifico = fechaModifico;
        this.estado = estado;
        this.cod_afiliado = cod_afiliado;
        this.cod_tipo_cargo = cod_tipo_cargo;
    }

    public int getCod_candidato() {
        return this.cod_candidato;
    }

    public void setCod_candidato(int cod_candidato) {
        this.cod_candidato = cod_candidato;
    }

    public int getTipoVotacion() {
        return this.tipoVotacion;
    }

    public void setTipoVotacion(int tipoVotacion) {
        this.tipoVotacion = tipoVotacion;
    }

    public int getOrganizacionPolitica() {
        return this.organizacionPolitica;
    }

    public void setOrganizacionPolitica(int organizacionPolitica) {
        this.organizacionPolitica = organizacionPolitica;
    }

    public int getAfiliado() {
        return this.afiliado;
    }

    public void setAfiliado(int afiliado) {
        this.afiliado = afiliado;
    }

    public int getTipoCargo() {
        return this.tipoCargo;
    }

    public void setTipoCargo(int tipoCargo) {
        this.tipoCargo = tipoCargo;
    }

    public TipoVotacion getCod_tipo_votacion() {
        return this.cod_tipo_votacion;
    }

    public void setCod_tipo_votacion(TipoVotacion cod_tipo_votacion) {
        this.cod_tipo_votacion = cod_tipo_votacion;
    }

    public OrganizacionPolitica getCod_organizacion_politica() {
        return this.cod_organizacion_politica;
    }

    public void setCod_organizacion_politica(OrganizacionPolitica cod_organizacion_politica) {
        this.cod_organizacion_politica = cod_organizacion_politica;
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

    public Afiliado getCod_afiliado() {
        return this.cod_afiliado;
    }

    public void setCod_afiliado(Afiliado cod_afiliado) {
        this.cod_afiliado = cod_afiliado;
    }

    public TipoCargo getCod_tipo_cargo() {
        return this.cod_tipo_cargo;
    }

    public void setCod_tipo_cargo(TipoCargo cod_tipo_cargo) {
        this.cod_tipo_cargo = cod_tipo_cargo;
    }

    public Candidato cod_candidato(int cod_candidato) {
        this.cod_candidato = cod_candidato;
        return this;
    }

    public Candidato tipoVotacion(int tipoVotacion) {
        this.tipoVotacion = tipoVotacion;
        return this;
    }

    public Candidato organizacionPolitica(int organizacionPolitica) {
        this.organizacionPolitica = organizacionPolitica;
        return this;
    }

    public Candidato afiliado(int afiliado) {
        this.afiliado = afiliado;
        return this;
    }

    public Candidato tipoCargo(int tipoCargo) {
        this.tipoCargo = tipoCargo;
        return this;
    }

    public Candidato cod_tipo_votacion(TipoVotacion cod_tipo_votacion) {
        this.cod_tipo_votacion = cod_tipo_votacion;
        return this;
    }

    public Candidato cod_organizacion_politica(OrganizacionPolitica cod_organizacion_politica) {
        this.cod_organizacion_politica = cod_organizacion_politica;
        return this;
    }

    public Candidato fechaCreo(Date fechaCreo) {
        this.fechaCreo = fechaCreo;
        return this;
    }

    public Candidato fechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
        return this;
    }

    public Candidato estado(byte estado) {
        this.estado = estado;
        return this;
    }

    public Candidato cod_afiliado(Afiliado cod_afiliado) {
        this.cod_afiliado = cod_afiliado;
        return this;
    }

    public Candidato cod_tipo_cargo(TipoCargo cod_tipo_cargo) {
        this.cod_tipo_cargo = cod_tipo_cargo;
        return this;
    }

}
