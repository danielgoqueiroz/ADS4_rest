package br.senac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.senac.model.ItemPedido;
import br.senac.model.Usuario;

public class ItemPedidoDAO {

	Conn conn = new Conn();

	public ItemPedido get(String id) {
		return null;
	}

	public ItemPedido save(ItemPedido itemPedido) {
		return null;
	}

	public ItemPedido addItem(ItemPedido itemPedido) {
		
		String sql = "INSERT INTO ITEMPEDIDO (ITEMPQDIDOQTD, ITEMID) VALUES("+itemPedido.getQuantidade()+","+itemPedido.getId()+") RETURNING ITEMPEDIDOID column_with_default_value";
		
		try (Connection conn = new Conn().connect();
				Statement stmt  = conn.createStatement();
				ResultSet rs    = stmt.executeQuery(sql)) {
			itemPedido.setId(rs.getInt("ITEMPEDIDOID"));
			return itemPedido;
		} catch (SQLException e) {
			System.err.println("Erro ao salvar itemPedido: " + e);
		}
		return null;
	}


}
