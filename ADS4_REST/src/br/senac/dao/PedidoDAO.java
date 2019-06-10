package br.senac.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.senac.model.Item;
import br.senac.model.Pedido;

public class PedidoDAO {

	
	public Pedido cancel(String id) {
		//dao -> se data de agora - data de pedido < 3 dias, cancelar pedido, se não informar que não pode
		
		return null;
	}

	
	public Pedido get(String id) {
		return null;
	}

	public Pedido save(Pedido pedido) {
		
		return pedido;
	}

}
