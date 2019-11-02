package com.gve.gve.model;

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

    public VotoPersonal() {
    }

    public VotoPersonal(int cod_voto_persona, int voto, int codCandidato, Voto cod_voto) {
        this.cod_voto_persona = cod_voto_persona;
        this.voto = voto;
        this.codCandidato = codCandidato;
        this.cod_voto = cod_voto;
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

}
