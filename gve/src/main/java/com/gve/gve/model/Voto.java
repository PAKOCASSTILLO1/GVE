package com.gve.gve.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Voto {

    @Id
    @Column(name = "cod_voto")
    private int cod_voto;

    private int tipoVotacion;
    private int mesa;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "cod_tipo_votacion", nullable = false, updatable = false)
    private TipoVotacion cod_tipo_votacion;

    private Date fecha;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "cod_mesa", nullable = false, updatable = false)
    private Mesa cod_mesa;

    private byte[] codigoQr;


    public Voto() {
    }

    public Voto(int cod_voto, int tipoVotacion, int mesa, TipoVotacion cod_tipo_votacion, Date fecha, Mesa cod_mesa, byte[] codigoQr) {
        this.cod_voto = cod_voto;
        this.tipoVotacion = tipoVotacion;
        this.mesa = mesa;
        this.cod_tipo_votacion = cod_tipo_votacion;
        this.fecha = fecha;
        this.cod_mesa = cod_mesa;
        this.codigoQr = codigoQr;
    }

    public int getCod_voto() {
        return this.cod_voto;
    }

    public void setCod_voto(int cod_voto) {
        this.cod_voto = cod_voto;
    }

    public int getTipoVotacion() {
        return this.tipoVotacion;
    }

    public void setTipoVotacion(int tipoVotacion) {
        this.tipoVotacion = tipoVotacion;
    }

    public int getMesa() {
        return this.mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public TipoVotacion getCod_tipo_votacion() {
        return this.cod_tipo_votacion;
    }

    public void setCod_tipo_votacion(TipoVotacion cod_tipo_votacion) {
        this.cod_tipo_votacion = cod_tipo_votacion;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Mesa getCod_mesa() {
        return this.cod_mesa;
    }

    public void setCod_mesa(Mesa cod_mesa) {
        this.cod_mesa = cod_mesa;
    }

    public byte[] getCodigoQr() {
        return this.codigoQr;
    }

    public void setCodigoQr(byte[] codigoQr) {
        this.codigoQr = codigoQr;
    }

    public Voto cod_voto(int cod_voto) {
        this.cod_voto = cod_voto;
        return this;
    }

    public Voto tipoVotacion(int tipoVotacion) {
        this.tipoVotacion = tipoVotacion;
        return this;
    }

    public Voto mesa(int mesa) {
        this.mesa = mesa;
        return this;
    }

    public Voto cod_tipo_votacion(TipoVotacion cod_tipo_votacion) {
        this.cod_tipo_votacion = cod_tipo_votacion;
        return this;
    }

    public Voto fecha(Date fecha) {
        this.fecha = fecha;
        return this;
    }

    public Voto cod_mesa(Mesa cod_mesa) {
        this.cod_mesa = cod_mesa;
        return this;
    }

    public Voto codigoQr(byte[] codigoQr) {
        this.codigoQr = codigoQr;
        return this;
    }

}
