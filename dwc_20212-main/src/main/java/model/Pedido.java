package model;

import java.io.Serializable;

public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idPedido;
	
	//private Assistente assistente;

	public Pedido() {
		
	}

	public Pedido(int _idPedido) {
		super();
		this.idPedido = _idPedido;
		//this.assistente = _assistente;
	}

	public int getIdPedido() {
		return idPedido;
	}


	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}


	/*public Assistente getAssistente() {
		return assistente;
	}


	public void setAssistente(Assistente assistente) {
		this.assistente = assistente;
	}*/


	
	
	
	

}
