package model;

import java.io.Serializable;

public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String CPF;
	private String nomeCli;
	private String email;
	private String telefone;
	private String produto;
	private String assistente;
	private String pedido;
	
	//private Produto produto;
	
	//private Pedido pedido;
	
	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

	public String getAssistente() {
		return assistente;
	}

	public void setAssistente(String assistente) {
		this.assistente = assistente;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Cliente() {
		
	}

	public Cliente(String cpf, String nomeCli, String email, String telefone, String produto, String assistente , String pedido) {
		super();
		this.CPF = cpf;
		this.nomeCli = nomeCli;
		this.email = email;
		this.telefone = telefone;
		this.produto = produto;
		this.assistente = assistente;
		this.pedido = pedido;
	}

	public String getNomeCli() {
		return nomeCli;
	}


	public void setNomeCli(String nomeCli) {
		this.nomeCli = nomeCli;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cpf) {
		CPF = cpf;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CPF == null) ? 0 : CPF.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (CPF == null) {
			if (other.CPF != null)
				return false;
		} else if (!CPF.equals(other.CPF))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [CPF=" + CPF + ", nomeCli=" + nomeCli + ", email=" + email + ", telefone=" + telefone
				+ ", produto=" + produto + ", assistente=" + assistente + ", pedido=" + pedido + "]";
	}
		
}
