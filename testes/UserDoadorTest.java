/**
 * 
 */
package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.lp2.edoe.model.UsuarioDoador;

/**
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
class UserDoadorTest {

	private UsuarioDoador usuarioDoador;
	
	@BeforeEach
	void setUp() throws Exception {
		
		usuarioDoador = new UsuarioDoador("Liu Kang", "liu@hotmail.com", "1234-5678", "pessoa fisica", "01234567899");
	}

	@Test
	void ConstrutorDoadorTest() {
		assertEquals(usuarioDoador.getNome(), "Liu Kang");
		assertEquals(usuarioDoador.getEmail(), "liu@hotmail.com");
		assertEquals(usuarioDoador.getCelular(), "1234-5678");
		assertEquals(usuarioDoador.getClasse(), "pessoa fisica");
		assertEquals(usuarioDoador.getIdentificacao(), "01234567899");
	
	}
	
	@Test
	void toStringDoadorTest() {
		assertEquals(usuarioDoador.toString(), "Liu Kang/012.345.678-99, liu@hotmail.com, 1234-5678, status: doador");	
		
	}
	
	@Test
	void EqualsDoadorTest() {
		assertEquals(usuarioDoador.equals(new UsuarioDoador("Kung Lao", "kung@hotmail.com", "9876-5432", "igreja", "01234567899" )), true);
		assertEquals(usuarioDoador.equals(new UsuarioDoador("Liu Kang", "liu@hotmail.com", "1234-5678", "pessoa fisica", "66666666666" )), false);
	}

}
