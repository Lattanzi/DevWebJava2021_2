package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import model.Pedido;
import model.Produto;

public class ProdutoDAO implements ProdutoInDAO{
	
	private Connection conexao;
	
	public ProdutoDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public boolean inserir(Produto _produto) throws SQLException {
		
		String SQL = "INSERT INTO webapp.produto (idProduto, nomeProd, pedido_idPedido) "
				+ "VALUES (?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _produto.getIdProduto());
		ps.setString(2, _produto.getNomeProd());
		
		return ps.execute();

		
	}
	
	@Override
	public boolean deletar(int idProd) throws SQLException {
		
		String SQL = "DELETE FROM webapp.produto WHERE idProduto = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, idProd);
		
		if(ps.executeUpdate() == 1) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
		
	}
	
	@Override
	public boolean alterar(Produto _produto) throws SQLException {
		
		String SQL = "UPDATE webapp.produto SET "
				+ "nomeProd = ? "
				+ " WHERE idProduto = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _produto.getIdProduto());
		
		ps.setString(2, _produto.getNomeProd());
		
		if(ps.executeUpdate() == 1) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
		
	}
	
	@Override
	public Produto buscarPeloID(int idProd) throws SQLException {
		
		String SQL = "SELECT "
				+ "*"
				+ " FROM webapp.produto WHERE idProduto = " + idProd;
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		Produto prod = null;
		
		if(rs.next()) {
			
			prod = new Produto();
			prod.setIdProduto(rs.getInt(1));
			prod.setNomeProd(rs.getString(2));
		}
		
		return prod;
		
	}
	
	@Override
	public List<Produto> buscarTodos() throws SQLException {
		
		List<Produto> listaProdutos = new ArrayList<Produto>();
		
		String SQL = "SELECT "
				+ "*"
				+ " FROM webapp.produto";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			
			Produto prod = new Produto(id,nome);
			
			listaProdutos.add(prod);
		}
		
		
		return listaProdutos;
		
	}


}
