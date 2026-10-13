package dto;

import java.sql.Connection;

public class Veiculo {

	private String placa;
	private String modelo;
	private Integer ano;
	private Integer quilometragem;
	public Veiculo(String placa, String modelo, Integer ano, Integer quilometragem) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
		this.quilometragem = quilometragem;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Integer getQuilometragem() {
		return quilometragem;
	}
	public void setQuilometragem(Integer quilometragem) {
		this.quilometragem = quilometragem;
	}
	@Override
	public String toString() {
		return "Veiculo [placa=" + placa + ", modelo=" + modelo + ", ano=" + ano + ", quilometragem=" + quilometragem
				+ "]";
	}

}
