package br.senac.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.senac.model.Item;

public class ItemDAO {


	public List<Item> getItems(String decricao) {
		String sql = "SELECT * FROM ITEM WHERE ITEMDESC LIKE '%"+ decricao +"%'"; //ordenar por mais vendidos
		List<Item> items = new ArrayList<Item>();

		try (Connection conn = new Conn().connect();
				Statement stmt  = conn.createStatement();
				ResultSet rs    = stmt.executeQuery(sql)){
			while (rs.next()) {
				Item item = new Item();
				item.setId(rs.getInt("ITEMID"));
				item.setValor(rs.getDouble("ITEMVALOR"));
				item.setDetalhe(rs.getString("ITEMDESC"));
				item.setNome(rs.getString("ITEMNOME"));
				items.add(item);
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return items;
	}
	
	public Item getItem(int id) {
		String sql = "SELECT * FROM ITEM WHERE ITEMID ="+id; 
		try (Connection conn = new Conn().connect();
				Statement stmt  = conn.createStatement();
				ResultSet rs    = stmt.executeQuery(sql)){
			while (rs.next()) {
				Item item = new Item();
				item.setId(rs.getInt("ITEMID"));
				item.setValor(rs.getDouble("ITEMVALOR"));
				item.setDetalhe(rs.getString("ITEMDESC"));
				item.setNome(rs.getString("ITEMNOME"));
				return item;
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return null;
	}



	public static void main(String[] args) {
		ItemDAO dao = new ItemDAO();
		System.out.println(dao.getItems("fone"));
	}


}




