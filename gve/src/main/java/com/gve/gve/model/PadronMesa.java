package com.gve.gve.model;

import javax.persistence.*;

@Entity
@Table(name = "padron_mesa")
public class PadronMesa {

    @Id
    @Column(name = "cod_mesa_padron")
    private int cod_mesa_padron;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "FK_COD_MESA_PM", nullable = false, updatable = false)
    private Mesa cod_mesa;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "FK_COD_PADRON_PM", nullable = false, updatable = false)
    private Padron cod_padron;

    private byte estado;

    public PadronMesa() {
    }

    public PadronMesa(int cod_mesa_padron, Mesa cod_mesa, Padron cod_padron, byte estado) {
        this.cod_mesa_padron = cod_mesa_padron;
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
