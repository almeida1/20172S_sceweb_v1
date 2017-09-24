/**
 * 
 */
package br.sceweb.testeIntegracao;

import static org.junit.Assert.*;

import org.junit.Test;

import br.sceweb.controle.WebsiteTitle;

/**
 * @author sam
 *
 */
public class TestWebsiteTitle {

	/**
	 * Test method for {@link br.sceweb.controle.WebsiteTitle#getTitle()}.
	 */
	@Test
	public void testGetTitle() {
		assertEquals("Sistema de Controle de Estagio", new WebsiteTitle().getTitle());
	}

	
	/**
	 * Test method for {@link br.sceweb.controle.WebsiteTitle#setTitle(java.lang.String)}.
	 */
	@Test
	public void testSetTitle() {
		String newTitle = "This is not Lauren's Lovely Landscapes";
		WebsiteTitle title = new WebsiteTitle();
		title.setTitle(newTitle);
		assertEquals(newTitle, title.getTitle());
		
		
		
	}

}
