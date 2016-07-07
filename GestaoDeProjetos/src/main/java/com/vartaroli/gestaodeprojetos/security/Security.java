package com.vartaroli.gestaodeprojetos.security;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.vartaroli.gestaodeprojetos.util.JsfUtil;

@Named
@RequestScoped
public class Security implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String getFullName()
	{
		String fullName = null;
		fullName = getUsuarioLogado().getUsuario().getNomeUsuario();
		return fullName;
	}
	
	public String getNomeUsuario() {
		String nome = null;

		SystemUser usuarioLogado = getUsuarioLogado();

		if (usuarioLogado != null) {
			nome = usuarioLogado.getUsuario().getNomeUsuario();
		}
		
		nome = getFirstName(nome);

		return nome;
	}
	
	public void logout() throws ServletException, IOException
	{
			
		JsfUtil.forwardTo("/j_spring_security_logout");	
		
	}
	
	private String getFirstName(String name)
	{
		String firstName = name;
		
		for(int i = 0; i < name.length();i++)
		{
			if(name.charAt(i) == ' ')
			{
				firstName = name.substring(0, i);
				return firstName;
			}
		}		
		
		return firstName;
	}

	private SystemUser getUsuarioLogado() {
		SystemUser usuario = null;

		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) FacesContext
				.getCurrentInstance().getExternalContext().getUserPrincipal();

		if (auth != null && auth.getPrincipal() != null) {
			usuario = (SystemUser) auth.getPrincipal();
		}

		return usuario;
	}
}
