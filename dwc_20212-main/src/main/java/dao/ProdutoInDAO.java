package dao;

import java.sql.SQLException;
import java.util.List;

import model.Produto;

public interface ProdutoInDAO {
	
	public boolean inserir(Produto _produto) throws SQLException;
	
	public boolean deletar(int idProd) throws SQLException;
	
	public boolean alterar(Produto _produto) throws SQLException;
	
	public Produto buscarPeloID(int idProd) throws SQLException;
	
	public List<Produto> buscarTodos() throws SQLException;

}
