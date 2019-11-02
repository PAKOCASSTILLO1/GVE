package com.gve.gve.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "centro_votacion")
public class CentroVotacion {

    @Id
    @Column(name = "cod_centro_votacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_centro_votacion;

    private String nombre;

    // @Column(name = "ubicacion_geografica")
    // private Object ubicacionGeografica;

    private String direccion;
    private String telefono;
    private int distrito;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "cod_distrito", nullable = false, updatable = false)
    private DistritoElectoralCems cod_distrito;

    @Column(name = "usuario_creo")
    private int usuarioCreo;

    @Column(name = "usuario_modifico")
    private int usuarioModifico;

    @Column(name = "fecha_creo")
    private Date fechaCreo = new Date();

    @Column(name = "fecha_modifico")
    private Date fechaModifico;

    private byte estado = 1;

    public CentroVotacion modified(CentroVotacion body, DistritoElectoralCems distrito) {
        this.nombre = body.getNombre();
        this.direccion = body.getDireccion();
        this.telefono = body.getTelefono();
        this.distrito = distrito.getCod_distrito();
        this.cod_distrito = distrito;
        this.fechaModifico = new Date();
        this.usuarioModifico = body.getUsuarioModifico();
        return this;
    }


    public CentroVotacion() {
    }

    public CentroVotacion(int cod_centro_votacion, String nombre, String direccion, String telefono, int distrito, DistritoElectoralCems cod_distrito, int usuarioCreo, int usuarioModifico, Date fechaCreo, Date fechaModifico, byte estado) {
        this.cod_centro_votacion = cod_centro_votacion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.distrito = distrito;
        this.cod_distrito = cod_distrito;
        this.usuarioCreo = usuarioCreo;
        this.usuarioModifico = usuarioModifico;
        this.fechaCreo = fechaCreo;
        this.fechaModifico = fechaModifico;
        this.estado = estado;
    }

    public int getCod_centro_votacion() {
        return this.cod_centro_votacion;
    }

    public void setCod_centro_votacion(int cod_centro_votacion) {
        this.cod_centro_votacion = cod_centro_votacion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getDistrito() {
        return this.distrito;
    }

    public void setDistrito(int distrito) {
        this.distrito = distrito;
    }

    public DistritoElectoralCems getCod_distrito() {
        return this.cod_distrito;
    }

    public void setCod_distrito(DistritoElectoralCems cod_distrito) {
        this.cod_distrito = cod_distrito;
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

    public CentroVotacion cod_centro_votacion(int cod_centro_votacion) {
        this.cod_centro_votacion = cod_centro_votacion;
        return this;
    }

    public CentroVotacion nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public CentroVotacion direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public CentroVotacion telefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public CentroVotacion distrito(int distrito) {
        this.distrito = distrito;
        return this;
    }

    public CentroVotacion cod_distrito(DistritoElectoralCems cod_distrito) {
        this.cod_distrito = cod_distrito;
        return this;
    }

    public CentroVotacion usuarioCreo(int usuarioCreo) {
        this.usuarioCreo = usuarioCreo;
        return this;
    }

    public CentroVotacion usuarioModifico(int usuarioModifico) {
        this.usuarioModifico = usuarioModifico;
        return this;
    }

    public CentroVotacion fechaCreo(Date fechaCreo) {
        this.fechaCreo = fechaCreo;
        return this;
    }

    public CentroVotacion fechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
        return this;
    }

    public CentroVotacion estado(byte estado) {
        this.estado = estado;
        return this;
    }

}
