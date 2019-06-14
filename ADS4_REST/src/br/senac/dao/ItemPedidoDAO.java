package br.senac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.senac.model.Item;
import br.senac.model.ItemPedido;
import br.senac.model.Usuario;
import br.senac.service.ItemService;

public class ItemPedidoDAO {

	Conn conn = new Conn();

	public int getLastId() {
		String sql = "SELECT ITEMPEDIDOID FROM ITEMPEDIDO ORDER BY ITEMPEDIDOID DESC LIMIT 1;";
		int id =-1;
		try (Connection conn = new Conn().connect();
				Statement stmt  = conn.createStatement();
				ResultSet rs    = stmt.executeQuery(sql)) {
			id = rs.getInt("ITEMPEDIDOID");
			return id;
		} catch (SQLException e) {
			System.err.println("Erro ao buscar id: " + e);
		}
		return id;
	}

	public ItemPedido get(ItemPedido itemPedido) {
		return null;
	}
	public ItemPedido save(ItemPedido itemPedido) {
		String sql = "INSERT INTO ITEMPEDIDO (ITEMPQDIDOQTD, ITEMID, USERID) VALUES("+itemPedido.getQuantidade()+","+itemPedido.getItem().getId()+", "+itemPedido.getUsuario().getId()+");";
		
		try (Connection conn = new Conn().connect();
				Statement stmt  = conn.createStatement()) {
			stmt.execute(sql);
			itemPedido.setId(getLastId());
			return itemPedido;
		} catch (SQLException e) {
			System.err.println("Erro ao salvar itemPedido: " + e);
		}
		return null;
	}

	public ItemPedido addItem(ItemPedido itemPedido) {
		
		String sql = "INSERT INTO ITEMPEDIDO (ITEMPQDIDOQTD, ITEMID) VALUES("+itemPedido.getQuantidade()+","+itemPedido.getItem().getId()+");";
		
		try (Connection conn = new Conn().connect();
				Statement stmt  = conn.createStatement()) {
			stmt.execute(sql);
			itemPedido.setId(getLastId());
			return itemPedido;
		} catch (SQLException e) {
			System.err.println("Erro ao salvar itemPedido: " + e);
		}
		return null;
	}
	
	

	public List<ItemPedido> getItensPedidos(Usuario usuario) {
		String sql = "SELECT * FROM ITEMPEDIDO WHERE USERID = "+usuario.getId();
		List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();
		ItemService itemService = new ItemService();
		try (Connection conn = new Conn().connect();
				Statement stmt  = conn.createStatement();
				ResultSet rs    = stmt.executeQuery(sql)){
			while (rs.next()) {
				ItemPedido itemPedido = new ItemPedido();
				itemPedido.setId(rs.getInt("ITEMPEDIDOID"));
				
				itemPedido.setItem(itemService.getItem(rs.getInt("ITEMID")));
				itemPedido.setQuantidade(Integer.getInteger(rs.getString("ITEMPQDIDOQTD")));
				itemPedido.setUsuario(null);
				itensPedido.add(itemPedido);
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return itensPedido;
	}
	
	public static void main(String[] args) {
		ItemPedidoDAO i = new ItemPedidoDAO();
		Usuario usuario = new Usuario();
		usuario.setId(1);
		System.out.println(i.getItensPedidos(usuario));
	}

}
