package source;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CaixaEletronico {

	private HashMap<Integer, ContaCorrente> caixaEletronico;
	private static int id;
	
	public CaixaEletronico() {
		this.caixaEletronico = new HashMap<Integer, ContaCorrente>();
		CaixaEletronico.id = 0;
	}
	
	
	public void adicionaCliente(Cliente cliente, String senha) {
		if (senhaSegura(senha)) {
			CaixaEletronico.id++;
			ContaCorrente novaConta = new ContaCorrente(cliente.getNome(), cliente.getDinheiro(), senha, id);
			caixaEletronico.put(id, novaConta);
		} else
			throw new SenhaInseguraException();
		
	}

	public boolean existeCliente(int id) {
		return caixaEletronico.containsKey(id);
	}
	
	public ContaCorrente getConta(int id) {
		return caixaEletronico.get(id);
	}
	
	public boolean senhaSegura(String senha) {
		Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=]){8,}");
		System.out.println(senha);
		Matcher matcher = pattern.matcher(senha);
		if (matcher.find())
			return true;
		else
			return false;
	}


	public void deposito(Cliente cliente, int id, String senha, double valor) {
		if (caixaEletronico.containsKey(id) && valor > 0 && caixaEletronico.get(id).getSenha().equals(senha)) {
			ContaCorrente aux = caixaEletronico.get(id);
			ContaCorrente conta = new ContaCorrente(cliente.getNome(), aux.getSaldo()+valor, senha, id);
			caixaEletronico.put(id, conta);
		}
		else
			throw new DadosIncorretosException();
	}


	public void saque(Cliente cliente, int id2, String senha, double valorSaque) {
		if (caixaEletronico.containsKey(id2) && valorSaque > 0 && caixaEletronico.get(id2).getSenha().equals(senha)) {
			ContaCorrente aux = caixaEletronico.get(id2);
			if (aux.getSaldo() >= valorSaque) {
				ContaCorrente conta = new ContaCorrente(cliente.getNome(), aux.getSaldo()-valorSaque, senha, id2);
				caixaEletronico.put(id2, conta);
			} 
			else
				throw new SaldoInsuficienteException();
		}
		else
			throw new DadosIncorretosException();
	}


	public double consulta(Cliente cliente, int id3, String senha) {
		if (caixaEletronico.containsKey(id3) &&  caixaEletronico.get(id3).getSenha().equals(senha)) {
			return caixaEletronico.get(id3).getSaldo();
		}
		else
			throw new DadosIncorretosException();
	}
	
}
