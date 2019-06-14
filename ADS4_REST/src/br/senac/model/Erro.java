package br.senac.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Erro {

	static public String SEM_PERMISSAO= "Sem permissão de acesso.";
	private String message;
	
	
	public Erro() {
	}

	public static String getSEM_PERMISSAO() {
		return SEM_PERMISSAO;
	}

	public static void setSEM_PERMISSAO(String sEM_PERMISSAO) {
		SEM_PERMISSAO = sEM_PERMISSAO;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Erro(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
