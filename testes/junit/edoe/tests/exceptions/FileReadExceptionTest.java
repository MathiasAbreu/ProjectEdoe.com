package junit.edoe.tests.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.lp2.edoe.exceptions.FileReadErrorException;

class FileReadExceptionTest {

	@Test
	@DisplayName("Teste para provocar a excecao de erro de leitura de arquivo")
	void testFileRead() {
		FileReadErrorException free = assertThrows(FileReadErrorException.class,() -> {
			
			throw new FileReadErrorException("Teste.ser");
		});
		
		assertEquals("Erro ao ler arquivo: Teste.ser",free.getMessage());
	}
}
