package com.gve.gve.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "fiscal_organizacion")
public class FiscalOrganizacion {

    @Id
    @Column(name = "cod_fiscal")
    private int cod_fiscal;

    private int organizacionPolitica;
    private int tipoFiscal;
    private int afiliado;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "cod_organizacion_politica", nullable = false, updatable = false)
    private OrganizacionPolitica cod_organizacion_politica;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "cod_tipo_fiscal", nullable = false, updatable = false)
    private TipoFiscal cod_tipo_fiscal;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "cod_afiliado", nullable = false, updatable = false)
    private Afiliado cod_afiliado;

    @Column(name = "fecha_creo")
    private Date fechaCreo;

    @Column(name = "fecha_modifico")
    private Date fechaModifico;

    private byte estado =1;


    public FiscalOrganizacion() {
    }

    public FiscalOrganizacion(int cod_fiscal, int organizacionPolitica, int tipoFiscal, int afiliado, OrganizacionPolitica cod_organizacion_politica, TipoFiscal cod_tipo_fiscal, Afiliado cod_afiliado, Date fechaCreo, Date fechaModifico, byte estado) {
        this.cod_fiscal = cod_fiscal;
        this.organizacionPolitica = organizacionPolitica;
        this.tipoFiscal = tipoFiscal;
        this.afiliado = afiliado;
        this.cod_organizacion_politica = cod_organizacion_politica;
        this.cod_tipo_fiscal = cod_tipo_fiscal;
        this.cod_afiliado = cod_afiliado;
        this.fechaCreo = fechaCreo;
        this.fechaModifico = fechaModifico;
        this.estado = estado;
    }

    public int getCod_fiscal() {
        return this.cod_fiscal;
    }

    public void setCod_fiscal(int cod_fiscal) {
        this.cod_fiscal = cod_fiscal;
    }

    public int getOrganizacionPolitica() {
        return this.organizacionPolitica;
    }

    public void setOrganizacionPolitica(int organizacionPolitica) {
        this.organizacionPolitica = organizacionPolitica;
    }

    public int getTipoFiscal() {
        return this.tipoFiscal;
    }

    public void setTipoFiscal(int tipoFiscal) {
        this.tipoFiscal = tipoFiscal;
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

    public TipoFiscal getCod_tipo_fiscal() {
        return this.cod_tipo_fiscal;
    }

    public void setCod_tipo_fiscal(TipoFiscal cod_tipo_fiscal) {
        this.cod_tipo_fiscal = cod_tipo_fiscal;
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

    public FiscalOrganizacion cod_fiscal(int cod_fiscal) {
        this.cod_fiscal = cod_fiscal;
        return this;
    }

    public FiscalOrganizacion organizacionPolitica(int organizacionPolitica) {
        this.organizacionPolitica = organizacionPolitica;
        return this;
    }

    public FiscalOrganizacion tipoFiscal(int tipoFiscal) {
        this.tipoFiscal = tipoFiscal;
        return this;
    }

    public FiscalOrganizacion afiliado(int afiliado) {
        this.afiliado = afiliado;
        return this;
    }

    public FiscalOrganizacion cod_organizacion_politica(OrganizacionPolitica cod_organizacion_politica) {
        this.cod_organizacion_politica = cod_organizacion_politica;
        return this;
    }

    public FiscalOrganizacion cod_tipo_fiscal(TipoFiscal cod_tipo_fiscal) {
        this.cod_tipo_fiscal = cod_tipo_fiscal;
        return this;
    }

    public FiscalOrganizacion cod_afiliado(Afiliado cod_afiliado) {
        this.cod_afiliado = cod_afiliado;
        return this;
    }

    public FiscalOrganizacion fechaCreo(Date fechaCreo) {
        this.fechaCreo = fechaCreo;
        return this;
    }

    public FiscalOrganizacion fechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
        return this;
    }

    public FiscalOrganizacion estado(byte estado) {
        this.estado = estado;
        return this;
    }

}
