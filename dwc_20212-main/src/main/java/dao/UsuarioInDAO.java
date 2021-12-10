package dao;

import java.sql.SQLException;
import java.util.List;

import model.Usuario;

public interface UsuarioInDAO {
	
	public boolean inserir(Usuario _user) throws SQLException;
	
	public List<Usuario> buscarTodos() throws SQLException;
	
	public Usuario buscar(String User, String Senha) throws SQLException;
	
	public boolean alterar(Usuario idUser) throws SQLException;
	
	public boolean deletar(String idUser) throws SQLException;

}
