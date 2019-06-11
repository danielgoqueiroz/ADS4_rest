package br.senac.model;

public class ItemPedido {

	private Item item;
	private int quantidade;
	
	public ItemPedido() {
		super();
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
}
