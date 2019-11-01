package com.gve.gve.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comite_ejecutivo_nacional")
public class ComiteEjecutivoNacional {

    @Id
    @Column(name = "cod_comite_ejecutivo")
    private int cod_comite_ejecutivo;

    private int organizacionPolitica;
    private int tipoCargo;
    private int afiliado;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "cod_organizacion_politica", nullable = false, updatable = false)
    private OrganizacionPolitica cod_organizacion_politica;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "cod_tipo_cargo", nullable = false, updatable = false)
    private TipoCargo cod_tipo_cargo;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "cod_afiliado", nullable = false, updatable = false)
    private Afiliado cod_afiliado;

    @Column(name = "usuario_creo")
    private int usuarioCreo;

    @Column(name = "usuario_modifico")
    private int usuarioModifico;

    @Column(name = "fecha_creo")
    private Date fechaCreo = new Date();

    @Column(name = "fecha_modifico")
    private Date fechaModifico;

    private byte estado =1;


    public ComiteEjecutivoNacional() {
    }

    public ComiteEjecutivoNacional(int cod_comite_ejecutivo, int organizacionPolitica, int tipoCargo, int afiliado, OrganizacionPolitica cod_organizacion_politica, TipoCargo cod_tipo_cargo, Afiliado cod_afiliado, int usuarioCreo, int usuarioModifico, Date fechaCreo, Date fechaModifico, byte estado) {
        this.cod_comite_ejecutivo = cod_comite_ejecutivo;
        this.organizacionPolitica = organizacionPolitica;
        this.tipoCargo = tipoCargo;
        this.afiliado = afiliado;
        this.cod_organizacion_politica = cod_organizacion_politica;
        this.cod_tipo_cargo = cod_tipo_cargo;
        this.cod_afiliado = cod_afiliado;
        this.usuarioCreo = usuarioCreo;
        this.usuarioModifico = usuarioModifico;
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

    public int getOrganizacionPolitica() {
        return this.organizacionPolitica;
    }

    public void setOrganizacionPolitica(int organizacionPolitica) {
        this.organizacionPolitica = organizacionPolitica;
    }

    public int getTipoCargo() {
        return this.tipoCargo;
    }

    public void setTipoCargo(int tipoCargo) {
        this.tipoCargo = tipoCargo;
    }

    public int getAfiliado() {
        return this.afiliado;
    }

    public void setAfiliado(int afiliado) {
        this.afiliado = afiliado;
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

    public int getUsuarioCreo() {
        return this.usuarioCreo;
    }

    public void setUsuarioCreo(int usuarioCreo) {
        this.usuarioCreo = usuarioCreo;
    }

    public int getUsuarioModifico() {
        return this.usuarioModifico;
    }

    public void setUsuarioModifico(int usuarioModifico) {
        this.usuarioModifico = usuarioModifico;
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

    public ComiteEjecutivoNacional organizacionPolitica(int organizacionPolitica) {
        this.organizacionPolitica = organizacionPolitica;
        return this;
    }

    public ComiteEjecutivoNacional tipoCargo(int tipoCargo) {
        this.tipoCargo = tipoCargo;
        return this;
    }

    public ComiteEjecutivoNacional afiliado(int afiliado) {
        this.afiliado = afiliado;
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

    public ComiteEjecutivoNacional usuarioCreo(int usuarioCreo) {
        this.usuarioCreo = usuarioCreo;
        return this;
    }

    public ComiteEjecutivoNacional usuarioModifico(int usuarioModifico) {
        this.usuarioModifico = usuarioModifico;
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
