package br.senac.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pedido {
	
	private int id;
	private Date data;
	List<ItemPedido> itemsPedidos = new ArrayList<ItemPedido>();
	
	
	public Pedido() {
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
		return this.getId() + " | "+ this.getData();
	}
	
	
	
}
