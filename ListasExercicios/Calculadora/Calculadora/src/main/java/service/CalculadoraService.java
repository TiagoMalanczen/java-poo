package service;

public class CalculadoraService {

	private Double memoria;
	
	public Double soma(Double a, Double b) {
		return a+b;
	}
	public Double subtracao(Double a, Double b) {
		return a-b;
	}
	public Double multiplicacao(Double a, Double b) {
		return a*b;
	}
	public Double divisao(Double a, Double b) {
		if(b == 0) {
			return null;
		}
		return a/b;
	}
	
	public void armazenarValor(Double valor) {
		this.memoria = valor;
	}
	public Double chamarValor() {
		if(memoria == null) {
			return null;
		}
		return this.memoria;
	}
	public void limparMemoria() {
		this.memoria = null;
	}
}
