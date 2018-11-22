package junit.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.lp2.edoe.model.UsuarioDoador;

class UsuarioDoadorTest {
	UsuarioDoador ud = new UsuarioDoador("Liu Kang", "liu@hotmail.com", "1234-5678", "pessoa fisica", "01234567899");
	
	@Test
	void ConstrutorDoadorTest() {
		assertEquals(ud.getNome(), "Liu Kang");
		assertEquals(ud.getEmail(), "liu@hotmail.com");
		assertEquals(ud.getCelular(), "1234-5678");
		assertEquals(ud.getClasse(), "pessoa fisica");
		assertEquals(ud.getIdentificacao(), "01234567899");
	
	}
	
	@Test
	void toStringDoadorTest() {
		String formatado = "Liu Kang/012.345.678-99, liu@hotmail.com, 1234-5678, status: doador";
		assertEquals(ud.toString(), formatado );
		
	}
	
	@Test
	void EqualsDoadorTest() {
		UsuarioDoador ud2 = new UsuarioDoador("Kung Lao", "kung@hotmail.com", "9876-5432", "igreja", "01234567899" );
		assertEquals(ud, ud2);
		UsuarioDoador ud3 = new UsuarioDoador("Liu Kang", "liu@hotmail.com", "1234-5678", "pessoa fisica", "66666666666" );
		assertEquals(ud.equals(ud3), false);
	}
		

}
