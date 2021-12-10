package control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;
import javax.faces.view.ViewScoped;

import dao.ProdutoDAO;
import dao.FabricaConexao;
import model.Produto;

@ManagedBean
@ViewScoped
public class ProdutoBean {
	
	private List<Produto> produtos;
	private ListDataModel<Produto> listaJSFprod;
	private Produto produto;
	
	private int prod;

	
	public ProdutoBean() {
		this.produto = new Produto();
	}
 
    @PostConstruct
    public void init() {
    	carregarDados();
    	
    }

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public ListDataModel<Produto> getListaJSFprod() {
		return listaJSFprod;
	}

	public void setListaJSFprod(ListDataModel<Produto> listaJSFprod) {
		this.listaJSFprod = listaJSFprod;
	}

	public Produto getProduto() {
		return produto;
	}
    
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public void carregarDados() {
		try {
			
			ProdutoDAO dao = new ProdutoDAO(FabricaConexao.fazerConexao());
			
	        this.produtos = dao.buscarTodos();
			this.listaJSFprod = new ListDataModel<Produto>(this.produtos);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}		
	}
	
	public void prepararCadastrar() {
		this.produto = new Produto();
	}
	
	public void Cadastrar() {
		try {
    		
			ProdutoDAO dao = new ProdutoDAO(FabricaConexao.fazerConexao());
        	
    		dao.inserir(this.produto);
    		
    		carregarDados();
    		
    		
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
	}
	
	public void prepararEditar() {
		this.produto = listaJSFprod.getRowData();
	}
	
	public void Editar() {
		try {
			
			ProdutoDAO dao = new ProdutoDAO(FabricaConexao.fazerConexao());
			if(dao.alterar(this.produto)) {
				carregarDados();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void prepararDeletar() {
		this.produto = listaJSFprod.getRowData();
	}
	
	public void Deletar() {
		try {
    		
    		ProdutoDAO dao = new ProdutoDAO(FabricaConexao.fazerConexao());
        	
    		this.prod = produto.getIdProduto();
    		
    		if(dao.deletar(prod)) {
    			carregarDados();
    		}
    		
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
	}
	
	
}
