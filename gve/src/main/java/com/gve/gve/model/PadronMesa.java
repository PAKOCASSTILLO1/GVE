package com.gve.gve.model;

import javax.persistence.*;

@Entity
@Table(name = "padron_mesa")
public class PadronMesa {

    @Id
    @Column(name = "cod_mesa_padron")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_mesa_padron;

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

    private byte estado =1 ;

    public PadronMesa modified(PadronMesa body, Padron padron, Mesa mesa) {
        this.mesa = body.getMesa();
        this.padron = body.getPadron();
        this.cod_mesa = mesa;
        this.cod_padron = padron;
        return this;
    }


    public PadronMesa() {
    }

    public PadronMesa(int cod_mesa_padron, int mesa, int padron, Mesa cod_mesa, Padron cod_padron, byte estado) {
        this.cod_mesa_padron = cod_mesa_padron;
        this.mesa = mesa;
        this.padron = padron;
        this.cod_mesa = cod_mesa;
        this.cod_padron = cod_padron;
        this.estado = estado;
    }

    public int getCod_mesa_padron() {
        return this.cod_mesa_padron;
    }

    public void setCod_mesa_padron(int cod_mesa_padron) {
        this.cod_mesa_padron = cod_mesa_padron;
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

    public byte getEstado() {
        return this.estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    public PadronMesa cod_mesa_padron(int cod_mesa_padron) {
        this.cod_mesa_padron = cod_mesa_padron;
        return this;
    }

    public PadronMesa mesa(int mesa) {
        this.mesa = mesa;
        return this;
    }

    public PadronMesa padron(int padron) {
        this.padron = padron;
        return this;
    }

    public PadronMesa cod_mesa(Mesa cod_mesa) {
        this.cod_mesa = cod_mesa;
        return this;
    }

    public PadronMesa cod_padron(Padron cod_padron) {
        this.cod_padron = cod_padron;
        return this;
    }

    public PadronMesa estado(byte estado) {
        this.estado = estado;
        return this;
    }

}
