package com.vartaroli.gestaodeprojetos.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.vartaroli.gestaodeprojetos.util.FacesUtil;
import com.vartaroli.gestaodeprojetos.util.JsfUtil;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String email;
	
	public void preRender() {
		System.out.println("Entrou");
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		System.out.println(request.getParameter("invalid"));
		if("true".equals(request.getParameter("invalid"))){
			FacesUtil.addErrorMessage("Usuário ou senha inválido!");
			request.removeAttribute("invalid");
		}
	}
	
	public void login() throws ServletException, IOException{
		JsfUtil.forwardTo("/j_spring_security_check");		
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}
