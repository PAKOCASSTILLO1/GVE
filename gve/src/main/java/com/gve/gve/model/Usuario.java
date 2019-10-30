package com.gve.gve.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Usuario {
    @Id
    @Column(name = "cod_usuario")
    private int cod_usuario;

    private String username;
    private String password;
    private String email;

    @Column(name = "usuario_creo")
    private String usuarioCreo;

    @Column(name = "fecha_creo")
    private Date fechaCreo;

    @Column(name = "usuario_modifico")
    private Integer usuarioModifico;

    @Column(name = "fecha_modifico")
    private Date fechaModifico;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "FK_COD_PADRON_USUARIO", nullable = false, updatable = false)
    private Padron cod_padron;

    public Usuario() {
    }

    public Usuario(int cod_usuario, String username, String password, String email, String usuarioCreo, Date fechaCreo, Integer usuarioModifico, Date fechaModifico, Padron cod_padron) {
        this.cod_usuario = cod_usuario;
        this.username = username;
        this.password = password;
        this.email = email;
        this.usuarioCreo = usuarioCreo;
        this.fechaCreo = fechaCreo;
        this.usuarioModifico = usuarioModifico;
        this.fechaModifico = fechaModifico;
        this.cod_padron = cod_padron;
    }

    public int getCod_usuario() {
        return this.cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuarioCreo() {
        return this.usuarioCreo;
    }

    public void setUsuarioCreo(String usuarioCreo) {
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

    public Padron getCod_padron() {
        return this.cod_padron;
    }

    public void setCod_padron(Padron cod_padron) {
        this.cod_padron = cod_padron;
    }

    public Usuario cod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
        return this;
    }

    public Usuario username(String username) {
        this.username = username;
        return this;
    }

    public Usuario password(String password) {
        this.password = password;
        return this;
    }

    public Usuario email(String email) {
        this.email = email;
        return this;
    }

    public Usuario usuarioCreo(String usuarioCreo) {
        this.usuarioCreo = usuarioCreo;
        return this;
    }

    public Usuario fechaCreo(Date fechaCreo) {
        this.fechaCreo = fechaCreo;
        return this;
    }

    public Usuario usuarioModifico(Integer usuarioModifico) {
        this.usuarioModifico = usuarioModifico;
        return this;
    }

    public Usuario fechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
        return this;
    }

    public Usuario cod_padron(Padron cod_padron) {
        this.cod_padron = cod_padron;
        return this;
    }

}
