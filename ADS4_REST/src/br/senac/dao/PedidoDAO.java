package br.senac.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.senac.model.Item;
import br.senac.model.ItemPedido;
import br.senac.model.Pedido;
import br.senac.model.Usuario;

public class PedidoDAO {


	
	
	public Integer cancel(String id) {
		String sql = "UPDATE PEDIDOCOMPRA SET PEDIDOCOMPRASTATUS = 'CANCELED' WHERE PEDIDOCOMPRAID = "+id; 
		try (Connection conn = new Conn().connect();
				Statement stmt  = conn.createStatement()){
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return null;
	}


	public static Integer getIdFromLastPedido() {
		String sql = "SELECT * from PEDIDOCOMPRA order by PEDIDOCOMPRAID DESC limit 1"; 
		try (Connection conn = new Conn().connect();
				Statement stmt  = conn.createStatement();
				ResultSet rs    = stmt.executeQuery(sql)){
			while (rs.next()) {
				return rs.getInt("PEDIDOCOMPRAID");
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return null;
	}

	public Pedido save(Pedido pedido) {

		return pedido;
	}


	public Pedido realizaPedido(Pedido pedido) {
		String sql = "INSERT INTO PEDIDOCOMPRA DEFAULT VALUES;";
		try (Connection conn = new Conn().connect();
				Statement stmt  = conn.createStatement()) {
			stmt.execute(sql);
		} catch (SQLException e) {
			System.err.println("Erro ao salvar itemPedido: " + e);
		}
		
		
		return null;
	}


	public Pedido criaPedido(Pedido pedido) {
		String sql = "INSERT INTO PEDIDOCOMPRA (PEDIDOCOMPRADATA) VALUES ('"+ new Timestamp(new Date().getTime())+"')";
		try (Connection conn = new Conn().connect();
				Statement stmt  = conn.createStatement()) {
			stmt.execute(sql);
			pedido = this.get(getIdFromLastPedido() + "");
			return pedido;
		} catch (SQLException e) {
			System.err.println("Erro ao salvar itemPedido: " + e);
		}
		return null;
	}

	public Pedido get(String id) {
		String sql = "SELECT * FROM PEDIDOCOMPRA WHERE PEDIDOCOMPRAID = "+id;
		

		try (Connection conn = new Conn().connect();
				Statement stmt  = conn.createStatement();
				ResultSet rs    = stmt.executeQuery(sql)){
			while (rs.next()) {
				Pedido pedido= new Pedido();
				pedido.setId(rs.getInt("PEDIDOCOMPRAID"));
				String date = rs.getString("PEDIDOCOMPRADATA");
				Date data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(date);
				
				pedido.setData(data);
				return pedido;
			}
		} catch (SQLException | ParseException  e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return null;
	}
	
	public static void main (String[] args) {
		PedidoDAO dao = new PedidoDAO();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss");
		System.out.println(dao.get("22"));
	}

}
