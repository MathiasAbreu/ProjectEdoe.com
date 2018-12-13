package junit.edoe.tests.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.lp2.edoe.model.Item;

/**
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
class ItemTest {

	private Item item01;
	private Item item02;
	private Item item03;
	private Item item04;
	
	@BeforeEach
	void setUp() throws Exception {
		
		item01 = new Item("cobertor","cama box,grande".split(","),"1234567890",8);
		item02 = new Item("Casaco Branco","casaco de esquenta,pequeno".split(","),"0987654321",2);
		item03 = new Item("cobertor","cama box,grande".split(","),"1234567890",4);
		item04 = new Item("cobertor","cama box,grande,azul".split(","),"1234567890",3);
	}

	@Test
	@DisplayName("Testando construtor de itens")
	void testConstrutor01() {
		
		item01 = new Item("cobertor","cama box,grande".split(","),"1234567890",8);
		
		assertEquals("cobertor",item01.getDescritor());
		assertEquals("[cama box, grande]",Arrays.toString(item01.getTags()));
		assertEquals("1234567890",item01.getId());
		assertEquals(8,item01.getQuantidade());
		
	}
	
	@Test
	@DisplayName("Testando toString() de item")
	void testToString() {
		
		assertEquals("1234567890 - cobertor, tags: [cama box, grande], quantidade: 8",item01.toString());
		assertEquals("0987654321 - Casaco Branco, tags: [casaco de esquenta, pequeno], quantidade: 2",item02.toString());
	}

	@Test
	@DisplayName("Testando equals")
	void testEquals() {
		
		assertEquals(true,item01.equals(item03));
		assertEquals(false,item01.equals(item02));
		assertEquals(false,item03.equals(item04));
		
	}
	
	@Test
	@DisplayName("Testando se o hascode de item funciona")
	void testHascode() {
		
		item01.hashCode();
	}
}
