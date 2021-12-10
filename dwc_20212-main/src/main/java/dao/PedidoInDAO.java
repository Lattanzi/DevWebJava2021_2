package dao;

import java.sql.SQLException;
import java.util.List;

import model.Pedido;

public interface PedidoInDAO {
	
	public boolean inserir(Pedido pedido) throws SQLException;
	
	public boolean deletar(int idPed) throws SQLException;
	
	public boolean alterar(Pedido pedido) throws SQLException;
	
	public Pedido buscarPeloID(int idPed) throws SQLException;
	
	public List<Pedido> buscarTodos() throws SQLException;

}
