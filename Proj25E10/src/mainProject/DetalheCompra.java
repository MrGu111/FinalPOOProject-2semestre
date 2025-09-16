package mainProject;

public class DetalheCompra {
	private ProduAgric produto;
	private int quantidade;
	
	public DetalheCompra(ProduAgric produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}
	public ProduAgric getProduto() {
		return produto;
	}
	public void setProduto(ProduAgric produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
