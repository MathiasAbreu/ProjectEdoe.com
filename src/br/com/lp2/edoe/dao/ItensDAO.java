package br.com.lp2.edoe.dao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

import br.com.lp2.edoe.model.Item;

/**
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class ItensDAO {
	
	private static ObjectOutputStream outputItens;
	private static ObjectInputStream inputItens;
	
	public ItensDAO() {
		
	}
	
	public static ArrayList<Item> lerItens() {
		
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
			
			throw new NullPointerException("Erro no arquivo 'Itens.ser'");
		
		}
	}
	
	public static void escreverItens(Collection<Item> itens) {
		
		try {
			
			outputItens = new ObjectOutputStream(Files.newOutputStream(Paths.get("src/br/com/lp2/edoe/dao/files/Itens.ser")));
			
			for(Item item : itens)
				outputItens.writeObject(item);
			
			outputItens.close();
		} catch (IOException ioe) {
			
			return;
			
		} catch (NoSuchElementException nse) {
			
			throw new RuntimeException("Erro ao escrever item!");
		}
	}
}
