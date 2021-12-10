package control;

import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;
import javax.faces.view.ViewScoped;

import dao.ClienteDAO;
import dao.FabricaConexao;
import model.Cliente;

@ManagedBean
@ViewScoped
public class ClienteBean {
	
	private List<Cliente> clientes;
	private ListDataModel<Cliente> listaJSF;
	private Cliente cliente;
	
	private String cpf;
	
	private String numeroped;

	
	public ClienteBean() {
		this.cliente = new Cliente();
	}
 
    @PostConstruct
    public void init() {
    	carregarDados();
    	
    }

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public ListDataModel<Cliente> getListaJSF() {
		return listaJSF;
	}

	public void setListaJSF(ListDataModel<Cliente> listaJSF) {
		this.listaJSF = listaJSF;
	}

	public Cliente getCliente() {
		return cliente;
	}
    
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void carregarDados() {
		try {
			
			ClienteDAO dao = new ClienteDAO(FabricaConexao.fazerConexao());
	        this.clientes = dao.buscarTodos();
			this.listaJSF = new ListDataModel<Cliente>(this.clientes);
			this.numeroped = GerarNumero();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}		
	}
	
	public void prepararCadastrar() {
		this.cliente = new Cliente();
	}
	
	public void Cadastrar() {
		try {
    		
    		ClienteDAO dao = new ClienteDAO(FabricaConexao.fazerConexao());
        	
    		dao.inserir(this.cliente);
    		
    		carregarDados();
    		
    		
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
	}
	
	public void prepararEditar() {
		this.cliente = listaJSF.getRowData();
	}
	
	public void Editar() {
		try {
			
			ClienteDAO dao = new ClienteDAO(FabricaConexao.fazerConexao());
			if(dao.alterar(this.cliente)) {
				carregarDados();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void prepararDeletar() {
		this.cliente = listaJSF.getRowData();
	}
	
	public void Deletar() {
		try {
    		
    		ClienteDAO dao = new ClienteDAO(FabricaConexao.fazerConexao());
        	
    		this.cpf = cliente.getCPF();
    		
    		if(dao.deletar(cpf)) {
    			carregarDados();
    		}
    		
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
	}
	
	
	
    public String GerarNumero() {
		Random random = new Random();
		int numero = random.nextInt(1000);
        //System.out.println("Número inteiro aleatório de 0 até 10: " + numero);
		
		setNumeroped(Integer.toString(numero));
		
		return numeroped;
		
	}
	
	public void NumeroGerado() {
		try {
    		GerarNumero();
    		
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
	}

	public String getNumeroped() {
		return numeroped;
	}

	public void setNumeroped(String numeroped) {
		this.numeroped = numeroped;
	}
	
}
