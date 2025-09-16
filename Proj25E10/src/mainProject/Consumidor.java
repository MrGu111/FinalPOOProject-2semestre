package mainProject;

import java.util.ArrayList;

public class Consumidor extends User {
	private String tipo;

	public Consumidor(String nome, String email, String dataNascimento,String password,
			String tipo,String localidade) {
		super(nome, email, dataNascimento,password,localidade,new ArrayList<>());
		this.tipo = tipo;

	}

	public String getTipo() {
		return tipo;
	}
	
	
}
