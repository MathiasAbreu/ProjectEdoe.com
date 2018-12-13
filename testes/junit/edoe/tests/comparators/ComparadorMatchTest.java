package junit.edoe.tests.comparators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.lp2.edoe.comparators.ComparadorMatch;
import br.com.lp2.edoe.model.Item;
import br.com.lp2.edoe.model.Match;

class ComparadorMatchTest {

	private Match match01;
	private Match match02;
	private Match match03;
	
	private Comparator<Match> comparador;
	
	@BeforeEach
	void setUp() throws Exception {
		
		match01 = new Match(new Item("cadeira", "branca,baixa".split(","), "1234567890", 10), new Item("cadeira", "branca,baixa".split(","), "0987654321", 15));
		match02 = new Match(new Item("cadeira", "branca,baixa".split(","), "1234567890", 10), new Item("cadeira", "baixa,branca,acolchoada".split(","),"234567898765", 35));
		match03 = new Match(new Item("cadeira", "branca,baixa".split(","), "1234567890", 10), new Item("cadeira", "rosa,baixa".split(","), "3445754534", 20));
		
		comparador = new ComparadorMatch();
		
	}

	@Test
	@DisplayName("Testando comparador por match")
	void testComparador() {
		
		assertEquals(-1, comparador.compare(match01, match02));
		assertEquals(1, comparador.compare(match02, match03));
		assertEquals(1, comparador.compare(match03, match01));
		assertEquals(0, comparador.compare(match02, match02));
		assertEquals(1, comparador.compare(match02, match01));
	}

}
