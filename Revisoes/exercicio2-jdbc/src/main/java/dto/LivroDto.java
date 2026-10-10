package dto;

public class LivroDto {

	private String titulo;
	private String autorPrincipal;
	private int anoPublicacao;
	private int numeroPaginas;
	public LivroDto(String titulo, String autorPrincipal, int anoPublicacao, int numeroPaginas) {
		super();
		this.titulo = titulo;
		this.autorPrincipal = autorPrincipal;
		this.anoPublicacao = anoPublicacao;
		this.numeroPaginas = numeroPaginas;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutorPrincipal() {
		return autorPrincipal;
	}
	public void setAutorPrincipal(String autorPrincipal) {
		this.autorPrincipal = autorPrincipal;
	}
	public int getAnoPublicacao() {
		return anoPublicacao;
	}
	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	public int getNumeroPaginas() {
		return numeroPaginas;
	}
	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	
	
}
