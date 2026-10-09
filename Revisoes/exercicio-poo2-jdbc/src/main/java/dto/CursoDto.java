package dto;

public class CursoDto {
	private Integer codigo;
	private String nome;
	private int periodo;
	private Integer duracao;
	
	public CursoDto( String nome, int periodo, Integer duracao) {
		super();
		this.nome = nome;
		this.periodo = periodo;
		this.duracao = duracao;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	public Integer getDuracao() {
		return duracao;
	}
	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}
	@Override
	public String toString() {
		return String.format(
			"--------------------------------------------------\n" +
			"  Código:   %d\n" +
			"  Nome:     %s\n" +
			"  Período:  %dº\n" +
			"  Duração:  %d anos\n" +
			"--------------------------------------------------",
			codigo,
			nome,
			periodo,
			duracao
		);
	}
}
