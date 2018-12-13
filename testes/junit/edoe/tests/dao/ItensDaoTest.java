package junit.edoe.tests.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.lp2.edoe.dao.ItensDAO;
import br.com.lp2.edoe.exceptions.FileReadErrorException;
import br.com.lp2.edoe.exceptions.FileWriteErrorException;
import br.com.lp2.edoe.model.Item;

class ItensDaoTest {

	private Item item = new Item("camisa","camisa,branca,pequena".split(","),"1",6);
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@DisplayName("Testando o construtor de ItensDao")
	void testConstrutor() {
		
		ItensDAO itensDao = new ItensDAO();
	}
	
	@Test
	@DisplayName("Testando a persistencia do arquivo que mantem os itens, lendo todos os itens do sistema")
	void testLeituraUsuarios() throws FileReadErrorException {
			
		ArrayList<Item> itens = ItensDAO.lerItens();
		
		assertEquals(false,itens.isEmpty());
	}
	
	@Test
	@DisplayName("Testando o metodo que escrever os itens no arquivo")
	void testEscreverUsuarios() throws FileWriteErrorException,FileReadErrorException {
		
		ArrayList<Item> itensDefault = ItensDAO.lerItens();
		itensDefault.add(item);
		
		ItensDAO.escreverItens(itensDefault);
		ArrayList<Item> retorno = ItensDAO.lerItens();
		
		ItensDAO.escreverItens(itensDefault);
	}

}
