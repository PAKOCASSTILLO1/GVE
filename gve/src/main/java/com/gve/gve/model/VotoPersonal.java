package com.gve.gve.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "voto_personal")
public class VotoPersonal {

    @Id
    @Column(name = "cod_voto_persona")
    private int cod_voto_persona;

    private int voto;

    @Column(name = "cod_candidato")
    private int codCandidato;

    // FOREIGN KEY
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

    public VotoPersonal() {
    }

    public VotoPersonal(int cod_voto_persona, int voto, int codCandidato, Voto cod_voto, int usuarioCreo, int usuarioModifico, Date fechaCreo, Date fechaModifico) {
        this.cod_voto_persona = cod_voto_persona;
        this.voto = voto;
        this.codCandidato = codCandidato;
        this.cod_voto = cod_voto;
        this.usuarioCreo = usuarioCreo;
        this.usuarioModifico = usuarioModifico;
        this.fechaCreo = fechaCreo;
        this.fechaModifico = fechaModifico;
    }

    public int getCod_voto_persona() {
        return this.cod_voto_persona;
    }

    public void setCod_voto_persona(int cod_voto_persona) {
        this.cod_voto_persona = cod_voto_persona;
    }

    public int getVoto() {
        return this.voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public int getCodCandidato() {
        return this.codCandidato;
    }

    public void setCodCandidato(int codCandidato) {
        this.codCandidato = codCandidato;
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

    public VotoPersonal cod_voto_persona(int cod_voto_persona) {
        this.cod_voto_persona = cod_voto_persona;
        return this;
    }

    public VotoPersonal voto(int voto) {
        this.voto = voto;
        return this;
    }

    public VotoPersonal codCandidato(int codCandidato) {
        this.codCandidato = codCandidato;
        return this;
    }

    public VotoPersonal cod_voto(Voto cod_voto) {
        this.cod_voto = cod_voto;
        return this;
    }

    public VotoPersonal usuarioCreo(int usuarioCreo) {
        this.usuarioCreo = usuarioCreo;
        return this;
    }

    public VotoPersonal usuarioModifico(int usuarioModifico) {
        this.usuarioModifico = usuarioModifico;
        return this;
    }

    public VotoPersonal fechaCreo(Date fechaCreo) {
        this.fechaCreo = fechaCreo;
        return this;
    }

    public VotoPersonal fechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
        return this;
    }

}
