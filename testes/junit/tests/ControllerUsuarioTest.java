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
			contus.adicionarDoador(null, "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		});
				
		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@Test
	void AdicionaDoadorIdVazioTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.adicionarDoador("", "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		});
				
		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@Test
	void AdicionaDoadorNomeNuloTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.adicionarDoador("70513372911", null, "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		});
				
		assertEquals("Entrada invalida: nome nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@Test
	void AdicionaDoadorNomeVazioTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.adicionarDoador("70513372911", "", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		});
				
		assertEquals("Entrada invalida: nome nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@Test
	void AdicionaDoadorEmailNuloTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.adicionarDoador("70513372911", "Paulo", null, "(83) 3344-5566", "PESSOA_FISICA");
		});
				
		assertEquals("Entrada invalida: email nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@Test
	void AdicionaDoadorEmailVazioTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.adicionarDoador("70513372911", "Paulo", "", "(83) 3344-5566", "PESSOA_FISICA");
		});
				
		assertEquals("Entrada invalida: email nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@Test
	void AdicionaDoadorCelularNuloTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.adicionarDoador("70513372911", "Paulo", "paulo.com", null, "PESSOA_FISICA");
		});
				
		assertEquals("Entrada invalida: celular nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@Test
	void AdicionaDoadorCelularVazioTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "", "PESSOA_FISICA");
		});
				
		assertEquals("Entrada invalida: celular nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@Test
	void AdicionaDoadorClasseNulaTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", null);
		});
				
		assertEquals("Entrada invalida: classe nao pode ser vazia ou nula.", ex.getMessage());
	}
	
	@Test
	void AdicionaDoadorClasseVaziaTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
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
	void AdicionaDoadorExistenteTest() throws InvalidArgumentException  {
		contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		RuntimeException ex = assertThrows(RuntimeException.class, () -> {
			contus.adicionarDoador("70513372911", "Silas", "silas.com", "(83) 7788-9900", "PESSOA_FISICA");
		});
				
		assertEquals("Usuario ja existente: 70513372911.", ex.getMessage());
		
	}
	
	@Test
	void AdicionaDoadorTest() throws InvalidArgumentException {
		contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		contus.adicionarDoador("18513302981", "Zeca", "zeca.com", "(83) 2344-8566", "SOCIEDADE");
		
	}
	
	@Test
	void BuscaPorIdNuloTest() {
		RuntimeException ex = assertThrows(RuntimeException.class, () -> {
			contus.buscarUsuarioPorId(null);
		});
				
		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@Test
	void BuscaPorIdVazioTest() {
		RuntimeException ex = assertThrows(RuntimeException.class, () -> {
			contus.buscarUsuarioPorId("");
		});
				
		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@Test
	void BuscaPorId() throws InvalidArgumentException {
		contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		contus.adicionarDoador("18513302981", "Zeca", "zeca.com", "(83) 2344-8566", "SOCIEDADE");
		assertEquals(contus.buscarUsuarioPorId("70513372911"), "Paulo/705.133.729-11, paulo.com, (83) 3344-5566, status: doador");
		assertEquals(contus.buscarUsuarioPorId("18513302981"), "Zeca/185.133.029-81, zeca.com, (83) 2344-8566, status: doador");
			
	}
	
	@Test
	void BuscaPorIdInexistenteTest() throws InvalidArgumentException {
		contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		RuntimeException ex = assertThrows(RuntimeException.class, () -> {
			contus.buscarUsuarioPorId("98765432109");
		});
				
		assertEquals("Usuario nao encontrado: 98765432109.", ex.getMessage());
		
		
	}
	
	@Test
	void BuscaPeloNomeNuloTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.buscarUsuarioPorNome(null);
		});
				
		assertEquals("Entrada invalida: nome nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@Test
	void BuscaPeloNomeVazioest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.buscarUsuarioPorNome("");
		});
				
		assertEquals("Entrada invalida: nome nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@Test
	void BuscaPeloNomeTest() throws InvalidArgumentException {
		contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		contus.adicionarDoador("18513302981", "Zeca", "zeca.com", "(83) 2344-8566", "SOCIEDADE");
		contus.adicionarDoador("18993309981", "Zeca", "zeca.com", "(83) 2344-8566", "SOCIEDADE");

		assertEquals(contus.buscarUsuarioPorNome("Paulo"), "Paulo/705.133.729-11, paulo.com, (83) 3344-5566, status: doador");
		assertEquals(contus.buscarUsuarioPorNome("Zeca"), "Zeca/185.133.029-81, zeca.com, (83) 2344-8566, status: doador | Zeca/189.933.099-81, zeca.com, (83) 2344-8566, status: doador");
	
	}
	
	@Test
	void BuscaPeloNomeInexistenteTest() throws InvalidArgumentException {
		contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		RuntimeException ex = assertThrows(RuntimeException.class, () -> {
			contus.buscarUsuarioPorId("Juca");
		});
				
		assertEquals("Usuario nao encontrado: Juca.", ex.getMessage());
	
	}
	
	@Test
	void RemoveUsuarioNuloTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.removeUsuario(null);
		});
				
		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.", ex.getMessage());
		
	}
	
	@Test
	void RemoveUsuarioVazioTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.removeUsuario("");
		});
				
		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.", ex.getMessage());
		
	}
	
	@Test
	void RemoveUsuarioTest() throws InvalidArgumentException {
		contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		contus.removeUsuario("70513372911");
		
		NullPointerException ex = assertThrows(NullPointerException.class, () -> {
			contus.buscarUsuarioPorId("70513372911");
		});
				
		assertEquals("Usuario nao encontrado: 70513372911.", ex.getMessage());
	}
}
