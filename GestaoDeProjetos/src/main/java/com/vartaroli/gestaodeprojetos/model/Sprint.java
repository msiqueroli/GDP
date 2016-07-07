package com.vartaroli.gestaodeprojetos.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sprint implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    int sprintId;
    int projetoId;
    Date dataInicio;
    Date dataFim;
    int statusSprint;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
    @Id
    @GeneratedValue
    @Column(name = "sprint_id")
    public int getSprintId() {
        return sprintId;
    }

    @Column(name = "projeto_id")
    public int getProjetoId() {
        return projetoId;
    }

    @Column(name = "datainicio_sprint")
    public Date getDataInicio() {
        return dataInicio;
    }
    
    @Column(name = "datafim_sprint")
    public Date getDataFim() {
        return dataFim;
    }

    @Column(length = 1, name = "status_sprint")
    public int getStatusSprint() {
        return statusSprint;
    }
    
    public void setSprintId(int sprintId) {
        this.sprintId = sprintId;
    }

    public void setProjetoId(int projetoId) {
        this.projetoId = projetoId;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public void setStatusSprint(int statusSprint) {
        this.statusSprint = statusSprint;
    }
}
