package mainProject;

public class ProduAgric {
	private double preço;
	private int quantidade;
	private Agricultor agricultor;
	private Produto produto;
	
	public ProduAgric(double preço, int quantidade, Agricultor agricultor, Produto produto) {
		this.quantidade = quantidade;
		this.preço = preço;
		this.agricultor = agricultor;
		this.produto = produto;
	}

	public double getPreço() {
		return preço;
	}

	public void setPreço(double preço) {
		this.preço = preço;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Agricultor getAgricultor() {
		return agricultor;
	}

	public void setAgricultor(Agricultor agricultor) {
		this.agricultor = agricultor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	
}
