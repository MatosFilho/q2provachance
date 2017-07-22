package steps;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import static org.junit.Assert.*;
import source.CaixaEletronico;
import source.Cliente;
import source.DadosIncorretosException;

public class DepositoStepsTest {
	Cliente cliente;
	CaixaEletronico caixa;
	String senha;
	double valorDeposito;
	
	@Dado("^que um cliente quer fazer um deposito$")
	public void que_um_cliente_quer_fazer_um_deposito() {
		cliente = new Cliente("antonio", 500);
		caixa = new CaixaEletronico();
		senha = "abc1234$";
		caixa.adicionaCliente(cliente, senha);
		valorDeposito = 100;
	}

	@Quando("^a senha bate com o seu cadastro$")
	public void a_senha_bate_com_o_seu_cadastro() {
		boolean senhacorreta = true;
		int id = 1;
		try {
			caixa.deposito(cliente, id, senha, valorDeposito);
		} catch (DadosIncorretosException e) {
			senhacorreta = false;
		}
		assertTrue(senhacorreta);
	}

	@Entao("^seu saldo e atualizado$")
	public void seu_saldo_e_atualizado() {
	  assertEquals(caixa.getConta(1).getSaldo(), 600, 0);
	}
}
