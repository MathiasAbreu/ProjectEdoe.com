package junit.edoe.tests.comparators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.lp2.edoe.comparators.ComparadorItemPorDescricao;
import br.com.lp2.edoe.model.Item;

class ComparadorPorDescricaoTest {

	private Item item01;
	private Item item02;
	
	private Comparator<Item> comparador; 
	
	@BeforeEach
	void setUp() throws Exception {
		
		item01 = new Item("camisa","camisa,branca,pequena".split(","),"1",6);
		item02 = new Item("calca","calca,branca,tamanho p".split(","),"2",3);
		
		comparador = new ComparadorItemPorDescricao();
	}

	@Test
	@DisplayName("Testando classe de comparacao por id")
	void testComparador() {
		
		assertEquals(1,comparador.compare(item01, item02));
		assertEquals(-1,comparador.compare(item02, item01));
		assertEquals(0,comparador.compare(item01, item01));
		
	}

}
