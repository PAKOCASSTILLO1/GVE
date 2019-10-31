package com.gve.gve.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usuario_role")
public class UsuarioRole {

    @Id
    @Column(name = "cod_usuario_rol")
    private int cod_usuario_rol;

    private int usuario;
    private int rol;

    @Column(name = "usuario_creo")
    private int usuarioCreo;

    @Column(name = "fecha_creo")
    private Date fechaCreo;

    @Column(name = "usuario_modifico")
    private Integer usuarioModifico;

    @Column(name = "fecha_modifico")
    private Date fechaModifico;

    private int estado =1;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "cod_usuario", nullable = false, updatable = false)
    private Usuario cod_usuario;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "cod_role", nullable = false, updatable = false)
    private Rol cod_role;

    public UsuarioRole() {
    }

    public UsuarioRole(int cod_usuario_rol, int usuario, int rol, int usuarioCreo, Date fechaCreo, Integer usuarioModifico, Date fechaModifico, int estado, Usuario cod_usuario, Rol cod_role) {
        this.cod_usuario_rol = cod_usuario_rol;
        this.usuario = usuario;
        this.rol = rol;
        this.usuarioCreo = usuarioCreo;
        this.fechaCreo = fechaCreo;
        this.usuarioModifico = usuarioModifico;
        this.fechaModifico = fechaModifico;
        this.estado = estado;
        this.cod_usuario = cod_usuario;
        this.cod_role = cod_role;
    }

    public int getCod_usuario_rol() {
        return this.cod_usuario_rol;
    }

    public void setCod_usuario_rol(int cod_usuario_rol) {
        this.cod_usuario_rol = cod_usuario_rol;
    }

    public int getUsuario() {
        return this.usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getRol() {
        return this.rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getUsuarioCreo() {
        return this.usuarioCreo;
    }

    public void setUsuarioCreo(int usuarioCreo) {
        this.usuarioCreo = usuarioCreo;
    }

    public Date getFechaCreo() {
        return this.fechaCreo;
    }

    public void setFechaCreo(Date fechaCreo) {
        this.fechaCreo = fechaCreo;
    }

    public Integer getUsuarioModifico() {
        return this.usuarioModifico;
    }

    public void setUsuarioModifico(Integer usuarioModifico) {
        this.usuarioModifico = usuarioModifico;
    }

    public Date getFechaModifico() {
        return this.fechaModifico;
    }

    public void setFechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
    }

    public int getEstado() {
        return this.estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Usuario getCod_usuario() {
        return this.cod_usuario;
    }

    public void setCod_usuario(Usuario cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public Rol getCod_role() {
        return this.cod_role;
    }

    public void setCod_role(Rol cod_role) {
        this.cod_role = cod_role;
    }

    public UsuarioRole cod_usuario_rol(int cod_usuario_rol) {
        this.cod_usuario_rol = cod_usuario_rol;
        return this;
    }

    public UsuarioRole usuario(int usuario) {
        this.usuario = usuario;
        return this;
    }

    public UsuarioRole rol(int rol) {
        this.rol = rol;
        return this;
    }

    public UsuarioRole usuarioCreo(int usuarioCreo) {
        this.usuarioCreo = usuarioCreo;
        return this;
    }

    public UsuarioRole fechaCreo(Date fechaCreo) {
        this.fechaCreo = fechaCreo;
        return this;
    }

    public UsuarioRole usuarioModifico(Integer usuarioModifico) {
        this.usuarioModifico = usuarioModifico;
        return this;
    }

    public UsuarioRole fechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
        return this;
    }

    public UsuarioRole estado(int estado) {
        this.estado = estado;
        return this;
    }

    public UsuarioRole cod_usuario(Usuario cod_usuario) {
        this.cod_usuario = cod_usuario;
        return this;
    }

    public UsuarioRole cod_role(Rol cod_role) {
        this.cod_role = cod_role;
        return this;
    }

}
