package steps;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import static org.junit.Assert.*;
import source.CaixaEletronico;
import source.Cliente;
import source.SenhaInseguraException;

public class SenhaSeguraStepsTest {
	Cliente cliente;
	CaixaEletronico caixa;
	String senha;
	
	@Dado("^que um cliente vai criar uma conta$")
	public void que_um_cliente_vai_criar_uma_conta() {
		cliente = new Cliente("carlos", 500);
		caixa = new CaixaEletronico();
	}

	@Quando("^a senha e pequena$")
	public void a_senha_e_fraca() {
		senha = "123456";
	}

	@Entao("^a conta nao e criada$")
	public void a_conta_nao_e_criada() {
		boolean senhafraca = false;
		try {
			caixa.adicionaCliente(cliente, senha);
		} catch (SenhaInseguraException e) {
			senhafraca = true;
		}
		assertTrue(senhafraca);
	}
	
	@Quando("^a senha e grande mas fraca$")
	public void a_senha_e_grande_mas_fraca() {
	    senha = "123456789";
	}

	@Entao("^a criacao nao e concluida$")
	public void a_criacao_nao_e_concluida() {
		boolean senhafraca = false;
		try {
			caixa.adicionaCliente(cliente, senha);
		} catch (SenhaInseguraException e) {
			senhafraca = true;
		}
		assertTrue(senhafraca);
	}
	
	@Quando("^a senha e segura$")
	public void a_senha_e_segura() {
	  senha = "abc1234@";
	}

	@Entao("^a criacao e concluida$")
	public void a_criacao_e_concluida() {
		boolean senhafraca = false;
		try {
			caixa.adicionaCliente(cliente, senha);
		} catch (SenhaInseguraException e) {
			senhafraca = true;
		}
		assertFalse(senhafraca);
	}
	
}
