package com.gve.gve.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "voto_organizacion", schema = "GVE", catalog = "")
public class VotoOrganizacion {

    @Id
    @Column(name = "cod_voto_organizacion")
    private int cod_voto_organizacion;

    @ManyToOne
    @JoinColumn(name = "FK_COD_ORGANIZACION_POLITICA_VOTO_ORGANIZACION", nullable = false, updatable = false)
    private OrganizacionPolitica cod_organizacion_politica;

    @ManyToOne
    @JoinColumn(name = "FK_COD_VOTO_VOTO_ORGANIZACION", nullable = false, updatable = false)
    private Voto cod_voto;


    public VotoOrganizacion() {
    }

    public VotoOrganizacion(int cod_voto_organizacion, OrganizacionPolitica cod_organizacion_politica, Voto cod_voto) {
        this.cod_voto_organizacion = cod_voto_organizacion;
        this.cod_organizacion_politica = cod_organizacion_politica;
        this.cod_voto = cod_voto;
    }

    public int getCod_voto_organizacion() {
        return this.cod_voto_organizacion;
    }

    public void setCod_voto_organizacion(int cod_voto_organizacion) {
        this.cod_voto_organizacion = cod_voto_organizacion;
    }

    public OrganizacionPolitica getCod_organizacion_politica() {
        return this.cod_organizacion_politica;
    }

    public void setCod_organizacion_politica(OrganizacionPolitica cod_organizacion_politica) {
        this.cod_organizacion_politica = cod_organizacion_politica;
    }

    public Voto getCod_voto() {
        return this.cod_voto;
    }

    public void setCod_voto(Voto cod_voto) {
        this.cod_voto = cod_voto;
    }

    public VotoOrganizacion cod_voto_organizacion(int cod_voto_organizacion) {
        this.cod_voto_organizacion = cod_voto_organizacion;
        return this;
    }

    public VotoOrganizacion cod_organizacion_politica(OrganizacionPolitica cod_organizacion_politica) {
        this.cod_organizacion_politica = cod_organizacion_politica;
        return this;
    }

    public VotoOrganizacion cod_voto(Voto cod_voto) {
        this.cod_voto = cod_voto;
        return this;
    }

}
