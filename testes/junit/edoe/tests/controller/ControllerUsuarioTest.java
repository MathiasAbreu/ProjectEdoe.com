package junit.edoe.tests.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import br.com.lp2.edoe.controller.ControllerUsuario;
import br.com.lp2.edoe.exceptions.InvalidArgumentException;
import br.com.lp2.edoe.exceptions.InvalidUserException;

class ControllerUsuarioTest {

	private ControllerUsuario controle;

	@BeforeEach
	void setUp() {
		controle = new ControllerUsuario();
	}

	@Test
	@DisplayName("Teste que tenta adicionar um novo doador usando um id nulo")
	void adicionaDoadorIdNuloTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			controle.adicionarDoador(null, "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		});

		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.", ex.getMessage());
	}

	@Test
	@DisplayName("Teste que tenta adicionar um novo doador usando um id vazio")
	void adicionaDoadorIdVazioTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			controle.adicionarDoador("", "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		});

		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.", ex.getMessage());
	}

	@Test
	@DisplayName("Teste que tenta adicionar um novo doador com o parametro nome nulo")
	void adicionaDoadorNomeNuloTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			controle.adicionarDoador("70513372911", null, "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		});

		assertEquals("Entrada invalida: nome nao pode ser vazio ou nulo.", ex.getMessage());
	}

