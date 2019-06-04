package br.senac.dao;

import java.util.Date;

import br.senac.model.Usuario;

public class UsuarioDAO {

	public Usuario salvar(Usuario usuario) {
		usuario.setId(1);
		return usuario;
	}

	public Usuario getUser(String userName) {
		Usuario usuario = new Usuario(userName);
		usuario.setCodigoSeguranca(1);
		usuario.setNumeroCartao("654987");
		usuario.setSenha("123456");
		usuario.setDataValidade(new Date().toInstant().toString());
		return null;
	}

	
}
