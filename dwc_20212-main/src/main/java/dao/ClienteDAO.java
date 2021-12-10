package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteDAO implements ClienteInDAO {
	
	private Connection conexao;

	public ClienteDAO(Connection _conexao) {
		this.conexao = _conexao;
	}

	@Override
	public boolean inserir(Cliente cliente) throws SQLException {

		String SQL = "INSERT INTO webapp.cliente (nomeCli, CPF, email, telefone, produto, assistente, pedido) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, cliente.getNomeCli());
		ps.setString(2, cliente.getCPF());
		ps.setString(3, cliente.getEmail());
		ps.setString(4, cliente.getTelefone());
		ps.setString(5, cliente.getProduto());
		ps.setString(6, cliente.getAssistente());
		ps.setString(7, cliente.getPedido());
		
		
		return ps.execute();
	}

	@Override
	public boolean deletar(String cpf) throws SQLException {

		String SQL = "DELETE FROM webapp.cliente WHERE CPF = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setString(1, cpf);
		
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
	public boolean alterar(Cliente cliente) throws SQLException {
		
		String SQL = "UPDATE webapp.cliente SET "
				+ "nomeCli = ?, email = ?, telefone = ?, produto = ?, assistente = ?, pedido = ?"
				+ " WHERE CPF = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, cliente.getNomeCli());
		ps.setString(2, cliente.getEmail());
		ps.setString(3, cliente.getTelefone());
		ps.setString(4, cliente.getProduto());
		ps.setString(5, cliente.getAssistente());
		ps.setString(6, cliente.getPedido());
		ps.setString(7, cliente.getCPF());
		
		
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
	public Cliente buscarPeloID(String cpf) throws SQLException {
		
		String SQL = "SELECT "
				+ "*"
				+ " FROM webapp.cliente WHERE CPF = " + cpf;
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		Cliente idC = null;
		
		if(rs.next()) {
			
			idC = new Cliente();
			idC.setNomeCli(rs.getString(1));
			idC.setCPF(rs.getString(2));
			idC.setEmail(rs.getString(3));
			idC.setTelefone(rs.getString(4));
			idC.setProduto(rs.getString(5));
			idC.setAssistente(rs.getString(6));
			idC.setPedido(rs.getString(7));
			
		}
		
		return idC;
	}

	@Override
	public List<Cliente> buscarTodos() throws SQLException {

		List<Cliente> listaCliente = new ArrayList<Cliente>();
		
		
		String SQL = "SELECT "
				+ "nomeCli, CPF, email, telefone, produto, assistente, pedido"
				+ " FROM webapp.cliente";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			String nome = rs.getString(1);
			String cpf = rs.getString(2);
			String email = rs.getString(3);
			String telefone = rs.getString(4);
			String produto = rs.getString(5);
			String assistente = rs.getString(6);
			String pedido = rs.getString(7);
			
			Cliente cli = new Cliente(cpf,nome,email,telefone,produto,assistente ,pedido);
			
			listaCliente.add(cli);
		}
		
		
		return listaCliente;
	}

	
	
}
