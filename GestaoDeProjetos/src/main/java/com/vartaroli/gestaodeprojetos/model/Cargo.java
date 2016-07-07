package com.vartaroli.gestaodeprojetos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int idCargo;
	String nomeCargo;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCargo;
		result = prime * result + ((nomeCargo == null) ? 0 : nomeCargo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargo other = (Cargo) obj;
		if (idCargo != other.idCargo)
			return false;
		if (nomeCargo == null) {
			if (other.nomeCargo != null)
				return false;
		} else if (!nomeCargo.equals(other.nomeCargo))
			return false;
		return true;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "id_cargo")
	public int getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}
	
	@Column(name="nome_cargo")
	public String getNomeCargo() {
		return nomeCargo;
	}
	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}	
}
