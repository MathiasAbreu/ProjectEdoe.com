package junit.edoe.tests.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import br.com.lp2.edoe.model.UsuarioDoador;

/**
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
class UsuarioDoadorTest {

	private UsuarioDoador usuarioDoador;
	
	@BeforeEach
	void setUp() {
		
		usuarioDoador = new UsuarioDoador("Liu Kang", "liu@hotmail.com", "1234-5678", "pessoa fisica", "01234567899");
	}

	@Test
	@DisplayName("Testando construtor de usuario")
	void ConstrutorDoadorTest() {
		assertEquals(usuarioDoador.getNome(), "Liu Kang");
		assertEquals(usuarioDoador.getEmail(), "liu@hotmail.com");
		assertEquals(usuarioDoador.getCelular(), "1234-5678");
		assertEquals(usuarioDoador.getClasse(), "pessoa fisica");
		assertEquals(usuarioDoador.getIdentificacao(), "01234567899");
	
	}
	
	@Test
	@DisplayName("Testando toString() de usuario")
	void toStringDoadorTest() {
		assertEquals(usuarioDoador.toString(), "Liu Kang/01234567899, liu@hotmail.com, 1234-5678, status: doador");	
		
	}
	
	@Test
	@DisplayName("Testando equals() de usuario")
	void EqualsDoadorTest() {
		assertEquals(usuarioDoador.equals(new UsuarioDoador("Kung Lao", "kung@hotmail.com", "9876-5432", "igreja", "01234567899" )), true);
		assertEquals(usuarioDoador.equals(new UsuarioDoador("Liu Kang", "liu@hotmail.com", "1234-5678", "pessoa fisica", "66666666666" )), false);
	}

}
