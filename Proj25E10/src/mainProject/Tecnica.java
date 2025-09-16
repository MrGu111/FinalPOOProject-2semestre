package mainProject;

public class Tecnica {
	private String titulo;
	private String descrição;
	private String autor;
	
	public Tecnica(String titulo, String descrição, String autor) {
		this.titulo = titulo;
		this.descrição = descrição;
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescrição() {
		return descrição;
	}

	public String getAutor() {
		return autor;
	}
	
}
