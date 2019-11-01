package com.gve.gve.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "voto_organizacion", schema = "GVE", catalog = "")
public class VotoOrganizacion {

    @Id
    @Column(name = "cod_voto_organizacion")
    private int cod_voto_organizacion;

    private int organizacionPolitica;
    private int voto;

    @ManyToOne
    @JoinColumn(name = "cod_organizacion_politica", nullable = false, updatable = false)
    private OrganizacionPolitica cod_organizacion_politica;

    @ManyToOne
    @JoinColumn(name = "cod_voto", nullable = false, updatable = false)
    private Voto cod_voto;

    @Column(name = "usuario_creo")
    private int usuarioCreo;

    @Column(name = "usuario_modifico")
    private int usuarioModifico;

    @Column(name = "fecha_creo")
    private Date fechaCreo = new Date();

    @Column(name = "fecha_modifico")
    private Date fechaModifico;

    public VotoOrganizacion() {
    }

    public VotoOrganizacion(int cod_voto_organizacion, int organizacionPolitica, int voto, OrganizacionPolitica cod_organizacion_politica, Voto cod_voto, int usuarioCreo, int usuarioModifico, Date fechaCreo, Date fechaModifico) {
        this.cod_voto_organizacion = cod_voto_organizacion;
        this.organizacionPolitica = organizacionPolitica;
        this.voto = voto;
        this.cod_organizacion_politica = cod_organizacion_politica;
        this.cod_voto = cod_voto;
        this.usuarioCreo = usuarioCreo;
        this.usuarioModifico = usuarioModifico;
        this.fechaCreo = fechaCreo;
        this.fechaModifico = fechaModifico;
    }

    public int getCod_voto_organizacion() {
        return this.cod_voto_organizacion;
    }

    public void setCod_voto_organizacion(int cod_voto_organizacion) {
        this.cod_voto_organizacion = cod_voto_organizacion;
    }

    public int getOrganizacionPolitica() {
        return this.organizacionPolitica;
    }

    public void setOrganizacionPolitica(int organizacionPolitica) {
        this.organizacionPolitica = organizacionPolitica;
    }

    public int getVoto() {
        return this.voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public OrganizacionPolitica getCod_organizacion_politica() {
        return this.cod_organizacion_politica;
    }

    public void setCod_organizacion_politica(OrganizacionPolitica cod_organizacion_politica) {
        this.cod_organizacion_politica = cod_organizacion_politica;
    }

    public Voto getCod_voto() {
        return this.cod_voto;
    }

    public void setCod_voto(Voto cod_voto) {
        this.cod_voto = cod_voto;
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

    public VotoOrganizacion cod_voto_organizacion(int cod_voto_organizacion) {
        this.cod_voto_organizacion = cod_voto_organizacion;
        return this;
    }

    public VotoOrganizacion organizacionPolitica(int organizacionPolitica) {
        this.organizacionPolitica = organizacionPolitica;
        return this;
    }

    public VotoOrganizacion voto(int voto) {
        this.voto = voto;
        return this;
    }

    public VotoOrganizacion cod_organizacion_politica(OrganizacionPolitica cod_organizacion_politica) {
        this.cod_organizacion_politica = cod_organizacion_politica;
        return this;
    }

    public VotoOrganizacion cod_voto(Voto cod_voto) {
        this.cod_voto = cod_voto;
        return this;
    }

    public VotoOrganizacion usuarioCreo(int usuarioCreo) {
        this.usuarioCreo = usuarioCreo;
        return this;
    }

    public VotoOrganizacion usuarioModifico(int usuarioModifico) {
        this.usuarioModifico = usuarioModifico;
        return this;
    }

    public VotoOrganizacion fechaCreo(Date fechaCreo) {
        this.fechaCreo = fechaCreo;
        return this;
    }

    public VotoOrganizacion fechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
        return this;
    }

}
