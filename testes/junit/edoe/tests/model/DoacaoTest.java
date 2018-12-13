package junit.edoe.tests.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.lp2.edoe.model.Doacao;

class DoacaoTest {

	private Doacao doacao01;
	private Doacao doacao02;
	
	@BeforeEach
	void setUp() throws Exception {
		
		doacao01 = new Doacao("Mathias", "1234567890", "Caio", "0987654321","12/12/2012","Livro Java", 18);
		doacao02 = new Doacao("Caio", "1357924680", "Klaywert", "0864213579","13/12/2018","Xbox",5);
		
	}

	@Test
	@DisplayName("Testando se o construtor esta funcionando corretamente")
	void testConstrutor01() {
		
		assertEquals("1234567890", doacao01.getIdDoDoador());
		assertEquals("0987654321", doacao01.getIdDoReceptor());
		assertEquals("Livro Java", doacao01.getItem());
		assertEquals(18, doacao01.getQuantidade());
		assertEquals("12/12/2012", doacao01.getData());
		assertEquals("Mathias", doacao01.getNomeDoador());
		assertEquals("Caio", doacao01.getNomeReceptor());
		
	}
	
	@Test
	@DisplayName("Testando se o construtor esta funcionando corretamente com outra doacao")
	void testConstrutor02() {
		
		assertEquals("1357924680", doacao02.getIdDoDoador());
		assertEquals("0864213579", doacao02.getIdDoReceptor());
		assertEquals("Xbox", doacao02.getItem());
		assertEquals(5, doacao02.getQuantidade());
		assertEquals("13/12/2018", doacao02.getData());
		assertEquals("Caio", doacao02.getNomeDoador());
		assertEquals("Klaywert", doacao02.getNomeReceptor());
	}

	@Test
	@DisplayName("Testando metodo toString()")
	void testToString() {
		
		assertEquals("12/12/2012 - doador: Mathias/1234567890, item: Livro Java, quantidade: 18, receptor: Caio/0987654321", doacao01.toString());
		assertEquals("13/12/2018 - doador: Caio/1357924680, item: Xbox, quantidade: 5, receptor: Klaywert/0864213579", doacao02.toString());
		
	}
}
