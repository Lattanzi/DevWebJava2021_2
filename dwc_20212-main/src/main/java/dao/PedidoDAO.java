package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pedido;

public class PedidoDAO implements PedidoInDAO {
	
	private Connection conexao;
	
	public PedidoDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public boolean inserir(Pedido pedido) throws SQLException {

		String SQL = "INSERT INTO webapp.pedido (idPedido, Asssitente_idAsssitente) "
				+ "VALUES (?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, pedido.getIdPedido());
		
		return ps.execute();

	}

	@Override
	public Pedido buscarPeloID(int idPed) throws SQLException {
		
		String SQL = "SELECT "
				+ "*"
				+ " FROM webapp.pedido WHERE idPedido = " + idPed;
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		Pedido ped = null;
		
		if(rs.next()) {
			
			ped = new Pedido();
			ped.setIdPedido(rs.getInt(1));
		}
		
		return ped;
	}

	@Override
	public List<Pedido> buscarTodos() throws SQLException {

		List<Pedido> listaPedidos = new ArrayList<Pedido>();
		
		String SQL = "SELECT "
				+ "*"
				+ " FROM webapp.pedido";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			Pedido ped = new Pedido();
			
			ped = new Pedido();
			ped.setIdPedido(rs.getInt(1));
		
			
			listaPedidos.add(ped);
		}
		
		
		return listaPedidos;
	}

	@Override
	public boolean alterar(Pedido pedido) throws SQLException {
		
		String SQL = "UPDATE webapp.pedido SET "
				+ "idPedido = ? "
				+ " WHERE idPedido = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, pedido.getIdPedido());
		
		
		
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
	public boolean deletar(int idPed) throws SQLException {

		String SQL = "DELETE FROM webapp.pedido WHERE idPedido = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, idPed);
		
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
