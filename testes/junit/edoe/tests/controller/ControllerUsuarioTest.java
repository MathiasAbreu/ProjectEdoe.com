package junit.edoe.tests.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import br.com.lp2.edoe.controller.ControllerEdoe;
import br.com.lp2.edoe.exceptions.InvalidArgumentException;
import br.com.lp2.edoe.exceptions.InvalidUserException;

class ControllerUsuarioTest {

	private ControllerEdoe controle;

	@BeforeEach
	void setUp() throws Exception {
		
		controle = new ControllerEdoe();
		
		controle.adicionarDoador("12345678901","Mathias","mathias.trajano","18584257","PESSOA_FISICA");
		controle.adicionarDoador("99999999999","Fulano","fulano@gmail.com","68545354","PESSOA_FISICA");
		controle.adicionarDoador("88888888888","Beltrano","beltrano@gmail.com","55465852","PESSOA_FISICA");
		controle.lerReceptores("arquivos_sistema/novosReceptores.csv");
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
		assertEquals(controle.buscarUsuarioPorId("70513372911"),"Paulo/70513372911, paulo.com, (83) 3344-5566, status: doador");
		assertEquals(controle.buscarUsuarioPorId("18513302981"),"Zeca/18513302981, zeca.com, (83) 2344-8566, status: doador");

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

		assertEquals(controle.buscarUsuarioPorNome("Paulo"),"Paulo/70513372911, paulo.com, (83) 3344-5566, status: doador");
		assertEquals(controle.buscarUsuarioPorNome("Zeca"),"Zeca/18513302981, zeca.com, (83) 2344-8566, status: doador | Zeca/18993309981, zeca.com, (83) 2344-8566, status: doador");

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
		
		assertEquals(controle.atualizaUsuario("70981334918", "Mariana", "mariana.com", "(81) 9814-7729"),"Mariana/70981334918, mariana.com, (81) 9814-7729, status: doador");

	}
	
	@Test
	@DisplayName("Testando metodo de adiciona descritor")
	void testAdicionaDescritor01() throws InvalidArgumentException{
		
		controle.adicionaDescritor("camisa");
		
	}
	
	@Test
	@DisplayName("Testando metodo de adiciona descritor com descricao invalido")
	void testAdicionaDescritor02() {
		InvalidArgumentException iae = assertThrows(InvalidArgumentException.class,() -> {
			
			controle.adicionaDescritor("");
		});
		
		assertEquals("Entrada invalida: descricao nao pode ser vazia ou nula.",iae.getMessage());
	}
	
	@Test
	@DisplayName("Testando metodo de adiciona descritor com um descritor ja existente")
	void testAdicionaDescritor03() {
		RuntimeException rte = assertThrows(RuntimeException.class,() -> {
			
			controle.adicionaDescritor("cobertor");
			controle.adicionaDescritor("cobertor");
			
		});
		
		assertEquals("Descritor de Item ja existente: cobertor.",rte.getMessage());
	}
	
	@Test
	@DisplayName("Testando metodo adicionando item para doacao")
	void testAdicionaItem01() throws Exception {
		
		String idRetorno = controle.adicionaItem("12345678901","calca",2,"calca jeans,branca");
		
		assertEquals("1",idRetorno);
	}
	
	@Test
	@DisplayName("Testando metodo de adicionar item com id do doador invalido")
	void testAdicionaItem02() {
		InvalidArgumentException iae = assertThrows(InvalidArgumentException.class,() -> {
			
			controle.adicionaItem("","calca",2,"calca jeans,branca");
		});
		
		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.",iae.getMessage());
	}
	
	@Test
	@DisplayName("Testando metodo de adicionar item com descricao invalida")
	void testAdicionaItem03() {
		InvalidArgumentException iae = assertThrows(InvalidArgumentException.class,() -> {
			
			controle.adicionaItem("12345678901",null,2,"calca jeans,branca");
		});
		
		assertEquals("Entrada invalida: descricao nao pode ser vazia ou nula.",iae.getMessage());
	}
	
	@Test
	@DisplayName("Testando metodo de adicionar item com quantidade invalida")
	void testAdicionaItem04() {
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,() -> {
			
			controle.adicionaItem("12345678901","calca",-5,"calca jeans,branca");
		});
		
