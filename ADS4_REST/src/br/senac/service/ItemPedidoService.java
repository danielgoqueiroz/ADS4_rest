package br.senac.service;

import ProdutoDAO.ItemPedidoDAO;
import br.senac.model.ItemPedido;

public class ItemPedidoService {

	ItemPedidoDAO dao = new ItemPedidoDAO();
	
	public ItemPedido getItemPedido(String id) {
		
		return dao.get(id);
	}

	public ItemPedido save(ItemPedido itemPedido) {
		
		return dao.save(itemPedido);
	}

	public boolean remove(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
