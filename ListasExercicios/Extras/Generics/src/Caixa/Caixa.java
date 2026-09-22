package Caixa;

public class Caixa<T>{

	private T elemento;
	
	
	public void guardar(T elemento) {
		this.elemento = elemento;
	}
	public T consultar() {
		return this.elemento;
	}
	
}
