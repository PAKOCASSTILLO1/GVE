package com.gve.gve.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Afiliado {

    @Id
    @Column(name = "cod_afiliado")
    private int cod_afiliado;

    @Column(name = "fecha_afilicacion")
    private Date fechaAfilicacion;

    @Column(name = "fecha_finalizacion")
    private String fechaFinalizacion;

    private int organizacionPolitica;
    private int padron;

    @ManyToOne
    @JoinColumn(name = "cod_organizacion_politica", nullable = false, updatable = false)
    private OrganizacionPolitica cod_organizacion_politica;

    @ManyToOne
    @JoinColumn(name = "cod_padron", nullable = false, updatable = false)
    private Padron cod_padron;

    @Column(name = "fecha_creo")
    private Date fechaCreo;

    @Column(name = "fecha_modifico")
    private Date fechaModifico;

    private Byte estado =1;

    public Afiliado modified( Afiliado body, Padron padron, OrganizacionPolitica organizacionPolitica) {
        this.fechaAfilicacion = body.getFechaAfilicacion();
        this.fechaFinalizacion = body.getFechaFinalizacion();
        this.organizacionPolitica = organizacionPolitica.getCod_organizacion_politica();
        this.padron = padron.getCod_padron();
        this.cod_organizacion_politica = organizacionPolitica;
        this.cod_padron = padron;
        return this;
    }

    public Afiliado() {
    }

    public Afiliado(int cod_afiliado, Date fechaAfilicacion, String fechaFinalizacion, int organizacionPolitica, int padron, OrganizacionPolitica cod_organizacion_politica, Padron cod_padron, Date fechaCreo, Date fechaModifico, Byte estado) {
        this.cod_afiliado = cod_afiliado;
        this.fechaAfilicacion = fechaAfilicacion;
        this.fechaFinalizacion = fechaFinalizacion;
        this.organizacionPolitica = organizacionPolitica;
        this.padron = padron;
        this.cod_organizacion_politica = cod_organizacion_politica;
        this.cod_padron = cod_padron;
        this.fechaCreo = fechaCreo;
        this.fechaModifico = fechaModifico;
        this.estado = estado;
    }

    public int getCod_afiliado() {
        return this.cod_afiliado;
    }

    public void setCod_afiliado(int cod_afiliado) {
        this.cod_afiliado = cod_afiliado;
    }

    public Date getFechaAfilicacion() {
        return this.fechaAfilicacion;
    }

    public void setFechaAfilicacion(Date fechaAfilicacion) {
        this.fechaAfilicacion = fechaAfilicacion;
    }

    public String getFechaFinalizacion() {
        return this.fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public int getOrganizacionPolitica() {
        return this.organizacionPolitica;
    }

    public void setOrganizacionPolitica(int organizacionPolitica) {
        this.organizacionPolitica = organizacionPolitica;
    }

    public int getPadron() {
        return this.padron;
    }

    public void setPadron(int padron) {
        this.padron = padron;
    }

    public OrganizacionPolitica getCod_organizacion_politica() {
        return this.cod_organizacion_politica;
    }

    public void setCod_organizacion_politica(OrganizacionPolitica cod_organizacion_politica) {
        this.cod_organizacion_politica = cod_organizacion_politica;
    }

    public Padron getCod_padron() {
        return this.cod_padron;
    }

    public void setCod_padron(Padron cod_padron) {
        this.cod_padron = cod_padron;
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

    public Byte getEstado() {
        return this.estado;
    }

    public void setEstado(Byte estado) {
        this.estado = estado;
    }

    public Afiliado cod_afiliado(int cod_afiliado) {
        this.cod_afiliado = cod_afiliado;
        return this;
    }

    public Afiliado fechaAfilicacion(Date fechaAfilicacion) {
        this.fechaAfilicacion = fechaAfilicacion;
        return this;
    }

    public Afiliado fechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
        return this;
    }

    public Afiliado organizacionPolitica(int organizacionPolitica) {
        this.organizacionPolitica = organizacionPolitica;
        return this;
    }

    public Afiliado padron(int padron) {
        this.padron = padron;
        return this;
    }

    public Afiliado cod_organizacion_politica(OrganizacionPolitica cod_organizacion_politica) {
        this.cod_organizacion_politica = cod_organizacion_politica;
        return this;
    }

    public Afiliado cod_padron(Padron cod_padron) {
        this.cod_padron = cod_padron;
        return this;
    }

    public Afiliado fechaCreo(Date fechaCreo) {
        this.fechaCreo = fechaCreo;
        return this;
    }

    public Afiliado fechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
        return this;
    }

    public Afiliado estado(Byte estado) {
        this.estado = estado;
        return this;
    }

}