		assertEquals("Entrada invalida: quantidade deve ser maior que zero.",iae.getMessage());
	}
	
	@Test
	@DisplayName("Testando metodo de adicionar item com id de um doador inexistente")
	void testAdicionaItem05() {
		InvalidUserException iae = assertThrows(InvalidUserException.class,() -> {
			
			controle.adicionaItem("123","calca",8,"calca branca,pequena");
		});
		
		assertEquals("Usuario nao encontrado: 123.",iae.getMessage());
	}
	
	@Test
	@DisplayName("Testando metodo de exibir item com parametros validos")
	void testExibeItem01() throws Exception {
		
		controle.adicionaItem("12345678901","camisa",4,"camisa,branca");
		
		assertEquals("1 - camisa, tags: [camisa, branca], quantidade: 4",controle.exibeItem("1", "12345678901"));
	}
	
	@Test
	@DisplayName("Testando metodo de exibir item com item inexistente")
	void testExibeItem02() throws Exception {
		NullPointerException npe = assertThrows(NullPointerException.class,() -> {
			
			controle.exibeItem("357986533","12345678901");
		});
		
		assertEquals("Item nao encontrado: 357986533.",npe.getMessage());
	}
	
	@Test
	@DisplayName("Testando metodo de exibir item com idDoDoador invalido")
	void testExibeItem03() throws Exception {
		InvalidArgumentException iae = assertThrows(InvalidArgumentException.class,() -> {
			
			controle.exibeItem("1234567890",null);
		});
		
		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.",iae.getMessage());
	}
	
	@Test
	@DisplayName("Testando metodo de exibir item com usuario inexistente")
	void testExibeItem04() throws Exception {
		InvalidUserException iue = assertThrows(InvalidUserException.class,() -> {
			
			controle.exibeItem("12345678","109876543");
		});
		
		assertEquals("Usuario nao encontrado: 109876543.",iue.getMessage());
	}
	
	@Test
	@DisplayName("Testando metodo de exibir item com idItem invalido")
	void testExibeItem05() throws Exception {
		InvalidArgumentException iae = assertThrows(InvalidArgumentException.class,() -> {
			
			controle.exibeItem("","12345678901");
		});
		
		assertEquals("Entrada invalida: id do item nao pode ser vazio ou nulo.",iae.getMessage());
	}
	
	@Test
	@DisplayName("Testando metodo de atualizar item com id invalido")
	void testAtualizarItem01() {
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,() -> {
			
			controle.atualizaItem("-5","12345678901",4,"camisa,branca");
		});
		
		assertEquals("Entrada invalida: id do item nao pode ser negativo.",iae.getMessage());
	}
	
	@Test
	@DisplayName("Testando metodo de atualizar item com id do doador invalido")
	void testAtualizarItem02() {
		InvalidArgumentException iue = assertThrows(InvalidArgumentException.class,() -> {
			
			controle.atualizaItem("12345678",null,4,"camisa,branca");
		});
		
		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.",iue.getMessage());
	}
	
	@Test
	@DisplayName("Testando metodo de atualizar item com quantidade invalida")
	void testAtualizarItem03() throws Exception {			
		
		controle.adicionaItem("12345678901","blusa",2,"camisa,amarela");
		controle.atualizaItem("1","12345678901",-5,"camisa,branca");
		
		assertEquals("1 - blusa, tags: [camisa, branca], quantidade: 2",controle.exibeItem("1","12345678901"));
	}
	
	@Test
	@DisplayName("Testando metodo de atualizar item com um item que nao existe")
	void testAtualizarItem04() {
		NullPointerException npe = assertThrows(NullPointerException.class,() -> {
			
			controle.atualizaItem("1234567","12345678901",4,"camisa,branca");
		});
		
		assertEquals("O usuario não tem itens cadastrados",npe.getMessage());
	}
	
	@Test
	@DisplayName("Testando metodo de atualizar item alterando a quantidade")
	void testAtualizarItem05() throws Exception {
		
		controle.adicionaItem("12345678901","blusa",2,"camisa,amarela");
		
		assertEquals("1 - blusa, tags: [camisa, amarela], quantidade: 5",controle.atualizaItem("1", "12345678901",5,""));
	}
	
	@Test
	@DisplayName("Testando metodo de atualizar item alterando as tags")
	void testAtualizarItem06() throws Exception {
		
		controle.adicionaItem("12345678901","blusa",2,"camisa,amarela");
		
		assertEquals("1 - blusa, tags: [blusa, pequena, amarela], quantidade: 2",controle.atualizaItem("1", "12345678901",2,"blusa,pequena,amarela"));
	}
	
	@Test
	@DisplayName("Testando metodo de remover item com id invalido")
	void testRemoverItem01() {
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,() -> {
			
			controle.removeItem("-8653777","12345678901");
		});
		
		assertEquals("Entrada invalida: id do item nao pode ser negativo.",iae.getMessage());
	}
	
	@Test
	@DisplayName("Testando metodo de remover item com id do doador invalido")
	void testRemoverItem02() {
		InvalidArgumentException iae = assertThrows(InvalidArgumentException.class,() -> {
			
			controle.removeItem("12345678",null);
		});
		
		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.",iae.getMessage());
	}
	
	@Test
	@DisplayName("Testando metodo de remover item com usuario inexistente")
	void testRemoverItem03() {
		InvalidUserException iue = assertThrows(InvalidUserException.class,() -> {
			
			controle.removeItem("12345678","12345678");
		});
		
		assertEquals("Usuario nao encontrado: 12345678.",iue.getMessage());
	}
	
	@Test
	@DisplayName("Testando metodo de remover item com item cadastrado")
	void testRemoverItem04() throws Exception {
		NullPointerException npe = assertThrows(NullPointerException.class,() -> {
			
			String id = controle.adicionaItem("12345678901","blusa",2,"camisa,amarela");
			controle.removeItem(id, "12345678901");
			controle.exibeItem(id, "12345678901");
		});
		
		assertEquals("Item nao encontrado: 1.",npe.getMessage());
	}
	
	@Test
	@DisplayName("Testando exibir descritores que foram adicionados em ordem nao alfabetica")
	void testListaDescritorDeItensParaDoacao01() throws Exception {
		controle.adicionaDescritor("calca");
		controle.adicionaDescritor("sapato");
		controle.adicionaDescritor("blusa");
		assertEquals("0 - blusa | 0 - calca | 0 - sapato",controle.listaDescritorDeItens());
	}
	
	@Test
	@DisplayName("Testando exibir descritores apos mudar quantidade")
	void testListaDescritorDeItensParaDoacao02() throws Exception {
		controle.adicionaDescritor("casaco");
		controle.adicionaDescritor("cachecol");
		controle.adicionaDescritor("luva");
		controle.adicionaItem("12345678901", "luva", 6, "velha");
		assertEquals("0 - cachecol | 0 - casaco | 6 - luva",controle.listaDescritorDeItens());
		controle.adicionaItem("12345678901", "casaco", 2, "azul");
		assertEquals("0 - cachecol | 2 - casaco | 6 - luva",controle.listaDescritorDeItens());
	}
	
	@Test
	@DisplayName("Testando exbir descritores apos mudar a quantidade do mesmo item mais de uma vez")
	void testListaDescritorDeItensParaDoacao03() throws Exception {
		controle.adicionaDescritor("cadeira");
		controle.adicionaDescritor("sofa");
		controle.adicionaItem("12345678901", "cadeira", 3, "plastico");
		assertEquals("3 - cadeira | 0 - sofa",controle.listaDescritorDeItens());
		controle.adicionaItem("12345678901", "cadeira", 1, "plastico");
		assertEquals("1 - cadeira | 0 - sofa",controle.listaDescritorDeItens());
	}
	
	@Test
	@DisplayName("Testando se excecao eh lancada ao tentar listar descritores sem haver nenhum registrado")
	void testListaDescritorDeItensParaDoacao04() {
		NullPointerException ex = assertThrows(NullPointerException.class, () -> {
			controle.listaDescritorDeItens();
		});
		assertEquals("Erro: Nao ha Itens nem Descritores cadastrados no sistema.", ex.getMessage());
	}
	
	@Test
	@DisplayName("Testando se excecao eh lancada ao tentar listar itens sem haver nenhum registrado")
	void testListaItensParaDoacao01() {
		NullPointerException ex = assertThrows(NullPointerException.class, () -> {
			controle.listaItens("doador");
		});
		assertEquals("Erro: Nao ha itens cadastrados", ex.getMessage());
	}
	
	@Test
	@DisplayName("Testando se itens sao listados em ordem decrescente de quantidade")
	void testListaItensParaDoacao02() throws Exception {
		controle.adicionaItem("12345678901", "arroz", 64, "integral");
		controle.adicionaItem("12345678901", "feijao", 108, "verde");
		assertEquals("2 - feijao, tags: [verde], quantidade: 108, doador: Mathias/12345678901 | "
				+ "1 - arroz, tags: [integral], quantidade: 64, doador: Mathias/12345678901"
				, controle.listaItens("doador"));
		controle.adicionaItem("12345678901", "sabao", 80, "antibacteriano");
		assertEquals("2 - feijao, tags: [verde], quantidade: 108, doador: Mathias/12345678901 | "
				+ "3 - sabao, tags: [antibacteriano], quantidade: 80, doador: Mathias/12345678901 | "
				+ "1 - arroz, tags: [integral], quantidade: 64, doador: Mathias/12345678901"
				, controle.listaItens("doador"));
	}
	
	@Test
	@DisplayName("Testando se itens sao reorganizado apos mudar quantidade do item")
	void testListaItensParaDoacao03() throws Exception {
		controle.adicionaItem("12345678901", "arroz", 64, "integral");
		controle.adicionaItem("12345678901", "feijao", 108, "verde");
		controle.adicionaItem("12345678901", "sabao", 80, "antibacteriano");
		controle.adicionaItem("12345678901", "feijao", 1, "verde");
		assertEquals("3 - sabao, tags: [antibacteriano], quantidade: 80, doador: Mathias/12345678901 | "
				+ "1 - arroz, tags: [integral], quantidade: 64, doador: Mathias/12345678901 | "
				+ "2 - feijao, tags: [verde], quantidade: 1, doador: Mathias/12345678901"
				, controle.listaItens("doador"));
	}
	
	@Test
	@DisplayName("Testando pesquisar por uma descricao nula")
	void testPesquisaItemParaDoacaoPorDescricao01() throws Exception {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			controle.pesquisaItemPorDescricao(null);
		});
		assertEquals("Entrada invalida: texto da pesquisa nao pode ser vazio ou nulo.", ex.getMessage());
	}
	
	@Test
	@DisplayName("Testando pesquisar por descricoes vazias")
	void testPesquisaItemParaDoacaoPorDescricao02() throws Exception {
		InvalidArgumentException ex = assertThrows(InvalidArgumentException.class, () -> {
			controle.pesquisaItemPorDescricao("   ");
		});
		assertEquals("Entrada invalida: texto da pesquisa nao pode ser vazio ou nulo.", ex.getMessage());
		
		InvalidArgumentException ex2 = assertThrows(InvalidArgumentException.class, () -> {
			controle.pesquisaItemPorDescricao("");
		});
		assertEquals("Entrada invalida: texto da pesquisa nao pode ser vazio ou nulo.", ex2.getMessage());
	}
	
	@Test
	@DisplayName("Testando pesquisar um item cadastrado")
	void testPesquisaItemParaDoacaoPorDescricao03() throws Exception {
		controle.adicionaItem("12345678901", "ps5", 1, "legitimo, nao eh pirata");
		assertEquals("1 - ps5, tags: [legitimo,  nao eh pirata], quantidade: 1", controle.pesquisaItemPorDescricao("ps5"));
	}
	
	@Test
	@DisplayName("Testando pesquisar um item cadastrado apos alterar sua quantidade e tags")
	void testPesquisaItemParaDoacaoPorDescricao04() throws Exception {
		controle.adicionaItem("12345678901", "biscoito", 6, "napolitano,300g");
		assertEquals("1 - biscoito, tags: [napolitano, 300g], quantidade: 6", controle.pesquisaItemPorDescricao("biscoito"));
		controle.adicionaItem("12345678901", "biscoito", 2, "napolitano,300g");
		assertEquals("1 - biscoito, tags: [napolitano, 300g], quantidade: 2", controle.pesquisaItemPorDescricao("biscoito"));
	}
	
	@Test
	@DisplayName("Testando se o metodo retorna excecao ao tentar dar match com um id vazio")
	void testMatch01() throws Exception {
		InvalidArgumentException iae = assertThrows(InvalidArgumentException.class,() -> {
			
			controle.match("", "1");
		});
		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.",iae.getMessage());
		
		InvalidArgumentException iae2 = assertThrows(InvalidArgumentException.class,() -> {
			
			controle.match("       ", "1");
		});
		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.",iae2.getMessage());
	}
	
	@Test
	@DisplayName("Testando se o metodo retorna excecao ao tentar dar match com um id nulo")
	void testMatch02() throws Exception {
		InvalidArgumentException iae = assertThrows(InvalidArgumentException.class,() -> {
			
			controle.match(null, "1");
		});
		assertEquals("Entrada invalida: id do usuario nao pode ser vazio ou nulo.",iae.getMessage());
	}
	
	@Test
	@DisplayName("Testando se o metodo retorna excecao ao tentar dar match com um id nao existente")
	void testMatch03() throws Exception {
		InvalidUserException iue = assertThrows(InvalidUserException.class,() -> {
			
			controle.match("11111111111", "1");
		});
		assertEquals("Usuario nao encontrado: 11111111111.",iue.getMessage());
	}
	
	@Test
	@DisplayName("Testando se o metodo retorna excecao ao tentar dar match com um id de um doador")
	void testMatch04() throws Exception {
		NullPointerException npe = assertThrows(NullPointerException.class,() -> {
			
			controle.match("12345678901", "1");
		});
		assertEquals("O Usuario deve ser um receptor: 12345678901.",npe.getMessage());
	}
	
	@Test
	@DisplayName("Testando se o metodo retorna excecao ao tentar dar match com um id de item negativo")
	void testMatch05() throws Exception {
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,() -> {
			
			controle.match("98624406000140", "-1");
		});
		assertEquals("Entrada invalida: id do item nao pode ser negativo.", iae.getMessage());
	}
	
	@Test
	@DisplayName("Testando se o metodo retorna excecao ao tentar dar match com um id de item nao cadastrado")
	void testMatch06() throws Exception {
		NullPointerException npe = assertThrows(NullPointerException.class,() -> {
			
			controle.match("98624406000140", "23");
		});
		assertEquals("Item nao encontrado: 23.", npe.getMessage());
	}
	
	@Test
	@DisplayName("Testando se o metodo retorna os matches corretamente")
	void testMatch07() throws Exception {
		controle.adicionaItem("99999999999", "computador", 5, "dell,vermelho");
		controle.adicionaItem("12345678901", "computador", 2, "dell,preto");
		controle.adicionaItem("88888888888", "computador", 3, "dell,vermelho");
		
		assertEquals("2 - computador, tags: [dell, preto], quantidade: 2, doador: Mathias/12345678901 |"
				+ " 1 - computador, tags: [dell, vermelho], quantidade: 5, doador: Fulano/99999999999 |"
				+ " 3 - computador, tags: [dell, vermelho], quantidade: 3, doador: Beltrano/88888888888", controle.match("98624406000140", "2"));
	}

	@Test
	@DisplayName("Testando se o metodo retorna os matches corretamente apos alterar quantidades de itens e adicionar mais itens")
	void testMatch08() throws Exception {
		controle.adicionaItem("99999999999", "computador", 5, "dell,vermelho");
		controle.adicionaItem("12345678901", "computador", 2, "dell,preto");
		controle.adicionaItem("88888888888", "computador", 3, "dell,vermelho");
		controle.adicionaItem("88888888888", "computador", 999, "dell,vermelho");
		controle.adicionaItem("99999999999", "computador", 4, "dell,preto");
		
		assertEquals("2 - computador, tags: [dell, preto], quantidade: 2, doador: Mathias/12345678901 |"
				+ " 5 - computador, tags: [dell, preto], quantidade: 4, doador: Fulano/99999999999 |"
				+ " 1 - computador, tags: [dell, vermelho], quantidade: 5, doador: Fulano/99999999999 |"
				+ " 3 - computador, tags: [dell, vermelho], quantidade: 999, doador: Beltrano/88888888888", controle.match("98624406000140", "2"));
	}
	
}
