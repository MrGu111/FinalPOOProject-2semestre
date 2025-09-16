package mainProject;

import java.util.ArrayList;

public class User {
	private String nome;
	private String email;
	private String dataNascimento;
	private String password;
	private String localidade;
	private ArrayList <Compra> historico;
	
	public User(String nome, String email, String dataNascimento, String password, String localidade,ArrayList <Compra> historico) {
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.password = password;
		this.localidade = localidade;
		this.historico = historico;
	}
	
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getPassword() {
		return password;
	}

	public String getLocalidade() {
		return localidade;
	}
	
	public void addCompra(Compra compra) {
		historico.add(compra);
	}
	
	public ArrayList<Compra> getHistorico() {
		return historico;
	}

	
}
