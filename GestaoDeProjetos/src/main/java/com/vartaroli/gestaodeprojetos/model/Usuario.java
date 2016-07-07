package com.vartaroli.gestaodeprojetos.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;    
    int idUsuario;
    String nomeUsuario;
    String emailUsuario;
    String tipoUsuario;
    String loginUsuario;
    String senhaUsuario;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        return true;
    }
    
    @Id
    @GeneratedValue
    @Column(name = "id_usuario")
    public int getIdUsuario() {
        return idUsuario;
    }
    
    @Column(length = 50, name = "nome_usuario")
    public String getNomeUsuario() {
        return nomeUsuario;
    }
    
    @Column(length = 50, name = "email_usuario")
    public String getEmailUsuario() {
        return emailUsuario;
    }

    @Column(length = 15, name = "tipo_usuario")
    public String getTipoUsuario() {
        return tipoUsuario;
    }
    
    @Column(length = 15, name = "login_usuario")
    public String getLoginUsuario() {
        return loginUsuario;
    }
    
    @Column(length = 15, name = "senha_usuario")
    public String getSenhaUsuario() {
        return senhaUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }    
    
}
