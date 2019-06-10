package br.senac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import br.senac.model.Usuario;

public class UsuarioDAO {

	public Usuario save(Usuario usuario){
		System.out.println("Salvando usuário "+usuario+ " no repositório local.");

		String sql = "INSERT INTO USER (USERLOGIN, USERDATA, USERCARTAO, USERCODSEGU, USERSENHA) VALUES(?,?,?,?,?)";
		int success = -1;
		try (Connection conn = new Conn().connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, usuario.getLogin());
			pstmt.setString(2, usuario.getDataValidade());
			pstmt.setString(3, usuario.getNumeroCartao());
			pstmt.setInt(4, usuario.getCodigoSeguranca());
			pstmt.setString(5, usuario.getSenha());

			success = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Erro ao salvar usuário: " + e);
		}
		System.out.println("Usuário " +usuario.getLogin()+" salvo.");
		return getByNickname(usuario.getLogin());
	}
	
	public Usuario update(Usuario usuario){

		String sql = "UPDATE USER SET USERLOGIN = "
				+ ",USERDATA = " + usuario.getDataValidade()
				+ ",USERCARTAO = " + usuario.getNumeroCartao()
				+ ",USERCODSEGU = " + usuario.getCodigoSeguranca()
				+ ",USERSENHA = " + usuario.getSenha() + ";";
		
		int success = -1;
		try (Connection conn = new Conn().connect();
				Statement stmt  = conn.createStatement();
				ResultSet rs    = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Usuario userUp = new Usuario();
				userUp= new Usuario(rs.getString("USERLOGIN"));
				userUp.setId(rs.getInt("USERID"));
				userUp.setCodigoSeguranca(rs.getInt("USERCODSEGU"));
				userUp.setDataValidade(rs.getString("USERDATA"));
				userUp.setNumeroCartao(rs.getString("USERCARTAO"));
				userUp.setSenha(rs.getString("USERSENHA"));
				return userUp;
				}
		} catch (SQLException e) {
			System.err.println("Erro ao salvar usuário: " + e);
		}
		System.out.println("Usuário " +usuario.getLogin()+" salvo.");
		return getByNickname(usuario.getLogin());
	}

	public Usuario getByNickname(String nickname){

		String sql = "SELECT * FROM USUARIO WHERE USERLOGIN = '"+nickname+"'";
		Usuario user= null;

		try (Connection conn = new Conn().connect();
				Statement stmt  = conn.createStatement();
				ResultSet rs    = stmt.executeQuery(sql)){
			while (rs.next()) {
				user= new Usuario(rs.getString("USERLOGIN"));
				user.setId(rs.getInt("USERID"));
				user.setCodigoSeguranca(rs.getInt("USERCODSEGU"));
				user.setDataValidade(rs.getString("USERDATA"));
				user.setNumeroCartao(rs.getString("USERCARTAO"));
				user.setSenha(rs.getString("USERSENHA"));
				System.out.println("Usuário carregado do repositório local.");
				return user;
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return user;

	}

	public Usuario logaUsuario(Usuario usuario) {
		String sql = "SELECT * FROM USUARIO WHERE USERLOGIN = '"+usuario.getLogin()+"' AND SENHA ='" + usuario.getSenha() + "'";
		Usuario user= null;

		try (Connection conn = new Conn().connect();
				Statement stmt  = conn.createStatement();
				ResultSet rs    = stmt.executeQuery(sql)){
			while (rs.next()) {
				user= new Usuario(rs.getString("USERLOGIN"));
				user.setId(rs.getInt("USERID"));
				user.setCodigoSeguranca(rs.getInt("USERCODSEGU"));
				user.setDataValidade(rs.getString("USERDATA"));
				user.setNumeroCartao(rs.getString("USERCARTAO"));
				user.setSenha(rs.getString("USERSENHA"));
				System.out.println("Usuário carregado do repositório local.");
				return user;
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return user;

		
	}

	
}
