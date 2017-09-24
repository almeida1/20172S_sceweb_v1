import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;
import java.util.Collection;

public class UC01CadastrarEmpresa_v2 {
	private StringBuffer verificationErrors = new StringBuffer();
	private String cnpj;
	private String nomeDaEmpresa;
	private String nomeFantasia;
	private String endereco;
	private String telefone;
	private String responsavel;
	private String telefoneResponsavel;
	private String setor;
	private String email;
	private String resultadoEsperado;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	public UC01CadastrarEmpresa_v2(String n, String c, String f, String e, String t, String r, String tr, String s, String em, String re){
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
	        	{"Open Informatica Ltda","50658639000137","Open Informatica","Rua Aguia de Haia, 2432","121212","jose carlos","111221","contabilidade","jose@gmail.com","cadastro realizado com sucesso"},
	        	{"Nova Empresa Ltda","56241412000178","Nova Empresa","Rua Taquari, 2222","121212","maira silva","111221","faturamento","jose@gmail.com","cadastro realizado com sucesso"},
	        	{"Nova Empresa Ltda","","Nova Empresa","Rua Taquari, 2222","121212","maira silva","111221","faturamento","jose@gmail.com", "CNPJ inválido!"},
	        	
	        });
	    }
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