	@Test
	@DisplayName("Teste que tenta adicionar um novo doador com o parametro nome vazio")
	void adicionaDoadorNomeVazioTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			controle.adicionarDoador("70513372911", "", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		});

		assertEquals("Entrada invalida: nome nao pode ser vazio ou nulo.", ex.getMessage());
	}

	@Test
	@DisplayName("Teste que tenta adicionar um novo doador com o parametro email nulo")
	void adicionaDoadorEmailNuloTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			controle.adicionarDoador("70513372911", "Paulo", null, "(83) 3344-5566", "PESSOA_FISICA");
		});

		assertEquals("Entrada invalida: email nao pode ser vazio ou nulo.", ex.getMessage());
	}

	@Test
	@DisplayName("Teste que tenta adicionar um novo doador com o parametro email vazio")
	void adicionaDoadorEmailVazioTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			controle.adicionarDoador("70513372911", "Paulo", "", "(83) 3344-5566", "PESSOA_FISICA");
		});

		assertEquals("Entrada invalida: email nao pode ser vazio ou nulo.", ex.getMessage());
	}

	@Test
	@DisplayName("Teste que tenta adicionar um novo doador com o parametro celular nulo")
	void adicionaDoadorCelularNuloTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			controle.adicionarDoador("70513372911", "Paulo", "paulo.com", null, "PESSOA_FISICA");
		});

		assertEquals("Entrada invalida: celular nao pode ser vazio ou nulo.", ex.getMessage());
	}

	@Test
	@DisplayName("Teste que tenta adicionar um novo doador com o parametro celular vazio")
	void adicionaDoadorCelularVazioTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			controle.adicionarDoador("70513372911", "Paulo", "paulo.com", "", "PESSOA_FISICA");
		});

		assertEquals("Entrada invalida: celular nao pode ser vazio ou nulo.", ex.getMessage());
	}

	@Test
	@DisplayName("Teste que tenta adicionar um novo doador com o parametro classe nulo")
	void adicionaDoadorClasseNulaTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			controle.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", null);
		});

		assertEquals("Entrada invalida: classe nao pode ser vazia ou nula.", ex.getMessage());
	}

	@Test
	@DisplayName("Teste que tenta adicionar um novo doador com o parametro classe vazio")
	void adicionaDoadorClasseVaziaTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			controle.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "");
		});

		assertEquals("Entrada invalida: classe nao pode ser vazia ou nula.", ex.getMessage());
	}

	@Test
	@DisplayName("Teste que tenta adicionar um novo doador com o parametro classe nulo")
	void adicionaDoadorClasseInexistenteTest() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
			controle.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "pessoa juridica");
		});

		assertEquals("Entrada invalida: opcao de classe invalida.", ex.getMessage());
	}

	@Test
	@DisplayName("Teste que tenta adicionar um novo doador que já se encontra cadastrado no sistema")
	void adicionaDoadorExistenteTest() throws Exception {
		controle.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		InvalidUserException ex = assertThrows(InvalidUserException.class, () -> {
			controle.adicionarDoador("70513372911", "Silas", "silas.com", "(83) 7788-9900", "PESSOA_FISICA");
		});

		assertEquals("Usuario ja existente: 70513372911.", ex.getMessage());

	}

	@Test
	@DisplayName("Teste que adiciona um novo doador no sistema.")
	void adicionaDoadorTest() throws Exception {
		controle.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		controle.adicionarDoador("18513302981", "Zeca", "zeca.com", "(83) 2344-8566", "SOCIEDADE");

	}

	@Test
	@DisplayName("Teste que tenta buscar um usuario do sistema pelo id, passando um id nulo")
	void buscaPorIdNuloTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			controle.buscarUsuarioPorId(null);
		});

		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.", ex.getMessage());
	}

	@Test
	@DisplayName("Teste que tenta buscar um usuario do sistema pelo id, passando um id vazio")
	void buscaPorIdVazioTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			controle.buscarUsuarioPorId("");
		});

		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.", ex.getMessage());
	}

	@Test
	@DisplayName("Teste que busca um usuario do sistema pelo id")
	void buscaPorId() throws Exception {
		controle.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		controle.adicionarDoador("18513302981", "Zeca", "zeca.com", "(83) 2344-8566", "SOCIEDADE");
		
		assertEquals(controle.buscarUsuarioPorId("70513372911"),"Paulo/705.133.729-11, paulo.com, (83) 3344-5566, status: doador");
		assertEquals(controle.buscarUsuarioPorId("18513302981"),"Zeca/185.133.029-81, zeca.com, (83) 2344-8566, status: doador");

	}

	@Test
	@DisplayName("Teste que tenta buscar um usuario inexistente no sistema pelo id")
	void buscaPorIdInexistenteTest() throws Exception {
		controle.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		InvalidUserException ex = assertThrows(InvalidUserException.class, () -> {
			controle.buscarUsuarioPorId("98765432109");
		});

		assertEquals("Usuario nao encontrado: 98765432109.", ex.getMessage());

	}

	@Test
	@DisplayName("Teste que tenta buscar um usuario do sistema pelo nome, passando um nome nulo")
	void buscaPeloNomeNuloTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			controle.buscarUsuarioPorNome(null);
		});

		assertEquals("Entrada invalida: nome nao pode ser vazio ou nulo.", ex.getMessage());
	}

	@Test
	@DisplayName("Teste que tenta buscar um usuario do sistema pelo nome, passando um nome vazio")
	void buscaPeloNomeVazioest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			controle.buscarUsuarioPorNome("");
		});

		assertEquals("Entrada invalida: nome nao pode ser vazio ou nulo.", ex.getMessage());
	}

	@Test
	@DisplayName("Teste que busca um usuario do sistema pelo nome")
	void buscaPeloNomeTest() throws Exception {
		
		controle.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		controle.adicionarDoador("18513302981", "Zeca", "zeca.com", "(83) 2344-8566", "SOCIEDADE");
		controle.adicionarDoador("18993309981", "Zeca", "zeca.com", "(83) 2344-8566", "SOCIEDADE");

		assertEquals(controle.buscarUsuarioPorNome("Paulo"),"Paulo/705.133.729-11, paulo.com, (83) 3344-5566, status: doador");
		assertEquals(controle.buscarUsuarioPorNome("Zeca"),"Zeca/185.133.029-81, zeca.com, (83) 2344-8566, status: doador | Zeca/189.933.099-81, zeca.com, (83) 2344-8566, status: doador");

	}

	@Test
	@DisplayName("Teste que tenta buscar um usuario inexistente no sistema pelo nome")
	void buscaPeloNomeInexistenteTest() throws Exception {
		
		controle.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		
		InvalidUserException ex = assertThrows(InvalidUserException.class, () -> {
			controle.buscarUsuarioPorId("Juca");
		});

		assertEquals("Usuario nao encontrado: Juca.", ex.getMessage());

	}

	@Test
	@DisplayName("Teste que tenta remover um usuario do sistema, passando um id nulo")
	void removeUsuarioNuloTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			controle.removeUsuario(null);
		});

		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.", ex.getMessage());

	}

	@Test
	@DisplayName("Teste que tenta remover um usuario do sistema, passando um id vazio")
	void removeUsuarioVazioTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			controle.removeUsuario("");
		});

		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.", ex.getMessage());

	}

	@Test
	@DisplayName("Teste que remove um usuario do sistema")
	void removeUsuarioTest() throws Exception {
		
		controle.adicionarDoador("70513372911", "Paulo", "paulo.com", "(83) 3344-5566", "PESSOA_FISICA");
		controle.removeUsuario("70513372911");
	}

	@Test
	@DisplayName("Teste que tenta remover um usuario inexistente no sistema")
	void removeUsuarioInexistenteTest() {
		InvalidUserException ex = assertThrows(InvalidUserException.class, () -> {
			controle.buscarUsuarioPorId("70513372911");
		});

		assertEquals("Usuario nao encontrado: 70513372911.", ex.getMessage());
	}

	@Test
	@DisplayName("Teste que tenta atualizar um usuario passando um id nulo")
	void atualizaUsuarioIdNuloTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			controle.atualizaUsuario(null, "Joao", "joao.com", "(83) 9870-4678");
		});

		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.", ex.getMessage());

	}

	@Test
	@DisplayName("Teste que tenta atualizar um usuario passando um id vazio")
	void atualizaUsuarioIdVazioTest() {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			controle.atualizaUsuario("", "Joao", "joao.com", "(83) 9870-4678");
		});

		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.", ex.getMessage());

	}

	@Test
	@DisplayName("Teste que tenta atualizar um usuario passando um id inexistente")
	void atualizaUsuarioInexistenteTest() {
		InvalidUserException ex = assertThrows(InvalidUserException.class, () -> {
			controle.atualizaUsuario("66677766677", "Joao", "joao.com", "(83) 9870-4678");
		});

		assertEquals("Usuario nao encontrado: 66677766677.", ex.getMessage());

	}

	@Test
	@DisplayName("Teste que atualiza usuario")
	void atualizaUsuarioTest() throws Exception {
		
		controle.adicionarDoador("70981334918", "Ana", "ana.com", "(83) 7384-5906", "PESSOA_FISICA");
		
		assertEquals(controle.atualizaUsuario("70981334918", "Mariana", "mariana.com", "(81) 9814-7729"),"Mariana/709.813.349-18, mariana.com, (81) 9814-7729, status: doador");

	}
}
