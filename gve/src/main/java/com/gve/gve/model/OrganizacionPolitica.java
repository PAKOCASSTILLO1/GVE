package com.gve.gve.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "organizacion_politica")
public class OrganizacionPolitica {

    @Id
    @Column(name = "cod_organizacion_politica")
    private int cod_organizacion_politica;

    private String nombre;
    private String descripcion;

    private int tipoOrganizacion;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "cod_tipo_organizacion", nullable = false, updatable = false)
    private TipoOrganizacion cod_tipo_organizacion;

    @Column(name = "fecha_constitucion")
    private Date fechaConstitucion;

    @Column(name = "fecha_cancelacion")
    private Date fechaCancelacion;

    @Column(name = "fecha_creo")
    private Date fechaCreo;

    @Column(name = "fecha_modifico")
    private Date fechaModifico;

    private byte estado = 1;

    public OrganizacionPolitica() {
    }

    public OrganizacionPolitica(int cod_organizacion_politica, String nombre, String descripcion, int tipoOrganizacion, TipoOrganizacion cod_tipo_organizacion, Date fechaConstitucion, Date fechaCancelacion, Date fechaCreo, Date fechaModifico, byte estado) {
        this.cod_organizacion_politica = cod_organizacion_politica;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoOrganizacion = tipoOrganizacion;
        this.cod_tipo_organizacion = cod_tipo_organizacion;
        this.fechaConstitucion = fechaConstitucion;
        this.fechaCancelacion = fechaCancelacion;
        this.fechaCreo = fechaCreo;
        this.fechaModifico = fechaModifico;
        this.estado = estado;
    }

    public int getCod_organizacion_politica() {
        return this.cod_organizacion_politica;
    }

    public void setCod_organizacion_politica(int cod_organizacion_politica) {
        this.cod_organizacion_politica = cod_organizacion_politica;
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

    public int getTipoOrganizacion() {
        return this.tipoOrganizacion;
    }

    public void setTipoOrganizacion(int tipoOrganizacion) {
        this.tipoOrganizacion = tipoOrganizacion;
    }

    public TipoOrganizacion getCod_tipo_organizacion() {
        return this.cod_tipo_organizacion;
    }

    public void setCod_tipo_organizacion(TipoOrganizacion cod_tipo_organizacion) {
        this.cod_tipo_organizacion = cod_tipo_organizacion;
    }

    public Date getFechaConstitucion() {
        return this.fechaConstitucion;
    }

    public void setFechaConstitucion(Date fechaConstitucion) {
        this.fechaConstitucion = fechaConstitucion;
    }

    public Date getFechaCancelacion() {
        return this.fechaCancelacion;
    }

    public void setFechaCancelacion(Date fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
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

    public OrganizacionPolitica cod_organizacion_politica(int cod_organizacion_politica) {
        this.cod_organizacion_politica = cod_organizacion_politica;
        return this;
    }

    public OrganizacionPolitica nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public OrganizacionPolitica descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public OrganizacionPolitica tipoOrganizacion(int tipoOrganizacion) {
        this.tipoOrganizacion = tipoOrganizacion;
        return this;
    }

    public OrganizacionPolitica cod_tipo_organizacion(TipoOrganizacion cod_tipo_organizacion) {
        this.cod_tipo_organizacion = cod_tipo_organizacion;
        return this;
    }

    public OrganizacionPolitica fechaConstitucion(Date fechaConstitucion) {
        this.fechaConstitucion = fechaConstitucion;
        return this;
    }

    public OrganizacionPolitica fechaCancelacion(Date fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
        return this;
    }

    public OrganizacionPolitica fechaCreo(Date fechaCreo) {
        this.fechaCreo = fechaCreo;
        return this;
    }

    public OrganizacionPolitica fechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
        return this;
    }

    public OrganizacionPolitica estado(byte estado) {
        this.estado = estado;
        return this;
    }

}
