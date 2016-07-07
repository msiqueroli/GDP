package com.vartaroli.gestaodeprojetos.util;
import javax.persistence.Persistence;

import com.vartaroli.gestaodeprojetos.model.Usuario;
import com.vartaroli.gestaodeprojetos.repository.Usuarios;

public class CriaTabelas {
	public static void main(String[] args){
		Persistence.createEntityManagerFactory("GestaoDeProjetos");
		Usuario gerente = new Usuario();
		gerente.setLoginUsuario("gerente");
		gerente.setNomeUsuario("Gerente");
		gerente.setEmailUsuario("gerente@email.com");
		gerente.setTipoUsuario("Gerente");
		gerente.setSenhaUsuario("gerente");		
		Usuarios.salvarUsuario(gerente);
		
	}
}
