package com.gve.gve.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Padron {

    @Id
    @Column(name = "cod_padron")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_padron;

    @Column(name = "primer_nombre")
    private String primerNombre;

    @Column(name = "segundo_nombre")
    private String segundoNombre;

    @Column(name = "primer_apellido")
    private String primerApellido;

    @Column(name = "segundo_apellido")
    private String segundoApellido;

    @Column(name = "apellido_casada")
    private String apellidoCasada;

    @Column(name = "CUI")
    private String cui;

    @Column(name = "dir_departamento")
    private int dirDepartamento;

    @Column(name = "dir_municipio")
    private int dirMunicipio;

    private String direccion;
    private int zona;
    private String comunidad;

    // @Column(name = "ubicacion_geografica")
    // private Object ubicacionGeografica;

    @Column(name = "fecha_creo")
    private Date fechaCreo = new Date();

    @Column(name = "fecha_modifico")
    private Date fechaModifico;

    private byte estado = 1;

    public Padron modified(Padron body) {
        this.primerNombre = body.getPrimerNombre();
        this.segundoNombre = body.getSegundoNombre();
        this.primerApellido = body.getPrimerApellido();
        this.segundoApellido = body.getSegundoApellido();
        this.apellidoCasada = body.getApellidoCasada();
        this.cui = body.getCui();
        this.dirDepartamento = body.getDirDepartamento();
        this.dirMunicipio = body.getDirMunicipio();
        this.direccion = body.getDireccion();
        this.zona = body.getZona();
        this.comunidad = body.getComunidad();
        this.fechaModifico = new Date();
        return this;
    }

    public Padron() {
    }

    // public Padron(int cod_padron, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String apellidoCasada, String cui, int dirDepartamento, int dirMunicipio, String direccion, int zona, String comunidad, Object ubicacionGeografica, Date fechaCreo, Date fechaModifico, byte estado) {
    //     this.cod_padron = cod_padron;
    //     this.primerNombre = primerNombre;
    //     this.segundoNombre = segundoNombre;
    //     this.primerApellido = primerApellido;
    //     this.segundoApellido = segundoApellido;
    //     this.apellidoCasada = apellidoCasada;
    //     this.cui = cui;
    //     this.dirDepartamento = dirDepartamento;
    //     this.dirMunicipio = dirMunicipio;
    //     this.direccion = direccion;
    //     this.zona = zona;
    //     this.comunidad = comunidad;
    //     this.ubicacionGeografica = ubicacionGeografica;
    //     this.fechaCreo = fechaCreo;
    //     this.fechaModifico = fechaModifico;
    //     this.estado = estado;
    // }

    public int getCod_padron() {
        return this.cod_padron;
    }

    public void setCod_padron(int cod_padron) {
        this.cod_padron = cod_padron;
    }

    public String getPrimerNombre() {
        return this.primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return this.segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return this.primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return this.segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getApellidoCasada() {
        return this.apellidoCasada;
    }

    public void setApellidoCasada(String apellidoCasada) {
        this.apellidoCasada = apellidoCasada;
    }

    public String getCui() {
        return this.cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public int getDirDepartamento() {
        return this.dirDepartamento;
    }

    public void setDirDepartamento(int dirDepartamento) {
        this.dirDepartamento = dirDepartamento;
    }

    public int getDirMunicipio() {
        return this.dirMunicipio;
    }

    public void setDirMunicipio(int dirMunicipio) {
        this.dirMunicipio = dirMunicipio;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getZona() {
        return this.zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public String getComunidad() {
        return this.comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    // public Object getUbicacionGeografica() {
    //     return this.ubicacionGeografica;
    // }

    // public void setUbicacionGeografica(Object ubicacionGeografica) {
    //     this.ubicacionGeografica = ubicacionGeografica;
    // }

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

    public Padron cod_padron(int cod_padron) {
        this.cod_padron = cod_padron;
        return this;
    }

    public Padron primerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
        return this;
    }

    public Padron segundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
        return this;
    }

    public Padron primerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
        return this;
    }

    public Padron segundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
        return this;
    }

    public Padron apellidoCasada(String apellidoCasada) {
        this.apellidoCasada = apellidoCasada;
        return this;
    }

    public Padron cui(String cui) {
        this.cui = cui;
        return this;
    }

    public Padron dirDepartamento(int dirDepartamento) {
        this.dirDepartamento = dirDepartamento;
        return this;
    }

    public Padron dirMunicipio(int dirMunicipio) {
        this.dirMunicipio = dirMunicipio;
        return this;
    }

    public Padron direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public Padron zona(int zona) {
        this.zona = zona;
        return this;
    }

    public Padron comunidad(String comunidad) {
        this.comunidad = comunidad;
        return this;
    }

    // public Padron ubicacionGeografica(Object ubicacionGeografica) {
    //     this.ubicacionGeografica = ubicacionGeografica;
    //     return this;
    // }

    public Padron fechaCreo(Date fechaCreo) {
        this.fechaCreo = fechaCreo;
        return this;
    }

    public Padron fechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
        return this;
    }

    public Padron estado(byte estado) {
        this.estado = estado;
        return this;
    }

}
