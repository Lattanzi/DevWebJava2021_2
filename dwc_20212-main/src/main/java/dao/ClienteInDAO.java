package dao;

import java.sql.SQLException;
import java.util.List;

import model.Cliente;

public interface ClienteInDAO {

	public boolean inserir(Cliente cliente) throws SQLException;
		
	public boolean deletar(String cpf) throws SQLException;
		
	public boolean alterar(Cliente cliente) throws SQLException;
		
	public Cliente buscarPeloID(String cpf) throws SQLException;
		
	public List<Cliente> buscarTodos() throws SQLException;
		
}


