package dto;

public class ProdutoDto {

	private int numeroIdentificador;
	private String nome;
	private String categoria;
	private Double preco;
	private int quantidadeEstoque;
	public ProdutoDto(String nome, String categoria, Double preco, int quantidadeEstoque) {
		super();
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public int getNumeroIdentificador() {
		return numeroIdentificador;
	}
	public void setNumeroIdentificador(int numeroIdentificador) {
		this.numeroIdentificador = numeroIdentificador;
	}
	@Override
	public String toString() {
		return "ProdutoDto [numeroIdentificador=" + numeroIdentificador + ", nome=" + nome + ", categoria=" + categoria
				+ ", preco=" + preco + ", quantidadeEstoque=" + quantidadeEstoque + "]";
	}
	
	
	
	
	
	
}
