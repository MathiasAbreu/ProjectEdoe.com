package junit.edoe.tests.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.lp2.edoe.dao.UsuariosQuePossuemItensDAO;
import br.com.lp2.edoe.exceptions.FileReadErrorException;
import br.com.lp2.edoe.exceptions.FileWriteErrorException;

class UsuariosQuePossuemItensDaoTest {

private String usuario;
	
	@BeforeEach
	void setUp() throws Exception {
		
		usuario = "Mathias";
	}

	@Test
	@DisplayName("Testando o construtor de UsuariosQUePossuemItensDao")
	void testConstrutor() {
		
		UsuariosQuePossuemItensDAO usuariosQuePossuemItens = new UsuariosQuePossuemItensDAO();
	}
	
	@Test
	@DisplayName("Testando a persistencia do arquivo que mantem os usuarios que possuem itens, lendo todos os usuarios que possuem itens no sistema")
	void testLeituraUsuarios() throws FileReadErrorException {
			
		ArrayList<String> usersQuePossuemItens = UsuariosQuePossuemItensDAO.lerUsuarios();
		
		assertEquals(false,usersQuePossuemItens.isEmpty());
	}
	
	@Test
	@DisplayName("Testando o metodo que escrever os usuarios que possuem itens no arquivo")
	void testEscreverUsuarios() throws FileWriteErrorException,FileReadErrorException {
		
		ArrayList<String> usuariosQUePossuemDefault = UsuariosQuePossuemItensDAO.lerUsuarios();
		usuariosQUePossuemDefault.add(usuario);
		
		UsuariosQuePossuemItensDAO.escreverUsuarios(usuariosQUePossuemDefault);
		ArrayList<String> retorno = UsuariosQuePossuemItensDAO.lerUsuarios();
		
		assertEquals(true, retorno.contains(usuario));
		
		retorno.remove(usuario);
		UsuariosQuePossuemItensDAO.escreverUsuarios(usuariosQUePossuemDefault);
	}

}
