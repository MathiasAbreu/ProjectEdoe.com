package br.com.lp2.edoe.dao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class DescritoresDAO {
	
	private static ObjectOutputStream outputDescritores;
	private static ObjectInputStream inputDescritores;
	
	public static ArrayList<String> lerDescritores() {
		
		ArrayList<String> descritores = new ArrayList<>();
		
		try {
			
			inputDescritores = new ObjectInputStream(Files.newInputStream(Paths.get("src/br/com/lp2/edoe/dao/files/Descritores.ser")));
			
			while(true) {
				
				String descritor = (String) inputDescritores.readObject();
				descritores.add(descritor);
			}
			
		} catch (IOException ioe) {
			
			return descritores;
			
		} catch (ClassNotFoundException cnf) {
			
			throw new NullPointerException("Erro no arquivo 'Descritores.ser'.");
			
		}
	}
	
	public static void escreverDescritores(Collection<String> descritores) {
		
		try {
			
			outputDescritores = new ObjectOutputStream(Files.newOutputStream(Paths.get("src/br/com/lp2/edoe/dao/files/Descritores.ser")));
			
			for(String descritor : descritores)
				outputDescritores.writeObject(descritor);
			
			outputDescritores.close();
		} catch (IOException ioe) {
			
			return;
			
		} catch (NoSuchElementException nse) {
			
			throw new RuntimeException("Erro ao escrever no arquivo 'Descritores.ser'.");
		}
	}
}
