package com.vartaroli.gestaodeprojetos.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import com.vartaroli.gestaodeprojetos.model.Usuario;
import com.vartaroli.gestaodeprojetos.util.JpaUtil;

public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager Manager = JpaUtil.getEntityManager();

	public Usuario porId(Long id) {
		return this.Manager.find(Usuario.class, id);
	}

	public Usuario porLogin(String login) {
		Usuario usuario = null;

		try {
			usuario = (Usuario) this.Manager.createQuery("from Usuario where login_usuario = :login", Usuario.class)
					.setParameter("login", login).getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		}

		return usuario;
	}
	
	public static Usuario buscarPorLogin	(String login) {
		Usuario usuario = null;

		try {
			usuario = (Usuario) JpaUtil.getEntityManager().createQuery("from Usuario where login_usuario = :login", Usuario.class)
					.setParameter("login", login).getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		}
			
		return usuario;
	}
	
	public static void salvarUsuario(Usuario usuario)
	{
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		manager.persist(usuario);
		
		tx.commit();
		manager.close();
	}
	
	public static void atualiarUsuario(Usuario usuario)
	{
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
			
		manager.merge(usuario);
		
		tx.commit();
		manager.close();
	}
	
	public static List<Usuario> pegarTodosUsuarios()
	{
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = (List<Usuario>) JpaUtil.getEntityManager().createQuery("from Usuario").getResultList();
		return usuarios;
	}
}
