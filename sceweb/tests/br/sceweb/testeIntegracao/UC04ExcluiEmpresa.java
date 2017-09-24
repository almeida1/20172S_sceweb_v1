package br.sceweb.testeIntegracao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.DAOFactory;
import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.IEmpresaDAO;
import br.sceweb.servico.ConfiguraDB;
import br.sceweb.servico.FabricaDeConexoes;

public class UC04ExcluiEmpresa {

	static IEmpresaDAO empresaDAO;
	static Empresa empresaRE;
	static ConfiguraDB configuraDB;
	static FabricaDeConexoes fabricaDeConexoes;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DAOFactory fabricaDAO = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		empresaDAO = fabricaDAO.getEmpresaDAO();
		empresaRE = new Empresa();
		empresaRE.setNomeDaEmpresa("Empresa JS");
		empresaRE.setCnpj("89424232000180");
		empresaRE.setNomeFantasia("Open Informatica");
		empresaRE.setEndereco("rua taquari");
		empresaRE.setTelefone("2222");
		empresaRE.setResponsavel("jose da silva");
		empresaRE.setTelefoneResponsavel("1212121212");
		empresaRE.setSetor("financeiro");
		empresaRE.setEmail("silva@gmail.com");
		empresaDAO.adiciona(empresaRE);
	}
	@AfterClass
	public static void tearDownAfter() throws Exception {
		//
	}
	//*******************************************************************
	//* testa a integracao entre a camada de acesso ao db e o componente
	//* mysql
	//*******************************************************************
		
	@Test
	public void CT01UC01FBConsulta_com_sucesso() {
		assertEquals(1, empresaDAO.exclui("89424232000180"));
	}

	

}
