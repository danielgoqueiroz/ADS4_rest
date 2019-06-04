package br.senac.service;

import java.util.Date;

import br.senac.dao.UsuarioDAO;
import br.senac.model.Usuario;

public class UsuarioService {

	UsuarioDAO dao = new UsuarioDAO();
	
	public Usuario getUser(String userName) {
		return dao.getUser(userName);
	}

	public Usuario saveUser(Usuario usuario) {
		return dao.salvar(usuario);
	}

}
