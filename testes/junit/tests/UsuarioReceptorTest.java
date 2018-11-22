package junit.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.lp2.edoe.model.UsuarioReceptor;

class UsuarioReceptorTest {
	UsuarioReceptor ur = new UsuarioReceptor("Casa da mae joana", "joaninha@hotmail.com", "(83) 3396-1173", "ONG", "01.234.567/0001-89");
	
	@Test
	void ConstrutorReceptorTest() {
		assertEquals(ur.getNome(), "Casa da mae joana");
		assertEquals(ur.getEmail(), "joaninha@hotmail.com");
		assertEquals(ur.getCelular(), "(83) 3396-1173");
		assertEquals(ur.getClasse(), "ONG");
		assertEquals(ur.getIdentificacao(), "01.234.567/0001-89");
	
	}
	
	@Test
	void toStringReceptorTest() {
		String formatado = "Casa da mae joana/01.234.567/0001-89, joaninha@hotmail.com, (83) 3396-1173, status: receptor";
		assertEquals(ur.toString(), formatado );
		
	}
	
	@Test
	void EqualsReceptorTest() {
		UsuarioReceptor ur2 = new UsuarioReceptor("Casa das primas", "primas@hotmail.com", "(83) 3396-1173", "associacao", "01.234.567/0001-89" );
		assertEquals(ur, ur2);
		UsuarioReceptor ur3 = new UsuarioReceptor("Liu Kang", "liu@hotmail.com", "1234-5678", "pessoa fisica", "66.677.766/6777-66" );
		assertEquals(ur.equals(ur3), false);
	}

}
