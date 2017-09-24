package br.sceweb.testeIntegracao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.DAOFactory;
import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.IEmpresaDAO;
import br.sceweb.servico.ConfiguraDB;
import br.sceweb.servico.FabricaDeConexoes;

public class UC01CadastrarEmpresa {
	static IEmpresaDAO empresaDAO;
	static Empresa empresa;
	static ConfiguraDB configuraDB;
	static FabricaDeConexoes fabricaDeConexoes;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		DAOFactory fabricaDAO = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		empresaDAO = fabricaDAO.getEmpresaDAO();
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("Empresa JS");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("Open Informatica");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
		empresa.setResponsavel("jose da silva");
		empresa.setTelefoneResponsavel("1212121212");
		empresa.setSetor("financeiro");
		empresa.setEmail("silva@gmail.com");
	}
	@After
	public void tearDownAfter() throws Exception {
		empresaDAO.exclui("89424232000180");
	}
	
    //*******************************************************************
	//* testa a integracao entre a camada de acesso ao db e o componente
	//* mysql
	//*******************************************************************
	
	@Test
	public void CT01UC01FBCadastra_com_sucesso() {
		assertEquals(1, empresaDAO.adiciona(empresa));
	}
	
	
}
