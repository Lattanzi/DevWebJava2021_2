package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDAO implements UsuarioInDAO {
	
	private Connection conexao;
	
	public UsuarioDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public boolean inserir(Usuario _user) throws SQLException{
		
		String SQL = "INSERT INTO webapp.usuario (username, password) "
				+ "VALUES (?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _user.getUsername());
		ps.setString(2, _user.getPassword());
		
		return ps.execute();
		
		
	}
	
	@Override
	public List<Usuario> buscarTodos() throws SQLException {

		List<Usuario> listaUser = new ArrayList<Usuario>();
		
		String SQL = "SELECT "
				+ "*"
				+ " FROM webapp.usuario";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			Usuario us = new Usuario();
			
			us = new Usuario();
			us.setUsername(rs.getString(1));
			us.setPassword(rs.getString(2));
		
			
			listaUser.add(us);
		}
		
		
		return listaUser;
	}
	
	@Override
	public Usuario buscar(String User, String Senha) throws SQLException {
		
		String SQL = "SELECT "
				+ "*"
				+ " FROM webapp.usuario WHERE username = AND password = " + User + Senha;
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		Usuario us = null;
		
		if(rs.next()) {
			
			us = new Usuario();
			us.setUsername(rs.getString(1));
			us.setPassword(rs.getString(2));
		}
		
		return us;
	}

	@Override
	public boolean alterar(Usuario idUser) throws SQLException {
		
		String SQL = "UPDATE webapp.usuario SET "
				+ "username = ? and password = ?"
				+ " WHERE username = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, idUser.getUsername());
		ps.setString(2, idUser.getPassword());
		
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
	public boolean deletar(String idUser) throws SQLException {
		
		String SQL = "DELETE FROM webapp.usuario WHERE username = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setString(1, idUser);
		
		if(ps.executeUpdate() == 1) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
		
	}
	
}
