package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import source.CaixaEletronico;
import source.Cliente;
import source.DadosIncorretosException;

public class SaqueStepsTest {
	Cliente cliente;
	CaixaEletronico caixa;
	String senha;
	double valorSaque;
	
	
	@Dado("^que um cliente quer fazer um saque$")
	public void que_um_cliente_quer_fazer_um_saque() {
		cliente = new Cliente("antonio", 500);
		caixa = new CaixaEletronico();
		senha = "abc1234$";
		caixa.adicionaCliente(cliente, senha);
		valorSaque = 100;
	}

	@Quando("^a senha e correta$")
	public void a_senha_e_correta() {
		boolean senhacorreta = true;
		int id = 1;
		try {
			caixa.saque(cliente, id, senha, valorSaque);
		} catch (DadosIncorretosException e) {
			senhacorreta = false;
		}
		assertTrue(senhacorreta);
	}

	@Entao("^seu saldo e decrescido$")
	public void seu_saldo_e_decrescido() {
		assertEquals(caixa.getConta(1).getSaldo(), 400, 0);
	}
	
}
