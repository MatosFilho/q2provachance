package source;

public class Cliente {

	private String nome;
	private double dinheiro;
	
	public Cliente(String string, double i) {
		this.nome = string;
		this.dinheiro = i;
	}

	public String getNome() {
		return nome;
	}

	public double getDinheiro() {
		return dinheiro;
	}

}
