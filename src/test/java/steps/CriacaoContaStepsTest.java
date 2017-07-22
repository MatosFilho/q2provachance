package steps;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import static org.junit.Assert.*;
import source.CaixaEletronico;
import source.Cliente;

public class CriacaoContaStepsTest {
	Cliente cliente;
	CaixaEletronico caixa;
	String senha;
	
	@Dado("^que um cliente deseja uma conta corrente$")
	public void que_um_cliente_deseja_uma_conta_corrente() {
		cliente = new Cliente("carlos", 500);
	}

	@Quando("^ele solicita a criacao no caixa eletronico$")
	public void ele_solicita_a_criacao_no_caixa_eletronico() {
	    caixa = new CaixaEletronico();
	    senha = "abc123";
	    caixa.adicionaCliente(cliente, senha);
	}

	@Entao("^sua conta vai para o banco de dados$")
	public void sua_conta_vai_para_o_banco_de_dados() {
	 assertTrue(caixa.existeCliente(1));
	}

}
