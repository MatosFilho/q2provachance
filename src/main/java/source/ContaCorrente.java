package source;

public class ContaCorrente {
	private String nome;
	private String senha;
	private double saldo;
	private int id;
	
	ContaCorrente(String nome, double dinheiro, String senha, int id) {
		this.nome = nome;
		this.saldo = dinheiro;
		this.senha = senha;
		this.id = id;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getSenha() {
		return senha;
	}

	public int getId() {
		return id;
	}
	
	
	
}
