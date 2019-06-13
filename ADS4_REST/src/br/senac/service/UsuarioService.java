package br.senac.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.apache.commons.lang3.CharSetUtils;

import br.senac.dao.UsuarioDAO;
import br.senac.model.Usuario;

public class UsuarioService {
	
	UsuarioDAO dao = new UsuarioDAO();
	
	public Usuario getUser(String key) {
		return dao.validateUser(key);
	}

	public Usuario updateUser(Usuario usuario) {
		return dao.update(usuario);
	}

//	public static Usuario verificaUsuario(Usuario usuario) throws IllegalAccessException, NoSuchAlgorithmException, IOException {
//		UsuarioService usuarioService = new UsuarioService();
//		return usuarioService.login(usuario);
//		
//	}

}
