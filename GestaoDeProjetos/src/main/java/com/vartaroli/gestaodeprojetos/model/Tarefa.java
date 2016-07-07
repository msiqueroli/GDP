package com.vartaroli.gestaodeprojetos.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Tarefa implements Serializable {

    private static final long serialVersionUID = 1L;

    int idTarefa;
    int idSprint;
    Time tempoTarefa;
    Date inicioTarefa;
    Date fimTarefa;
    int tipoTarefa;
    Double orcamentoTarefa;
    int complexidadeTarefa;
    int statusTarefa;
    int prioridadeTarefa;

    @Id
    @GeneratedValue
    @Column(name = "id_tarefa")
    public int getIdTarefa() {
        return idTarefa;
    }

    @Column(length = 1, name = "tarefa_tipo")
    public int getTipoTarefa() {
        return tipoTarefa;
    }

    @Column(name = "id_sprint")
    public int getIdSprint() {
        return idSprint;
    }

    @Column(name = "tempo_tarefa")
    public Time getTempoTarefa() {
        return tempoTarefa;
    }

    @Column(name = "inicio_tarefa")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getInicioTarefa() {
        return inicioTarefa;
    }

    @Column(name = "fim_tarefa")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getFimTarefa() {
        return fimTarefa;
    }

    @Column(name = "orcamento_tarefa")
    public Double getOrcamentoTarefa() {
        return orcamentoTarefa;
    }

    @Column(length = 1, name = "complexidade_tarefa")
    public int getComplexidadeTarefa() {
        return complexidadeTarefa;
    }

    @Column(length = 1, name = "status_tarefa")
    public int getStatusTarefa() {
        return statusTarefa;
    }

    @Column(length = 1, name = "prioridade_tarefa")
    public int getPrioridadeTarefa() {
        return prioridadeTarefa;
    }

    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }

    public void setIdSprint(int idSprint) {
        this.idSprint = idSprint;
    }

    public void setTempoTarefa(Time tempoTarefa) {
        this.tempoTarefa = tempoTarefa;
    }

    public void setInicioTarefa(Date inicioTarefa) {
        this.inicioTarefa = inicioTarefa;
    }

    public void setFimTarefa(Date fimTarefa) {
        this.fimTarefa = fimTarefa;
    }

    public void setOrcamentoTarefa(Double orcamentoTarefa) {
        this.orcamentoTarefa = orcamentoTarefa;
    }

    public void setComplexidadeTarefa(int complexidadeTarefa) {
        this.complexidadeTarefa = complexidadeTarefa;
    }

    public void setStatusTarefa(int statusTarefa) {
        this.statusTarefa = statusTarefa;
    }

    public void setPrioridadeTarefa(int prioridadeTarefa) {
        this.prioridadeTarefa = prioridadeTarefa;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setTipoTarefa(int tipoTarefa) {
        this.tipoTarefa = tipoTarefa;
    }
}
