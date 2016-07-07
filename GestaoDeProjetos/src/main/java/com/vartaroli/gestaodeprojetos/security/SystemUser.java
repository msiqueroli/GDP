package com.vartaroli.gestaodeprojetos.security;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import com.vartaroli.gestaodeprojetos.model.Usuario;

public class SystemUser extends User {

	private static final long serialVersionUID = 1L;	
	private Usuario usuario;

	public SystemUser(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getEmailUsuario(), usuario.getSenhaUsuario(), authorities);
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}	
}
