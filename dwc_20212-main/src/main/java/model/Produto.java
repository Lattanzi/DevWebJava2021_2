package model;

import java.io.Serializable;

public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idProduto;
	private String nomeProd;
	
	
	public Produto() {
		super();
	}
	public Produto(int _idProduto, String _nomeProd) {
		super();
		this.idProduto = _idProduto;
		this.nomeProd = _nomeProd;

	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getNomeProd() {
		return nomeProd;
	}
	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}
	


}
