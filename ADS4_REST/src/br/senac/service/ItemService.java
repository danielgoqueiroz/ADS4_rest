package br.senac.service;

import java.util.List;

import br.senac.dao.ItemDAO;
import br.senac.model.Item;

public class ItemService {

	ItemDAO dao = new ItemDAO();
	
	public List<Item> getItems(String decricao) {
		return dao.getItems(decricao);
	}

	public Item save(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

}
