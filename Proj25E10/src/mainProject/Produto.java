package mainProject;

import java.util.ArrayList;

public class Produto {
	private String nome;
	private ArrayList <ProduAgric> agricultores;
	
	public Produto(String nome) {
		this.nome = nome;
		agricultores = new ArrayList <>();
	}

	public String getNome() {
		return nome;
	}

	public ArrayList<ProduAgric> getAgricultores() {
		return agricultores;
	}
	
	public void addAgricultor(ProduAgric agricultor) {
		agricultores.add(agricultor);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
