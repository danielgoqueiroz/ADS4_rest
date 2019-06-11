package br.senac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.senac.model.Item;
import br.senac.model.ItemPedido;
import br.senac.model.Usuario;


public class ItemPedidoDAO {

	Conn conn = new Conn();

	

	public ItemPedido save(ItemPedido itemPedido) {
		return null;
	}

	public ItemPedido addItem(ItemPedido itemPedido) {
		
		String sql = "INSERT INTO ITEMPEDIDO (ITEMPQDIDOQTD, ITEMID) VALUES("+itemPedido.getQuantidade()+","+itemPedido.getItem().getId()+") ";
		Integer success = null;
		try (Connection conn = new Conn().connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			success = pstmt.executeUpdate();
			return itemPedido;
		} catch (SQLException e) {
			System.err.println("Erro ao salvar itemPedido: " + e);
		}
		return null;
	}


}
