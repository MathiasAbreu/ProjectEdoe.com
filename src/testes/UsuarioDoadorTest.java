package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.lp2.edoe.model.UsuarioDoador;

class UsuarioDoadorTest {
	UsuarioDoador ud = new UsuarioDoador("Liu Kang", "liu@hotmail.com", "1234-5678", "pessoa fisica", "012.345.678-99");;
	
	@Test
	void ConstrutorDoadorTest() {
		assertEquals(ud.getNome(), "Liu Kang");
		assertEquals(ud.getEmail(), "liu@hotmail.com");
		assertEquals(ud.getCelular(), "1234-5678");
		assertEquals(ud.getClasse(), "pessoa fisica");
		assertEquals(ud.getIdentificacao(), "012.345.678-99");
		assertEquals(ud.getStatus(), "doador");
	
	}
	
	@Test
	void toStringDoadorTest() {
		assertEquals(ud.toString(), "Liu Kang/012.345.678-99, liu@hotmail.com, 1234-5678, status: doador");	
		
	}
	
	@Test
	void EqualsDoadorTest() {
		assertEquals(ud.equals(new UsuarioDoador("Kung Lao", "kung@hotmail.com", "9876-5432", "igreja", "012.345.678-99" )), true);
		assertEquals(ud.equals(new UsuarioDoador("Liu Kang", "liu@hotmail.com", "1234-5678", "pessoa fisica", "666.666.666-66" )), false);
	}
		

}
