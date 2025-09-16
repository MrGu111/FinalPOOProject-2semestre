package mainProject;

import java.util.ArrayList;

public class Agricultor extends User{
	private ArrayList <ProduAgric> produtos;
	private String descrição;
	private ArrayList <Tecnica> tecnicasPublicadas;

	public Agricultor(String nome, String email, String dataNascimento, String descrição, String password,String localidade) {
		super(nome, email, dataNascimento, password,localidade,new ArrayList<>());
		produtos = new ArrayList <>();
		this.descrição = descrição;
		tecnicasPublicadas = new ArrayList <>();
	}
	
	public void addProduto(ProduAgric produto) {
		produtos.add(produto);
	}

	public ArrayList<ProduAgric> getProdutos() {
		return produtos;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	
	public void addTecnica(Tecnica tecnica) {
		tecnicasPublicadas.add(tecnica);
	}
	
	public ArrayList<Tecnica> getTecnicas(){
		return tecnicasPublicadas;
	}
	
}
