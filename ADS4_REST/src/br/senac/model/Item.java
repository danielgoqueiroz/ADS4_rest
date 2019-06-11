package br.senac.model;

public class Item {
	private int id;
	private Double valor;
	private String detalhe;
	private String nome;
	public Item() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double descricao) {
		this.valor = descricao;
	}
	public String getDetalhe() {
		return detalhe;
	}
	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return this.getId() +" | "+this.getNome() + " | " + this.getValor();
	}
	
}
