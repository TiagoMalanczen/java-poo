package dto;

public class FuncionarioDto {

	private String nome;
	private String cargo;
	private Double salario;
	private String cpf;
	public FuncionarioDto(String nome, String cargo, Double salario, String cpf) {
		super();
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	@Override
	public String toString() {
		return "FuncionarioDto [nome=" + nome + ", cargo=" + cargo + ", salario=" + salario + ", cpf=" + cpf + "]";
	}
}
