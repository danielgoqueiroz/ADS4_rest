package br.senac.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemPedido {

	
	private Integer id;
	public Usuario usuario;
	private Item item;
	private Integer quantidade;
	
	public ItemPedido() {
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return this.getId() + " | " + this.getQuantidade() + " | " +  this.getUsuario() + " | " + this.getItem();
	}
	
	
	
}
