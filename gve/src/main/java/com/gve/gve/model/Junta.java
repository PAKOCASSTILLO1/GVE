package com.gve.gve.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Junta {

    @Id
    @Column(name = "cod_junta")
    private int cod_junta;

    private int mesa;
    private int padron;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "cod_mesa", nullable = false, updatable = false)
    private Mesa cod_mesa;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "cod_padron", nullable = false, updatable = false)
    private Padron cod_padron;

    private byte cargo;

    @Column(name = "tipo_junta")
    private byte tipoJunta;

    @Column(name = "usuario_creo")
    private int usuarioCreo;

    @Column(name = "fecha_creo")
    private Date fechaCreo;

    @Column(name = "usuario_modifico")
    private Integer usuarioModifico;

    @Column(name = "fecha_modifico")
    private Date fechaModifico;

    private byte estado =1;

    public Junta() {
    }

    public Junta(int cod_junta, int mesa, int padron, Mesa cod_mesa, Padron cod_padron, byte cargo, byte tipoJunta, int usuarioCreo, Date fechaCreo, Integer usuarioModifico, Date fechaModifico, byte estado) {
        this.cod_junta = cod_junta;
        this.mesa = mesa;
        this.padron = padron;
        this.cod_mesa = cod_mesa;
        this.cod_padron = cod_padron;
        this.cargo = cargo;
        this.tipoJunta = tipoJunta;
        this.usuarioCreo = usuarioCreo;
        this.fechaCreo = fechaCreo;
        this.usuarioModifico = usuarioModifico;
        this.fechaModifico = fechaModifico;
        this.estado = estado;
    }

    public int getCod_junta() {
        return this.cod_junta;
    }

    public void setCod_junta(int cod_junta) {
        this.cod_junta = cod_junta;
    }

    public int getMesa() {
        return this.mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public int getPadron() {
        return this.padron;
    }

    public void setPadron(int padron) {
        this.padron = padron;
    }

    public Mesa getCod_mesa() {
        return this.cod_mesa;
    }

    public void setCod_mesa(Mesa cod_mesa) {
        this.cod_mesa = cod_mesa;
    }

    public Padron getCod_padron() {
        return this.cod_padron;
    }

    public void setCod_padron(Padron cod_padron) {
        this.cod_padron = cod_padron;
    }

    public byte getCargo() {
        return this.cargo;
    }

    public void setCargo(byte cargo) {
        this.cargo = cargo;
    }

    public byte getTipoJunta() {
        return this.tipoJunta;
    }

    public void setTipoJunta(byte tipoJunta) {
        this.tipoJunta = tipoJunta;
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

    public byte getEstado() {
        return this.estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    public Junta cod_junta(int cod_junta) {
        this.cod_junta = cod_junta;
        return this;
    }

    public Junta mesa(int mesa) {
        this.mesa = mesa;
        return this;
    }

    public Junta padron(int padron) {
        this.padron = padron;
        return this;
    }

    public Junta cod_mesa(Mesa cod_mesa) {
        this.cod_mesa = cod_mesa;
        return this;
    }

    public Junta cod_padron(Padron cod_padron) {
        this.cod_padron = cod_padron;
        return this;
    }

    public Junta cargo(byte cargo) {
        this.cargo = cargo;
        return this;
    }

    public Junta tipoJunta(byte tipoJunta) {
        this.tipoJunta = tipoJunta;
        return this;
    }

    public Junta usuarioCreo(int usuarioCreo) {
        this.usuarioCreo = usuarioCreo;
        return this;
    }

    public Junta fechaCreo(Date fechaCreo) {
        this.fechaCreo = fechaCreo;
        return this;
    }

    public Junta usuarioModifico(Integer usuarioModifico) {
        this.usuarioModifico = usuarioModifico;
        return this;
    }

    public Junta fechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
        return this;
    }

    public Junta estado(byte estado) {
        this.estado = estado;
        return this;
    }

}
