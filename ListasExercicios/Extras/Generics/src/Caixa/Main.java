package Caixa;

public class Main {

	public static void main(String[] args) {
		
		Bola bola = new Bola("Roxa");
		Caixa<Bola> caixa = new Caixa<Bola>();
		
		caixa.guardar(bola);
		System.out.println(caixa.consultar());
		
	}
}
