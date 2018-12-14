package junit.edoe.tests.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.lp2.edoe.dao.DescritoresDAO;
import br.com.lp2.edoe.exceptions.FileReadErrorException;
import br.com.lp2.edoe.exceptions.FileWriteErrorException;

class DescritoresDaoTest {

	private String descritor;
	
	@BeforeEach
	void setUp() throws Exception {
		
		descritor = "cadeira";
	}

	@Test
	@DisplayName("Testando o construtor de DescritoresDao")
	void testConstrutor() {
		
		DescritoresDAO descritorDao = new DescritoresDAO();
	}
	
	@Test
	@DisplayName("Testando a persistencia do arquivo que mantem os descritores, lendo todos os descritores do sistema")
	void testLeituraDescritores() throws FileReadErrorException {
			
		ArrayList<String> descritores = DescritoresDAO.lerDescritores();
		
		assertEquals(false,descritores.isEmpty());
	}
	
	@Test
	@DisplayName("Testando o metodo que escrever os descritores no arquivo")
	void testEscreverDescritores() throws FileWriteErrorException,FileReadErrorException {
		
		ArrayList<String> descritoresDefault = DescritoresDAO.lerDescritores();
		HashSet<String> descritors = new HashSet<>();
		descritoresDefault.add(descritor);
		
		for(String descritor : descritoresDefault)
			descritors.add(descritor);
		
		DescritoresDAO.escreverDescritores(descritors);
		ArrayList<String> retorno = DescritoresDAO.lerDescritores();
		
		assertEquals(true, retorno.contains(descritor));
		
		retorno.remove(descritor);
		DescritoresDAO.escreverDescritores(descritors);
	}

}
