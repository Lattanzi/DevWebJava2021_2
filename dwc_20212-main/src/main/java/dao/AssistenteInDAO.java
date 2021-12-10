package dao;

import java.sql.SQLException;
import java.util.List;

import model.Assistente;

public interface AssistenteInDAO {
	
	public boolean inserir(Assistente assist) throws SQLException;
	
	public boolean deletar(int status) throws SQLException;
	
	public boolean alterar(Assistente assist) throws SQLException;
	
	public Assistente buscarPeloID(int id) throws SQLException;
	
	public List<Assistente> buscarTodos() throws SQLException;


}
