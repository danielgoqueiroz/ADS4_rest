package br.senac.service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import br.senac.dao.ItemPedidoDAO;
import br.senac.model.ItemPedido;
import br.senac.model.Pedido;
import br.senac.model.Usuario;

public class ItemPedidoService {

	ItemPedidoDAO dao = new ItemPedidoDAO();
	
//	public ItemPedido getItemPedido(String id) {
//		return dao.get(id);
//	}

	public ItemPedido save(ItemPedido itemPedido) {
		return dao.save(itemPedido);
	}

	public boolean remove(String id) {
		return false;
	}

//	public Pedido addItem(ItemPedido itemPedido) {
//		Pedido pedido = new Pedido(itemPedido.getUsuario());
//		pedido.addItemPedido(dao.addItem(itemPedido));
//		return pedido;
//	}

	public List<ItemPedido> getItensPedido(Usuario usuario) {
		return dao.getItensPedidos(usuario);
	}

	public void update(List<ItemPedido> itemsPedidos, Pedido pedido) {
		itemsPedidos.forEach(i-> {
			dao.updatePedidoIDFromItemPedido(i, pedido.getId());
		});
		
	}

	public List<ItemPedido> getItensPedidosFromPedido(Pedido pedido) {
		return dao.getItensPedidos(pedido);
	}

//	public void verificaUsuario(Usuario usuario) throws IllegalAccessException, NoSuchAlgorithmException, IOException {
//		UsuarioService usuarioService = new UsuarioService();
//		usuarioService.login(usuario);
//		
//	}

}
