package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Assistente;

public class AssistenteDAO implements AssistenteInDAO {
	
	private Connection conexao;
	
	public AssistenteDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public boolean inserir(Assistente assist) throws SQLException {
		
		String SQL = "INSERT INTO webapp.assistente (idAssistente, Status) "
				+ "VALUES (?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, assist.getIdAssistente());
		ps.setInt(2, assist.getStatus());
		
		return ps.execute();

		
	}
	
	@Override
	public boolean deletar(int status) throws SQLException {
		
		String SQL = "DELETE FROM webapp.assistente WHERE idAssistente = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, status);
		
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
	public boolean alterar(Assistente assist) throws SQLException {
		
		String SQL = "UPDATE webapp.assistente SET "
				+ "Status = ? "
				+ " WHERE idAssistente = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, assist.getIdAssistente());
		ps.setInt(2, assist.getStatus());
		
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
	public Assistente buscarPeloID(int id) throws SQLException {
		
		String SQL = "SELECT "
				+ "*"
				+ " FROM webapp.assistente WHERE idAssistente = " + id;
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		Assistente as = null;
		
		if(rs.next()) {
			
			as = new Assistente(id, id);
			as.setIdAssistente(rs.getInt(1));
			as.setStatus(rs.getInt(2));
		}
		
		return as;
		
	}
	
	@Override
	public List<Assistente> buscarTodos() throws SQLException {
		
		List<Assistente> listaAssistente = new ArrayList<Assistente>();
		
		String SQL = "SELECT "
				+ "*"
				+ " FROM webapp.assistente";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			Assistente as = new Assistente();
			
			
			as.setIdAssistente(rs.getInt(1));
			as.setStatus(rs.getInt(2));
		
			
			listaAssistente.add(as);
		}
		
		
		return listaAssistente;
		
	}


}
