package br.senac.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.senac.dao.Conn;
import br.senac.dao.ItemPedidoDAO;
import br.senac.dao.PedidoDAO;
import br.senac.model.ItemPedido;
import br.senac.model.Pedido;
import br.senac.model.Usuario;

public class PedidoService {

	PedidoDAO dao = new PedidoDAO();

	public Pedido getPedido(String id) {
		Pedido pedido = dao.get(id);
		return pedido;
	}

	public Pedido savePedio(Pedido pedido) {
		return dao.save(pedido);
	}

	public void cancelarPedido(int id) {
		Pedido pedido = dao.get(id + "");
		if (new Date().getTime() - pedido.getData().getTime() > 259200000) {
			throw new IllegalArgumentException("Não pode cancelar, tempo limite excedido.");
		} else {
			dao.cancel(id + "");
		}

	}

	public Pedido realizaPedido(List<ItemPedido> itemsPedidos) {
		Pedido pedido = new Pedido();
		pedido = dao.criaPedido(pedido);

		ItemPedidoService itemPedidoService = new ItemPedidoService();
		itemPedidoService.update(itemsPedidos, pedido);
		pedido.setItemsPedidos(itemPedidoService.getItensPedidosFromPedido(pedido));

		return pedido;
	}

	public List<Pedido> getAll(Usuario usuario) {
		String sql = "SELECT * FROM PEDIDOCOMPRA "
				+ "INNER JOIN ITEMPEDIDO ON PEDIDOCOMPRA.PEDIDOCOMPRAID = ITEMPEDIDO.PEDIDOCOMPRAID "
				+ "INNER JOIN USUARIO ON USUARIO.USERID = ITEMPEDIDO.USERID WHERE USUARIO.USERID = " + usuario.getId();
		List<Pedido> pedidos = new ArrayList<Pedido>();
		ItemService itemService = new ItemService();
		try (Connection conn = new Conn().connect();
				Statement stmt  = conn.createStatement();
				ResultSet rs    = stmt.executeQuery(sql)){
			while (rs.next()) {
				Pedido pedido = new Pedido();
				pedido.setId(rs.getInt("PEDIDOCOMPRAID"));
				System.out.println(rs.getDouble("PEDIDOCOMPRADATA"));
				//				pedido.setData(new Date(rs.getDouble("PEDIDOCOMPRADATA")));
				pedidos.add(pedido);
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return pedidos;

	}

}
