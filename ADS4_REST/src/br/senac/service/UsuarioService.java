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
	
	public Usuario getUser(String userName) {
		return dao.getByNickname(userName);
	}

	public Usuario login(Usuario usuario) throws IllegalAccessException, IOException, NoSuchAlgorithmException {
		Usuario usuarioLogado =  dao.logaUsuario(usuario);
		if (usuario == null) {
			throw new IllegalAccessException();
		}
		
//		File file = new File("D:\\Desenvimento\\javaWorkspaces\\default\\ADS4_rest\\ADS4_REST\\resource\\tmp\\cache.txt");
//		
//		String authRead = "";
//		String auth = usuario.getId() + usuario.getLogin() + usuario.getSenha();
//		MessageDigest digest = MessageDigest.getInstance("MD5");
//		String authMD5 = digest.digest(auth.getBytes()).toString();
//		
//		if (!file.exists()) {
//			file.getParentFile().mkdirs();
//			FileOutputStream out = new FileOutputStream(file);
//			Files.write(file.getAbsoluteFile().toPath(),digest.digest());
//		} 
//		
//		System.out.println("Lendo arquivo");
//		Files.lines(file.toPath(), Charset.defaultCharset()).forEach(line-> {
//			System.out.println(line);
//			authRead.concat(line);
//		});
//		System.out.println("AuthRead: " + authRead + " | " + authMD5  );
		
		return usuarioLogado;
		
	}

	public Usuario updateUser(Usuario usuario) {
		return dao.update(usuario);
	}

	public static Usuario verificaUsuario(Usuario usuario) throws IllegalAccessException, NoSuchAlgorithmException, IOException {
		UsuarioService usuarioService = new UsuarioService();
		return usuarioService.login(usuario);
		
	}

}
