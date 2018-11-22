package junit.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import br.com.lp2.edoe.controller.ControllerUsuario;
import br.com.lp2.edoe.exceptions.InvalidArgumentException;

class ControllerUsuarioTest {
	
	private ControllerUsuario contus;
	
	@BeforeEach
	void setUp() {
		contus = new ControllerUsuario();
	}
	
	@DisplayName ("Teste que tenta adicionar um novo doador usando um id nulo") 
	@Test
	void adicionaDoadorIdNuloTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.adicionarDoador(null, "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		});
				
		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@DisplayName ("Teste que tenta adicionar um novo doador usando um id vazio")
	@Test
	void adicionaDoadorIdVazioTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.adicionarDoador("", "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		});
				
		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@DisplayName ("Teste que tenta adicionar um novo doador com o parametro nome nulo")
	@Test
	void adicionaDoadorNomeNuloTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.adicionarDoador("70513372911", null, "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		});
				
		assertEquals("Entrada invalida: nome nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@DisplayName ("Teste que tenta adicionar um novo doador com o parametro nome vazio")
	@Test
	void adicionaDoadorNomeVazioTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.adicionarDoador("70513372911", "", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		});
				
		assertEquals("Entrada invalida: nome nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@DisplayName ("Teste que tenta adicionar um novo doador com o parametro email nulo")
	@Test
	void adicionaDoadorEmailNuloTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.adicionarDoador("70513372911", "Paulo", null, "(83) 3344-5566", "PESSOA_FISICA");
		});
				
		assertEquals("Entrada invalida: email nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@DisplayName ("Teste que tenta adicionar um novo doador com o parametro email vazio")
	@Test
	void adicionaDoadorEmailVazioTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.adicionarDoador("70513372911", "Paulo", "", "(83) 3344-5566", "PESSOA_FISICA");
		});
				
		assertEquals("Entrada invalida: email nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@DisplayName ("Teste que tenta adicionar um novo doador com o parametro celular nulo")
	@Test
	void adicionaDoadorCelularNuloTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.adicionarDoador("70513372911", "Paulo", "paulo.com", null, "PESSOA_FISICA");
		});
				
