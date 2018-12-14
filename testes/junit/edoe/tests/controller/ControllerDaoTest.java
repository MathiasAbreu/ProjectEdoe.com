package junit.edoe.tests.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.lp2.edoe.controller.ControllerDao;
import br.com.lp2.edoe.exceptions.FileReadErrorException;
import br.com.lp2.edoe.exceptions.FileWriteErrorException;
import br.com.lp2.edoe.model.Doacao;
import br.com.lp2.edoe.model.Item;
import br.com.lp2.edoe.model.Usuario;

class ControllerDaoTest {

	private Usuario usuario;
	private String descritor;
	private Doacao doacao;
	private Item item;
	private String usuarioPossuiItem;
	
	private ControllerDao controleDao;
	
	@BeforeEach
	void setUp() throws Exception {
		
		usuario = new Usuario("99999999999","Fulano","fulano@gmail.com","68545354","PESSOA_FISICA","receptor");
		descritor = "cadeira";
		doacao = new Doacao("Mathias", "1234567890", "Caio", "0987654321","12/12/2012","Livro Java", 18);
		item = new Item("camisa","camisa,branca,pequena".split(","),"1",6);
		usuarioPossuiItem = "Mat";
		
		controleDao = new ControllerDao();
	}
	
	@Test
	@DisplayName("Testando a persistencia do arquivo que mantem os usuarios, lendo todos os usuarios do sistema")
	void testLeituraUsuarios() throws FileReadErrorException {
			
		ArrayList<Usuario> usuarios = controleDao.lerUsuarios();
		
		assertEquals(false,usuarios.isEmpty());
	}
	
	@Test
	@DisplayName("Testando o metodo que escrever os usuarios no arquivo")
	void testEscreverUsuarios() throws FileWriteErrorException,FileReadErrorException {
		
		ArrayList<Usuario> usersDefault = controleDao.lerUsuarios();
		usersDefault.add(usuario);		
		controleDao.escreverUsuarios(usersDefault);
		ArrayList<Usuario> retorno = controleDao.lerUsuarios();
		
		assertEquals(true, retorno.contains(usuario));
		
		usersDefault.remove(usuario);
		controleDao.escreverUsuarios(usersDefault);
	}

	@Test
	@DisplayName("Testando a persistencia do arquivo que mantem os descritores, lendo todos os descritores do sistema")
	void testLeituraDescritores() throws FileReadErrorException {
			
		ArrayList<String> descritores = controleDao.lerDescritores();
		
		assertEquals(false,descritores.isEmpty());
	}
	
	@Test
	@DisplayName("Testando o metodo que escrever os descritores no arquivo")
	void testEscreverDescritores() throws FileWriteErrorException,FileReadErrorException {
		
		ArrayList<String> descritoresDefault = controleDao.lerDescritores();
		HashSet<String> descritors = new HashSet<>();
		descritoresDefault.add(descritor);
		
		for(String descritor : descritoresDefault)
			descritors.add(descritor);
		
		controleDao.escreverDescritores(descritors);
		ArrayList<String> retorno = controleDao.lerDescritores();
		
		assertEquals(true, retorno.contains(descritor));
		
		retorno.remove(descritor);
		controleDao.escreverDescritores(descritors);
	}
	
	@Test
	@DisplayName("Testando a persistencia do arquivo que mantem as doacoes, lendo todas as doacoes do sistema")
	void testLeituraDoacoes() throws FileReadErrorException {
			
		ArrayList<Doacao> descritores = controleDao.lerDoacoes();
		
		assertEquals(false,descritores.isEmpty());
	}
	
	@Test
	@DisplayName("Testando o metodo que escrever as doacoes no arquivo")
	void testEscreverDoacoes() throws FileWriteErrorException,FileReadErrorException {
		
		ArrayList<Doacao> doacoesDefault = controleDao.lerDoacoes();
		doacoesDefault.add(doacao);
		
		controleDao.escreverDoacoes(doacoesDefault);
		ArrayList<Doacao> retorno = controleDao.lerDoacoes();
		
		assertEquals(false, retorno.contains(doacao));
		
		retorno.remove(doacao);
		controleDao.escreverDoacoes(doacoesDefault);
	}

	@Test
	@DisplayName("Testando a persistencia do arquivo que mantem os itens, lendo todos os itens do sistema")
	void testLeituraItens() throws FileReadErrorException {
			
		ArrayList<Item> itens = controleDao.lerItens();
		
		assertEquals(false,itens.isEmpty());
	}
	
	@Test
	@DisplayName("Testando o metodo que escrever os itens no arquivo")
	void testEscreverItens() throws FileWriteErrorException,FileReadErrorException {
		
		ArrayList<Item> itensDefault = controleDao.lerItens();
		itensDefault.add(item);
		
		controleDao.escreverItens(itensDefault);
		ArrayList<Item> retorno = controleDao.lerItens();
		
		controleDao.escreverItens(itensDefault);
	}
	
	@Test
	@DisplayName("Testando a persistencia do arquivo que mantem os usuarios que possuem itens, lendo todos os usuarios que possuem itens no sistema")
	void testLeituraUsuariosQuePosssuemItens() throws FileReadErrorException {
			
		ArrayList<String> usersQuePossuemItens = controleDao.lerUsuariosQuePossuemItens();
		
		assertEquals(false,usersQuePossuemItens.isEmpty());
	}
	
	@Test
	@DisplayName("Testando o metodo que escrever os usuarios que possuem itens no arquivo")
	void testEscreverUsuariosQuePossuemItens() throws FileWriteErrorException,FileReadErrorException {
		
		ArrayList<String> usuariosQUePossuemDefault = controleDao.lerUsuariosQuePossuemItens();
		usuariosQUePossuemDefault.add(usuarioPossuiItem);
		
		controleDao.escreverUsuariosQuePossuemItens(usuariosQUePossuemDefault);
		ArrayList<String> retorno = controleDao.lerUsuariosQuePossuemItens();
		
		assertEquals(true, retorno.contains(usuarioPossuiItem));
		
		retorno.remove(usuarioPossuiItem);
		controleDao.escreverUsuariosQuePossuemItens(retorno);
	}


}
