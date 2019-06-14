package br.senac.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pedido {
	
	private int id;
	private Date data;
	private Usuario usuario;
	List<ItemPedido> itemsPedidos = new ArrayList<ItemPedido>();
	
	
	public Pedido() {
	}
	public Pedido(Usuario usuario) {
		this.usuario = usuario;
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
	public void addItemPedido(ItemPedido itemPedido) {
		itemsPedidos.add(itemPedido);
	}
	
	
	public List<ItemPedido> getItemsPedidos() {
		return itemsPedidos;
	}
	public void setItemsPedidos(List<ItemPedido> itemsPedidos) {
		this.itemsPedidos = itemsPedidos;
	}
	@Override
	public String toString() {
		return this.getId() + " | "+ this.getUsuario() + " | "+ this.getData();
	}
	
	
	
}
