package br.senac.model;

public class Erro {

	static public String SEM_PERMISSAO= "Sem permiss�o de acesso.";
	private String message;
	
	
	public Erro(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
