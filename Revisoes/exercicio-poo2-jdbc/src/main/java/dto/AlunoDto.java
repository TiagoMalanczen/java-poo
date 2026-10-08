package dto;

import java.util.Date;

public class AlunoDto {

	private Integer registroAcademico;
	private String nome;
	private String sexo;
	private Date dataIngresso;
	private Integer periodo;
	private Double coeficiente;
	private CursoDto curso;
	public AlunoDto(Integer registroAcademico, String nome, String sexo, Date dataIngresso, Integer periodo,
			Double coeficiente, CursoDto curso) {
		super();
		this.registroAcademico = registroAcademico;
		this.nome = nome;
		this.sexo = sexo;
		this.dataIngresso = dataIngresso;
		this.periodo = periodo;
		this.coeficiente = coeficiente;
		this.curso = curso;
	}
	public Integer getRegistroAcademico() {
		return registroAcademico;
	}
	public void setRegistroAcademico(Integer registroAcademico) {
		this.registroAcademico = registroAcademico;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getDataIngresso() {
		return dataIngresso;
	}
	public void setDataIngresso(Date dataIngresso) {
		this.dataIngresso = dataIngresso;
	}
	public Integer getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}
	public Double getCoeficiente() {
		return coeficiente;
	}
	public void setCoeficiente(Double coeficiente) {
		this.coeficiente = coeficiente;
	}
	public CursoDto getCurso() {
		return curso;
	}
	public void setCurso(CursoDto curso) {
		this.curso = curso;
	}
	
	
	
	
}
