package junit.edoe.tests.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.lp2.edoe.exceptions.InvalidArgumentException;

class InvalidArgumentExceptionTest {

	@Test
	@DisplayName("Teste para provocar a excecao de erro de argumento invalido")
	void testFileRead01() {
		InvalidArgumentException iae = assertThrows(InvalidArgumentException.class,() -> {
			
			throw new InvalidArgumentException("nome");
		});
		
		assertEquals("Entrada invalida: nome nao pode ser vazio ou nulo.",iae.getMessage());
	}
	
	@Test
	@DisplayName("Teste para provocar a excecao de erro de argumento invalido")
	void testFileRead02() {
		InvalidArgumentException iae = assertThrows(InvalidArgumentException.class,() -> {
			
			throw new InvalidArgumentException("nome", "do usuario");
		});
		
		assertEquals("Entrada invalida: nome do usuario nao pode ser vazio ou nulo.",iae.getMessage());
	}
}
