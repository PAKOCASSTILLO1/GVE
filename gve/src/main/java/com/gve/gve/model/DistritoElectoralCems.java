package com.gve.gve.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "distrito_electoral_cems")
public class DistritoElectoralCems {

    @Id
    @Column(name = "cod_distrito")
    private int cod_distrito;

    private String nombre;
    private int categoria;
    private int anio;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "FK_COD_MUNICIPIO_DISTRITO", nullable = false, updatable = false)
    private Municipio cod_municipio;

    @Column(name = "fecha_creo")
    private Date fechaCreo;

    @Column(name = "fecha_modifico")
    private Date fechaModifico;
    private byte estado;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "FK_COD_ELECCION_DISTRITO", nullable = false, updatable = false)
    private Eleccion cod_eleccion;

    public DistritoElectoralCems() {
    }

    public DistritoElectoralCems(int cod_distrito, String nombre, int categoria, int anio, Municipio cod_municipio, Date fechaCreo, Date fechaModifico, byte estado, Eleccion cod_eleccion) {
        this.cod_distrito = cod_distrito;
        this.nombre = nombre;
        this.categoria = categoria;
        this.anio = anio;
        this.cod_municipio = cod_municipio;
        this.fechaCreo = fechaCreo;
        this.fechaModifico = fechaModifico;
        this.estado = estado;
        this.cod_eleccion = cod_eleccion;
    }

    public int getCod_distrito() {
        return this.cod_distrito;
    }

    public void setCod_distrito(int cod_distrito) {
        this.cod_distrito = cod_distrito;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCategoria() {
        return this.categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getAnio() {
        return this.anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Municipio getCod_municipio() {
        return this.cod_municipio;
    }

    public void setCod_municipio(Municipio cod_municipio) {
        this.cod_municipio = cod_municipio;
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

    public Eleccion getCod_eleccion() {
        return this.cod_eleccion;
    }

    public void setCod_eleccion(Eleccion cod_eleccion) {
        this.cod_eleccion = cod_eleccion;
    }

    public DistritoElectoralCems cod_distrito(int cod_distrito) {
        this.cod_distrito = cod_distrito;
        return this;
    }

    public DistritoElectoralCems nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public DistritoElectoralCems categoria(int categoria) {
        this.categoria = categoria;
        return this;
    }

    public DistritoElectoralCems anio(int anio) {
        this.anio = anio;
        return this;
    }

    public DistritoElectoralCems cod_municipio(Municipio cod_municipio) {
        this.cod_municipio = cod_municipio;
        return this;
    }

    public DistritoElectoralCems fechaCreo(Date fechaCreo) {
        this.fechaCreo = fechaCreo;
        return this;
    }

    public DistritoElectoralCems fechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
        return this;
    }

    public DistritoElectoralCems estado(byte estado) {
        this.estado = estado;
        return this;
    }

    public DistritoElectoralCems cod_eleccion(Eleccion cod_eleccion) {
        this.cod_eleccion = cod_eleccion;
        return this;
    }

}