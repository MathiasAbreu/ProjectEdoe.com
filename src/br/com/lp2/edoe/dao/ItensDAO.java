package br.com.lp2.edoe.dao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

import br.com.lp2.edoe.exceptions.FileReadErrorException;
import br.com.lp2.edoe.exceptions.FileWriteErrorException;
import br.com.lp2.edoe.model.Item;

/**
 * Classe responsavel pelas manipulacoes de leitura/escrita dos itens do sistema.
 * 
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class ItensDAO {
	
	private static ObjectOutputStream outputItens;
	private static ObjectInputStream inputItens;
	
	/**
	 * Construtor default da classe.
	 * 
	 */
	public ItensDAO() {
		
	}
	
	/**
	 * Metodo responsavel por ler todos os itens que estejam armazenados dentro do arquivo.
	 * 
	 * @return Retorna uma colecao com todos os itens encontrados no arquivo.
	 * 
	 * @throws FileReadErrorException Excecao gerada caso haja algum erro na leitura do arquivo.
	 * 
	 */
	public static ArrayList<Item> lerItens() throws FileReadErrorException {
		
		ArrayList<Item> itens = new ArrayList<>();
		
		try {
			
			inputItens = new ObjectInputStream(Files.newInputStream(Paths.get("src/br/com/lp2/edoe/dao/files/Itens.ser")));

			while(true) {
				
				Item item = (Item) inputItens.readObject();
				itens.add(item);
			}
			
		} catch (IOException ioe) {
			
			return itens;
		
		} catch (ClassNotFoundException cnf) {
			
			throw new FileReadErrorException("Itens.ser");
		
		}
	}
	
	/**
	 * Metodo responsavel pela escrita de todos os itens do sistema no arquivo.
	 * 
	 * @param itens Recebe uma colecao com todos os itens do sistema.
	 * 
	 * @throws FileWriteErrorException Excecao gerada caso haja algum problema no momento na escrita dos 
	 * itens no arquivo.
	 * 
	 */
	public static void escreverItens(Collection<Item> itens) throws FileWriteErrorException {
		
		try {
			
			outputItens = new ObjectOutputStream(Files.newOutputStream(Paths.get("src/br/com/lp2/edoe/dao/files/Itens.ser")));
			
			for(Item item : itens)
				outputItens.writeObject(item);
			
			outputItens.close();
		} catch (IOException ioe) {
			
			return;
			
		} catch (NoSuchElementException nse) {
			
			throw new FileWriteErrorException("Itens.ser");
		}
	}
}
