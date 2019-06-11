package br.senac.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
	
	private int id;
	private Date data;
	private Usuario usuario;
	List<Item> items = new ArrayList<Item>();
	
	public Pedido(Usuario usuario) {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void addItem(List<Item> items) {
		items.addAll(items);
	}
	
	
	
	
	
}
