package junit.edoe.tests.comparators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.lp2.edoe.comparators.ComparadorDoacao;
import br.com.lp2.edoe.model.Doacao;


class ComparadorDoacaoTest {

	private Doacao doacao01;
	private Doacao doacao02;
	
	private Comparator<Doacao> comparador;
	
	@BeforeEach
	void setUp() throws Exception {

		doacao01 = new Doacao("Mathias", "1234567890", "Caio", "0987654321","12/12/2012","Livro Java", 18);
		doacao02 = new Doacao("Caio", "1357924680", "Klaywert", "0864213579","13/12/2018","Xbox",5);
		
		comparador = new ComparadorDoacao();
	}
	
	@Test
	@DisplayName("Testando classe de comparacao de doacao")
	void testComparador() {
		
		assertEquals(-6,comparador.compare(doacao01, doacao02));
		assertEquals(6,comparador.compare(doacao02, doacao01));
		assertEquals(0,comparador.compare(doacao02, doacao02));
		
	}

}
