package com.vartaroli.gestaodeprojetos.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Projeto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    int idProjeto;
    String tituloProjeto;
    Double orcamentoProjeto;
    String requisitosProjeto;

    @Id
    @GeneratedValue
    @Column(name = "id_projeto")
    public int getIdProjeto() {
        return idProjeto;
    }

    @Column(length = 50 ,name = "titulo_projeto")
    public String getTituloProjeto() {
        return tituloProjeto;
    }

    @Column(name = "orcamento_projeto")
    public Double getOrcamentoProjeto() {
        return orcamentoProjeto;
    }

    @Column(name = "requisitos_projeto")
    public String getRequisitosProjeto() {
        return requisitosProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }

    public void setTituloProjeto(String tituloProjeto) {
        this.tituloProjeto = tituloProjeto;
    }

    public void setOrcamentoProjeto(Double orcamentoProjeto) {
        this.orcamentoProjeto = orcamentoProjeto;
    }

    public void setRequisitosProjeto(String requisitosProjeto) {
        this.requisitosProjeto = requisitosProjeto;
    }
    
}
