package mainProject;

import java.time.LocalDate;
import java.util.ArrayList;

public class Compra {
	private double total;
	private LocalDate data;
	private ArrayList <DetalheCompra> produtos;
	private Consumidor consumidor;
	private Agricultor agricultor;
	
	public Compra(Consumidor consumidor, Agricultor agricultor,double total) {
		this.data = LocalDate.now();
		this.consumidor = consumidor;
		this.agricultor = agricultor;
		produtos = new ArrayList <>();
	}

	public LocalDate getData() {
		return data;
	}

	public ArrayList<DetalheCompra> getProdutos() {
		return produtos;
	}
	
	public void addProdutoCompra(DetalheCompra produto) {
		produtos.add(produto);
	}

	public Consumidor getConsumidor() {
		return consumidor;
	}

	public Agricultor getAgricultor() {
		return agricultor;
	}
	
	public Double getTotal(){
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
}
