package br.senac.service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import br.senac.dao.ItemDAO;
import br.senac.dao.ItemPedidoDAO;
import br.senac.model.Item;
import br.senac.model.ItemPedido;
import br.senac.model.Pedido;
import br.senac.model.Usuario;

public class ItemPedidoService {

	ItemPedidoDAO dao = new ItemPedidoDAO();
	ItemDAO itemDAO = new ItemDAO();
	
	public ItemPedido getItemPedido(Integer id) {
//		dao.get(id)
		return null;
	}

	public ItemPedido save(ItemPedido itemPedido) {
		return dao.save(itemPedido);
	}

	public boolean remove(String id) {
		return false;
	}

	public ItemPedido addItem(ItemPedido itemPedido) {
		return dao.addItem(itemPedido);
	}

	public void verificaUsuario(Usuario usuario) throws IllegalAccessException, NoSuchAlgorithmException, IOException {
		UsuarioService usuarioService = new UsuarioService();
		usuarioService.login(usuario);
		
	}

}
