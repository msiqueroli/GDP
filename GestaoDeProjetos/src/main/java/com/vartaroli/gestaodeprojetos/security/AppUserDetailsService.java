package com.vartaroli.gestaodeprojetos.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.vartaroli.gestaodeprojetos.model.Usuario;
import com.vartaroli.gestaodeprojetos.repository.Usuarios;
import com.vartaroli.gestaodeprojetos.util.CDIServiceLocator;

public class AppUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuarios usuarios = CDIServiceLocator.getBean(Usuarios.class);
		Usuario usuario = usuarios.porLogin(login);
		SystemUser user = null;

		if (usuario != null) {
			user = new SystemUser(usuario, getGrupos(usuario));
		}
		return user;
	}

	private Collection<? extends GrantedAuthority> getGrupos(Usuario usuario) {

		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		authorities.add(new SimpleGrantedAuthority("USUARIO"));
		authorities.add(new SimpleGrantedAuthority("GERENTE"));

		return authorities;
	}
}
