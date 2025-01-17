package junit.edoe.tests.comparators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.lp2.edoe.comparators.ComparadorItemPorId;
import br.com.lp2.edoe.model.Item;

class ComparadorPorIdTest {

	private Item item01;
	private Item item02;
	
	private ComparadorItemPorId comparador;
	
	@BeforeEach
	void setUp() throws Exception {
		
		item01 = new Item("camisa","camisa,branca,pequena".split(","),"1",6);
		item02 = new Item("calca","calca,branca,tamanho p".split(","),"2",3);
		
		comparador = new ComparadorItemPorId();
	}

	@Test
	@DisplayName("Testando classe de comparacao por id")
	void testComparador() {
		
		assertEquals(-1,comparador.compare(item01, item02));
		assertEquals(1,comparador.compare(item02, item01));
		assertEquals(0,comparador.compare(item01, item01));
		
	}

}
