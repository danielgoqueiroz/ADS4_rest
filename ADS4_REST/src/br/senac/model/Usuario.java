package br.senac.model;

public class Usuario {
	private int id;
	private int codigoSeguranca;
	private String dataValidade;
	private String login;
	private String numeroCartao;
	private String senha;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String userName) {
		this.login = userName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCodigoSeguranca() {
		return codigoSeguranca;
	}
	public void setCodigoSeguranca(int codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}
	public String getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return this.getId() +" | " + this.getLogin() + " | " + this.getSenha() + " | " + this.getCodigoSeguranca() + " | " + this.getDataValidade() ;
	}
	
	
}
