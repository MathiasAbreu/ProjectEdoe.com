package junit.edoe.tests.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.lp2.edoe.model.Item;
import br.com.lp2.edoe.model.Match;

class MatchTest {

	private Match match01;
	private Match match02;
	
	@BeforeEach
	void setUp() throws Exception {
		
		match01 = new Match(new Item("cadeira", "branca,baixa".split(","), "1234567890", 10), new Item("cadeira", "branca,baixa".split(","), "0987654321", 15));
		match02 = new Match(new Item("cadeira", "branca,baixa".split(","), "1234567890", 10), new Item("cadeira", "baixa,branca,acolchoada".split(","),"234567898765", 35));
		
	}

	@Test
	@DisplayName("Testando se o construtor esta funcionando corretamente")
	void testConstrutor01() {
		
		assertEquals("0987654321 - cadeira, tags: [branca, baixa], quantidade: 15", match01.getItem().toString());
		assertEquals("1234567890 - cadeira, tags: [branca, baixa], quantidade: 10", match01.getItemDeReferencia().toString());
		
		assertEquals(40, match01.getCoeficienteDeCombinacao());
		
	}

	@Test
	@DisplayName("Testando se o construtor esta funcionando corretamente")
	void testConstrutor02() {
		
		assertEquals("234567898765 - cadeira, tags: [baixa, branca, acolchoada], quantidade: 35", match02.getItem().toString());
		assertEquals("1234567890 - cadeira, tags: [branca, baixa], quantidade: 10", match02.getItemDeReferencia().toString());
		
		assertEquals(30, match02.getCoeficienteDeCombinacao());
		
	}
}
