package junit.edoe.tests.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.lp2.edoe.exceptions.FileWriteErrorException;

class FileWriteExceptionTest {

	@Test
	@DisplayName("Teste para provocar a excecao de erro de escrita de arquivo")
	void testFileRead() {
		FileWriteErrorException fwee = assertThrows(FileWriteErrorException.class,() -> {
			
			throw new FileWriteErrorException("Teste.ser");
		});
		
		assertEquals("Erro ao escrever no arquivo: Teste.ser",fwee.getMessage());
	}
}