		assertEquals("Entrada invalida: celular nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@DisplayName ("Teste que tenta adicionar um novo doador com o parametro celular vazio")
	@Test
	void adicionaDoadorCelularVazioTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "", "PESSOA_FISICA");
		});
				
		assertEquals("Entrada invalida: celular nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@DisplayName ("Teste que tenta adicionar um novo doador com o parametro classe nulo")
	@Test
	void adicionaDoadorClasseNulaTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", null);
		});
				
		assertEquals("Entrada invalida: classe nao pode ser vazia ou nula.", ex.getMessage());
	}
	
	@DisplayName ("Teste que tenta adicionar um novo doador com o parametro classe vazio")
	@Test
	void adicionaDoadorClasseVaziaTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "");
		});
				
		assertEquals("Entrada invalida: classe nao pode ser vazia ou nula.", ex.getMessage());
	}
	
	@DisplayName ("Teste que tenta adicionar um novo doador com o parametro classe nulo")
	@Test
	void adicionaDoadorClasseInexistenteTest() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
			contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "pessoa juridica");
		});
				
		assertEquals("Entrada invalida: opcao de classe invalida.", ex.getMessage());
	}
	
	@DisplayName ("Teste que tenta adicionar um novo doador que já se encontra cadastrado no sistema")
	@Test
	void adicionaDoadorExistenteTest() throws InvalidArgumentException  {
		contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		RuntimeException ex = assertThrows(RuntimeException.class, () -> {
			contus.adicionarDoador("70513372911", "Silas", "silas.com", "(83) 7788-9900", "PESSOA_FISICA");
		});
				
		assertEquals("Usuario ja existente: 70513372911.", ex.getMessage());
		
	}
	
	@DisplayName ("Teste que adiciona um novo doador no sistema.")
	@Test
	void adicionaDoadorTest() throws InvalidArgumentException {
		contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		contus.adicionarDoador("18513302981", "Zeca", "zeca.com", "(83) 2344-8566", "SOCIEDADE");
		
	}
	
	@DisplayName ("Teste que tenta buscar um usuario do sistema pelo id, passando um id nulo")
	@Test
	void buscaPorIdNuloTest() {
		RuntimeException ex = assertThrows(RuntimeException.class, () -> {
			contus.buscarUsuarioPorId(null);
		});
				
		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@DisplayName ("Teste que tenta buscar um usuario do sistema pelo id, passando um id vazio")
	@Test
	void buscaPorIdVazioTest() {
		RuntimeException ex = assertThrows(RuntimeException.class, () -> {
			contus.buscarUsuarioPorId("");
		});
				
		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@DisplayName ("Teste que busca um usuario do sistema pelo id")
	@Test
	void buscaPorId() throws InvalidArgumentException {
		contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		contus.adicionarDoador("18513302981", "Zeca", "zeca.com", "(83) 2344-8566", "SOCIEDADE");
		assertEquals(contus.buscarUsuarioPorId("70513372911"), "Paulo/705.133.729-11, paulo.com, (83) 3344-5566, status: doador");
		assertEquals(contus.buscarUsuarioPorId("18513302981"), "Zeca/185.133.029-81, zeca.com, (83) 2344-8566, status: doador");
			
	}
	
	@DisplayName ("Teste que tenta buscar um usuario inexistente no sistema pelo id")
	@Test
	void buscaPorIdInexistenteTest() throws InvalidArgumentException {
		contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		RuntimeException ex = assertThrows(RuntimeException.class, () -> {
			contus.buscarUsuarioPorId("98765432109");
		});
				
		assertEquals("Usuario nao encontrado: 98765432109.", ex.getMessage());
		
		
	}
	
	@DisplayName ("Teste que tenta buscar um usuario do sistema pelo nome, passando um nome nulo")
	@Test
	void buscaPeloNomeNuloTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.buscarUsuarioPorNome(null);
		});
				
		assertEquals("Entrada invalida: nome nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@DisplayName ("Teste que tenta buscar um usuario do sistema pelo nome, passando um nome vazio")
	@Test
	void buscaPeloNomeVazioest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.buscarUsuarioPorNome("");
		});
				
		assertEquals("Entrada invalida: nome nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@DisplayName ("Teste que busca um usuario do sistema pelo nome")
	@Test
	void buscaPeloNomeTest() throws InvalidArgumentException {
		contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		contus.adicionarDoador("18513302981", "Zeca", "zeca.com", "(83) 2344-8566", "SOCIEDADE");
		contus.adicionarDoador("18993309981", "Zeca", "zeca.com", "(83) 2344-8566", "SOCIEDADE");

		assertEquals(contus.buscarUsuarioPorNome("Paulo"), "Paulo/705.133.729-11, paulo.com, (83) 3344-5566, status: doador");
		assertEquals(contus.buscarUsuarioPorNome("Zeca"), "Zeca/185.133.029-81, zeca.com, (83) 2344-8566, status: doador | Zeca/189.933.099-81, zeca.com, (83) 2344-8566, status: doador");
	
	}
	
	@DisplayName ("Teste que tenta buscar um usuario inexistente no sistema pelo nome")
	@Test
	void buscaPeloNomeInexistenteTest() throws InvalidArgumentException {
		contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		NullPointerException ex = assertThrows(NullPointerException.class, () -> {
			contus.buscarUsuarioPorId("Juca");
		});
				
		assertEquals("Usuario nao encontrado: Juca.", ex.getMessage());
	
	}
	
	@DisplayName ("Teste que tenta remover um usuario do sistema, passando um id nulo")
	@Test
	void removeUsuarioNuloTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.removeUsuario(null);
		});
				
		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.", ex.getMessage());
		
	}
	
	@DisplayName ("Teste que tenta remover um usuario do sistema, passando um id vazio")
	@Test
	void removeUsuarioVazioTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.removeUsuario("");
		});
				
		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.", ex.getMessage());
		
	}
	
	@DisplayName ("Teste que remove um usuario do sistema")
	@Test
	void removeUsuarioTest() throws InvalidArgumentException {
		contus.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		contus.removeUsuario("70513372911");
	}
	
	@DisplayName ("Teste que tenta remover um usuario inexistente no sistema")
	@Test
	void removeUsuarioInexistenteTest() {
		NullPointerException ex = assertThrows(NullPointerException.class, () -> {
			contus.buscarUsuarioPorId("70513372911");
		});
				
		assertEquals("Usuario nao encontrado: 70513372911.", ex.getMessage());
	}
	
	@DisplayName ("Teste que tenta atualizar um usuario passando um id nulo")
	@Test
	void atualizaUsuarioIdNuloTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.atualizaUsuario(null, "Joao", "joao.com", "(83) 9870-4678");
		});
				
		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.", ex.getMessage());
		
	}
	
	@DisplayName ("Teste que tenta atualizar um usuario passando um id vazio")
	@Test
	void atualizaUsuarioIdVazioTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			contus.atualizaUsuario("", "Joao", "joao.com", "(83) 9870-4678");
		});
				
		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.", ex.getMessage());
		
	}
	
	@DisplayName ("Teste que tenta atualizar um usuario passando um id inexistente")
	@Test
	void atualizaUsuarioInexistenteTest() {
		NullPointerException ex = assertThrows(NullPointerException.class, () -> {
			contus.atualizaUsuario("66677766677", "Joao", "joao.com", "(83) 9870-4678");
		});
				
		assertEquals("Usuario nao encontrado: 66677766677.", ex.getMessage());
		
	}
	
	@DisplayName ("Teste que atualiza usuario")
	@Test
	void atualizaUsuarioTest() throws InvalidArgumentException {
		contus.adicionarDoador("70981334918", "Ana", "ana.com", "(83) 7384-5906", "PESSOA_FISICA");
		assertEquals(contus.atualizaUsuario("70981334918", "Mariana", "mariana.com", "(81) 9814-7729"), "Mariana/709.813.349-18, mariana.com, (81) 9814-7729, status: doador");
		
	}
	
}
