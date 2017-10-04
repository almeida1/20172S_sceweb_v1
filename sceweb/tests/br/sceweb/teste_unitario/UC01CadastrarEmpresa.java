package br.sceweb.teste_unitario;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.MySQLEmpresaDAO;

import java.util.Collection;

@RunWith(Parameterized.class)
public class UC01CadastrarEmpresa {
	
	private String cnpj;
	private String nomeDaEmpresa;
	private String nomeFantasia;
	private String endereco;
	private String telefone;
	private String responsavel;
	private String telefoneResponsavel;
	private String setor;
	private String email;
	private int resultadoEsperado;
	private static Empresa empresa;
	private static MySQLEmpresaDAO empresaDAO;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresa = new Empresa();
		empresaDAO = new MySQLEmpresaDAO();
		
	}

	@AfterClass
	public static void tearDownAfter() throws Exception {
		empresaDAO.exclui("50658639000137");
		empresaDAO.exclui("56241412000178");
		empresaDAO.exclui("");
		
	}
	public UC01CadastrarEmpresa(String n, String c, String f, String e, String t, String r, String tr, String s, String em, int re){
		this.cnpj = c;
		this.nomeDaEmpresa = n;
		this.nomeFantasia = f;
		this.endereco = e;
		this.telefone = t;
		this.responsavel = r;
		this.telefoneResponsavel = tr;
		this.setor = s;
		this.email = em;
		this.resultadoEsperado = re;
	}
	  @Parameters
	    public static Collection data() {
	        return Arrays.asList(new Object[][] { 
	        	//CT01 - verifica o comportamento do sistema na inclusao com sucesso
	        	{"Open Informatica Ltda","50658639000137","Open Informatica","Rua Aguia de Haia, 2432","121212","jose carlos","111221","contabilidade","jose@gmail.com",1},
	        	//CT02 - verifica o comportamento do sistema na inclusao com sucesso
	        	{"Nova Empresa Ltda"    ,"56241412000178","Nova Empresa","Rua Taquari, 2222","121212","maira silva","111221","faturamento","jose@gmail.com",1},
	        	//CT03 - verifica o comportamento do sistema na inclusao de CNPJ já cadastrado
	        	{"Nova Empresa Ltda"    ,"56241412000178","Nova Empresa","Rua Taquari, 2222","121212","maira silva","111221","faturamento","jose@gmail.com",0},
	        	//CT04 - verifica o comportamento do sistema na inclusao de empresa cnpj branco
	        	{"Nova Empresa Ltda","","Nova Empresa","Rua Taquari, 2222","121212","maira silva","111221","faturamento","jose@gmail.com", 0},
	        	
	        });
	    }
	  
	
	@Test
	public void test() {
		System.out.println ("executando cnpj = " + cnpj);
		empresa.setNomeDaEmpresa(nomeDaEmpresa);
		empresa.setCnpj(cnpj);
		empresa.setNomeFantasia(nomeFantasia);
		empresa.setEndereco(endereco);
		empresa.setTelefone(telefone);
		empresa.setResponsavel(responsavel);
		empresa.setTelefoneResponsavel(telefoneResponsavel);
		empresa.setSetor(setor);
		empresa.setEmail(email);
		assertEquals(resultadoEsperado, empresaDAO.adiciona(empresa));
	}

}
