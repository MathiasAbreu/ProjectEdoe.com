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
		 usuario02 = new Usuario("Mei Li Hua", "mei@computacao.com", "(81) 3465-8876", "PESSOA_FISICA", "01234567899", "doador");	 
	
	}
	
	@Test
	@DisplayName("Testando construtor do usuario01, que e um receptor")
	void construtorReceptorTest() {
		assertEquals(usuario01.getNome(), "Casa da mae joana");
		assertEquals(usuario01.getEmail(), "joaninha@hotmail.com");
		assertEquals(usuario01.getCelular(), "(83) 3396-1173");
		assertEquals(usuario01.getClasse(), "ONG");
		assertEquals(usuario01.getIdentificacao(), "01234567000189");
		assertEquals(usuario01.getStatus(), "Receptor");
	
	}
	
	@Test
	@DisplayName("Testando construtor do usuario02, que e um doador")
	void construtorDoadorTest() {
		assertEquals(usuario02.getNome(), "Mei Li Hua");
		assertEquals(usuario02.getEmail(), "mei@computacao.com");
		assertEquals(usuario02.getCelular(), "(81) 3465-8876");
		assertEquals(usuario02.getClasse(), "PESSOA_FISICA");
		assertEquals(usuario02.getIdentificacao(), "01234567899");
		assertEquals(usuario02.getStatus(), "doador");
	}
	
	@Test
	@DisplayName("Testando o toString() de usuario")
	void toStringReceptorTest() {
		
		assertEquals(usuario01.toString(), "Casa da mae joana/01234567000189, joaninha@hotmail.com, (83) 3396-1173, status: receptor" );
		
	}
	
	@Test
	@DisplayName("Testando o equals() de usuario")
	void equalsReceptorTest() {
		
		usuario02 = new Usuario("Casa das primas", "primas@hotmail.com", "(83) 3396-1173", "associacao", "01234567000189", "receptor");
		usuario03 = new Usuario("Liu Kang", "liu@hotmail.com", "1234-5678", "pessoa fisica", "66677766677766", "receptor");

		assertEquals(true, usuario01.equals(usuario02));
		assertEquals(usuario01.equals(usuario03), false);
	}
	
	@Test
	@DisplayName("Testando os setters...")
	void settersTest() {
		usuario01.setCelular("(11) 1111-2222");
		assertEquals(usuario01.toString(),"Casa da mae joana/01234567000189, joaninha@hotmail.com, (11) 1111-2222, status: receptor");
		usuario01.setEmail("novo@hotmail.com");
		assertEquals(usuario01.toString(),"Casa da mae joana/01234567000189, novo@hotmail.com, (11) 1111-2222, status: receptor");
		usuario01.setNome("Janna");
		assertEquals(usuario01.toString(),"Janna/01234567000189, novo@hotmail.com, (11) 1111-2222, status: receptor");
	}
	
	@Test
	@DisplayName("Testando se hashcode de Usuario funciona")
	void testHashCode() {
		
		usuario01.hashCode();
	}

}
