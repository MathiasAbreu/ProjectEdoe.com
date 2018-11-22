package junit.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.com.lp2.edoe.controller.ControllerUsuario;
import br.com.lp2.edoe.model.InvalidArgumentException;

class ControllerUsuarioTest {
	
	private ControllerUsuario contus;
	
	@BeforeEach
	void setUp() {
		contus = new ControllerUsuario();
	}
	
	@Test
	void AdicionaDoadorIdNuloTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.adicionarDoador(null, "Paulo", "paulo.com", "(83) 3344-5566", "pessoa fisica");
		});
				
		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@Test
	void AdicionaDoadorIdVazioTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.adicionarDoador("", "Paulo", "paulo.com", "(83) 3344-5566", "pessoa fisica");
		});
				
		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@Test
	void AdicionaDoadorNomeNuloTest() {
		RuntimeException ex = assertThrows(RuntimeException.class, () -> {
			contus.adicionarDoador("70513372911", null, "paulo.com", "(83) 3344-5566", "pessoa fisica");
		});
				
		assertEquals("Entrada invalida: nome nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@Test
	void AdicionaDoadorNomeVazioTest() {
		RuntimeException ex = assertThrows(RuntimeException.class, () -> {
			contus.adicionarDoador("70513372911", "", "paulo.com", "(83) 3344-5566", "pessoa fisica");
		});
				
		assertEquals("Entrada invalida: nome nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@Test
	void AdicionaDoadorEmailNuloTest() {
		RuntimeException ex = assertThrows(RuntimeException.class, () -> {
			contus.adicionarDoador("70513372911", "Paulo", null, "(83) 3344-5566", "pessoa fisica");
		});
				
		assertEquals("Entrada invalida: email nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@Test
	void AdicionaDoadorEmailVazioTest() {
		RuntimeException ex = assertThrows(RuntimeException.class, () -> {
			contus.adicionarDoador("70513372911", "Paulo", "", "(83) 3344-5566", "pessoa fisica");
		});
				
		assertEquals("Entrada invalida: email nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@Test
	void AdicionaDoadorCelularNuloTest() {
		RuntimeException ex = assertThrows(RuntimeException.class, () -> {
			contus.adicionarDoador("70513372911", "Paulo", "paulo.com", null, "pessoa fisica");
		});
				
		assertEquals("Entrada invalida: celular nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@Test
	void AdicionaDoadorCelularVazioTest() {
		RuntimeException ex = assertThrows(RuntimeException.class, () -> {
			contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "", "pessoa fisica");
		});
				
		assertEquals("Entrada invalida: celular nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@Test
	void AdicionaDoadorClasseNulaTest() {
		RuntimeException ex = assertThrows(RuntimeException.class, () -> {
			contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", null);
		});
				
		assertEquals("Entrada invalida: classe nao pode ser vazia ou nula.", ex.getMessage());
	}
	
	@Test
	void AdicionaDoadorClasseVaziaTest() {
		RuntimeException ex = assertThrows(RuntimeException.class, () -> {
			contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "");
		});
				
		assertEquals("Entrada invalida: classe nao pode ser vazia ou nula.", ex.getMessage());
	}
	
	@Test
	void AdicionaDoadorClasseInexistenteTest() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
			contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "pessoa juridica");
		});
				
		assertEquals("Entrada invalida: opcao de classe invalida.", ex.getMessage());
	}
	
	@Test
	void AdicionaDoadorTest() {
		contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "pessoa fisica");
	}

}
