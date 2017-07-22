package steps;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import source.CaixaEletronico;
import source.Cliente;
import source.DadosIncorretosException;

import static org.junit.Assert.*;

public class ConsultaStepsTest {
	Cliente cliente;
	CaixaEletronico caixa;
	String senha;

@Dado("^um cliente com conta corrente$")
public void um_cliente_com_conta_corrente() {
	cliente = new Cliente("antonio", 500);
	caixa = new CaixaEletronico();
	senha = "abc1234$";
	caixa.adicionaCliente(cliente, senha);
}

@Quando("^ele quer verificar seu saldo com sua senha$")
public void ele_quer_verificar_seu_saldo_com_sua_senha() {
	boolean senhacorreta = true;
	int id = 1;
	try {
		caixa.consulta(cliente, id, senha);
	} catch (DadosIncorretosException e) {
		senhacorreta = false;
	}
	assertTrue(senhacorreta);
}

@Entao("^seu saldo é retornado$")
public void seu_saldo_é_retornado() {
	assertEquals (caixa.consulta(cliente, 1, senha), 500.0, 0);
}
	
}
