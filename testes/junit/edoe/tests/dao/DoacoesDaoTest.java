package junit.edoe.tests.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.lp2.edoe.dao.DoacoesDAO;
import br.com.lp2.edoe.exceptions.FileReadErrorException;
import br.com.lp2.edoe.exceptions.FileWriteErrorException;
import br.com.lp2.edoe.model.Doacao;

class DoacoesDaoTest {

	private Doacao doacao;
	
	@BeforeEach
	void setUp() throws Exception {
		
		doacao = new Doacao("Mathias", "1234567890", "Caio", "0987654321","12/12/2012","Livro Java", 18);
	}

	@Test
	@DisplayName("Testando o construtor de DoacoesDao")
	void testConstrutor() {
		
		DoacoesDAO doacoesDao = new DoacoesDAO();
	}
	
	@Test
	@DisplayName("Testando a persistencia do arquivo que mantem as doacoes, lendo todas as doacoes do sistema")
	void testLeituraDoacoes() throws FileReadErrorException {
			
		ArrayList<Doacao> descritores = DoacoesDAO.lerDoacoes();
		
		assertEquals(false,descritores.isEmpty());
	}
	
	@Test
	@DisplayName("Testando o metodo que escrever as doacoes no arquivo")
	void testEscreverDoacoes() throws FileWriteErrorException,FileReadErrorException {
		
		ArrayList<Doacao> doacoesDefault = DoacoesDAO.lerDoacoes();
		doacoesDefault.add(doacao);
		
		DoacoesDAO.escreverDoacoes(doacoesDefault);
		ArrayList<Doacao> retorno = DoacoesDAO.lerDoacoes();
		
		assertEquals(false, retorno.contains(doacao));
		
		retorno.remove(doacao);
		DoacoesDAO.escreverDoacoes(doacoesDefault);
	}

}
