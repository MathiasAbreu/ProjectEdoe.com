package junit.edoe.tests.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.lp2.edoe.model.Usuario;

class UsuarioTest {
	
	private Usuario usuario01;
	private Usuario usuario02;
	private Usuario usuario03;
	
	@BeforeEach
	void setUp() {
		
		 usuario01 = new Usuario("Casa da mae joana", "joaninha@hotmail.com", "(83) 3396-1173", "ONG", "01234567000189","receptor");
	
	}
	
	@Test
	@DisplayName("Testando construtor de usuario receptor")
	void ConstrutorReceptorTest() {
		assertEquals(usuario01.getNome(), "Casa da mae joana");
		assertEquals(usuario01.getEmail(), "joaninha@hotmail.com");
		assertEquals(usuario01.getCelular(), "(83) 3396-1173");
		assertEquals(usuario01.getClasse(), "ONG");
		assertEquals(usuario01.getIdentificacao(), "01234567000189");
	
	}
	
	@Test
	@DisplayName("Testando toString() de usuario receptor")
	void toStringReceptorTest() {
		
		assertEquals(usuario01.toString(), "Casa da mae joana/01234567000189, joaninha@hotmail.com, (83) 3396-1173, status: receptor" );
		
	}
	
	@Test
	@DisplayName("Testando equals() de usuario receptor")
	void EqualsReceptorTest() {
		
		usuario02 = new Usuario("Casa das primas", "primas@hotmail.com", "(83) 3396-1173", "associacao", "01234567000189", "receptor");
		usuario03 = new Usuario("Liu Kang", "liu@hotmail.com", "1234-5678", "pessoa fisica", "66677766677766", "receptor");

		assertEquals(usuario01, usuario02);
		assertEquals(usuario01.equals(usuario03), false);
	}

}
