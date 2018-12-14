package junit.edoe.tests.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.lp2.edoe.dao.UsuariosDAO;
import br.com.lp2.edoe.exceptions.FileReadErrorException;
import br.com.lp2.edoe.exceptions.FileWriteErrorException;
import br.com.lp2.edoe.model.Usuario;

class UsuariosDaoTest {

	private Usuario usuario02;
	
	@BeforeEach
	void setUp() throws Exception {
		
		usuario02 = new Usuario("99999999999","Fulano","fulano@gmail.com","68545354","PESSOA_FISICA","receptor");
	
	}

	@Test
	@DisplayName("Testando o construtor de UsuariosDao")
	void testConstrutor() {
		
		UsuariosDAO userDao = new UsuariosDAO();
	}
	
	@Test
	@DisplayName("Testando a persistencia do arquivo que mantem os usuarios, lendo todos os usuarios do sistema")
	void testLeituraUsuarios() throws FileReadErrorException {
			
		ArrayList<Usuario> usuarios = UsuariosDAO.lerUsuarios();
		
		assertEquals(false,usuarios.isEmpty());
	}
	
	@Test
	@DisplayName("Testando o metodo que escrever os usuarios no arquivo")
	void testEscreverUsuarios() throws FileWriteErrorException,FileReadErrorException {
		
		ArrayList<Usuario> usersDefault = UsuariosDAO.lerUsuarios();
		usersDefault.add(usuario02);		
		UsuariosDAO.escreverUsuarios(usersDefault);
		ArrayList<Usuario> retorno = UsuariosDAO.lerUsuarios();
		
		assertEquals(true, retorno.contains(usuario02));
		
		usersDefault.remove(usuario02);
		UsuariosDAO.escreverUsuarios(usersDefault);
	}

}
