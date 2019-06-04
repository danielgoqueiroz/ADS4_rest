package br.senac.service;

import br.senac.dao.PedidoDAO;
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

}
