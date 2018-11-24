package junit.edoe.tests.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.lp2.edoe.model.UsuarioReceptor;

class UsuarioReceptorTest {
	
	private UsuarioReceptor usuarioReceptor01;
	private UsuarioReceptor usuarioReceptor02;
	private UsuarioReceptor usuarioReceptor03;
	
	@BeforeEach
	void setUp() {
		
		 usuarioReceptor01 = new UsuarioReceptor("Casa da mae joana", "joaninha@hotmail.com", "(83) 3396-1173", "ONG", "01234567000189");
	
	}
	
	@Test
	@DisplayName("Testando construtor de usuario receptor")
	void ConstrutorReceptorTest() {
		assertEquals(usuarioReceptor01.getNome(), "Casa da mae joana");
		assertEquals(usuarioReceptor01.getEmail(), "joaninha@hotmail.com");
		assertEquals(usuarioReceptor01.getCelular(), "(83) 3396-1173");
		assertEquals(usuarioReceptor01.getClasse(), "ONG");
		assertEquals(usuarioReceptor01.getIdentificacao(), "01234567000189");
	
	}
	
	@Test
	@DisplayName("Testando toString() de usuario receptor")
	void toStringReceptorTest() {
		
		assertEquals(usuarioReceptor01.toString(), "Casa da mae joana/01234567000189, joaninha@hotmail.com, (83) 3396-1173, status: receptor" );
		
	}
	
	@Test
	@DisplayName("Testando equals() de usuario receptor")
	void EqualsReceptorTest() {
		
		usuarioReceptor02 = new UsuarioReceptor("Casa das primas", "primas@hotmail.com", "(83) 3396-1173", "associacao", "01234567000189" );
		usuarioReceptor03 = new UsuarioReceptor("Liu Kang", "liu@hotmail.com", "1234-5678", "pessoa fisica", "66677766677766" );

		assertEquals(usuarioReceptor01, usuarioReceptor02);
		assertEquals(usuarioReceptor01.equals(usuarioReceptor03), false);
	}

}
