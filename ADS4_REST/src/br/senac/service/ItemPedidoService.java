package br.senac.service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import br.senac.dao.ItemPedidoDAO;
import br.senac.model.ItemPedido;
import br.senac.model.Usuario;

public class ItemPedidoService {

	ItemPedidoDAO dao = new ItemPedidoDAO();
	
	public ItemPedido getItemPedido(String id) {
		return dao.get(id);
	}

	public ItemPedido save(ItemPedido itemPedido) {
		return dao.save(itemPedido);
	}

	public boolean remove(String id) {
		return false;
	}

	public Usuario addItem(Usuario usuario, ItemPedido itemPedido) {
		dao.addItem(usuario, itemPedido);
		return null;
	}

	public void verificaUsuario(Usuario usuario) throws IllegalAccessException, NoSuchAlgorithmException, IOException {
		UsuarioService usuarioService = new UsuarioService();
		usuarioService.login(usuario);
		
	}

}
