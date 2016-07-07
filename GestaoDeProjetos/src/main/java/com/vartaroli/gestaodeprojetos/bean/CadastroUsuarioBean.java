package com.vartaroli.gestaodeprojetos.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import com.vartaroli.gestaodeprojetos.model.Usuario;
import com.vartaroli.gestaodeprojetos.repository.Usuarios;
import com.vartaroli.gestaodeprojetos.util.FacesUtil;

@Named
@SessionScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String login;
	private String email;
	private String cargo;
	private String senha;
	private String senhaRepetida;
	
	private List<Usuario> usuarios;
	private List<String> cargos;

	public void salvar() {
		Usuario usuario = pegarUsuario();
		Usuario usuarioRepetido = Usuarios.buscarPorLogin(login);
		if (usuarioRepetido == null) {
			Usuarios.salvarUsuario(usuario);
			FacesUtil.addInfoMessage("Usuário cadastrado com sucesso.");
		} else {
			FacesUtil.addErrorMessage("Usuário já cadastrado no sistema.");
		}
	}

	private Usuario pegarUsuario() {
		Usuario novoUsuario = new Usuario();
		novoUsuario.setNomeUsuario(nome);
		novoUsuario.setLoginUsuario(login);
		novoUsuario.setEmailUsuario(email);
		novoUsuario.setTipoUsuario(cargo);
		novoUsuario.setSenhaUsuario(senha);
		return novoUsuario;
	}
	
	public void inicializar() {
		
		usuarios = Usuarios.pegarTodosUsuarios();
		cargos = new ArrayList<String>();
		cargos.add("Gerente");
		cargos.add("Desenvolvedor");
		cargos.add("Product Owner");
		limpar();
	}

	public List<String> getCargos() {
		return cargos;
	}

	public void limpar() {
		nome = "";
		login = "";
		email = "";
		cargo = "";
		senha = "";
		senhaRepetida = "";
	}
	
	public void onRowEdit(RowEditEvent event) {
		Usuarios.atualiarUsuario((Usuario) event.getObject());
		FacesUtil.addInfoMessage("Usuário editado com sucesso.");
    }
     
    public void onRowCancel(RowEditEvent event) {
        
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenhaRepetida() {
		return senhaRepetida;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setSenhaRepetida(String senhaRepetida) {
		this.senhaRepetida = senhaRepetida;
	}

	

}
