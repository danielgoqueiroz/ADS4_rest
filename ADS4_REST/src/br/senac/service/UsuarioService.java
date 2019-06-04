package br.senac.service;

import java.util.Date;

import br.senac.dao.UsuarioDAO;
import br.senac.model.Usuario;

public class UsuarioService {

	UsuarioDAO dao = new UsuarioDAO();
	
	public Usuario getUser(String userName) {
		Usuario usuario = new Usuario(userName);
//		Usuario usuario = dao.getUsuario();
		usuario.setCodigoSeguranca(1);
		usuario.setNumeroCartao("654987");
		usuario.setSenha("123456");
		usuario.setDataValidade(new Date().toInstant().toString());
		return usuario;
	}

	public Usuario saveUser(Usuario usuario) {
		return dao.savar(usuario);
	}

}
