package br.com.lp2.edoe.dao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;

import br.com.lp2.edoe.exceptions.FileReadErrorException;
import br.com.lp2.edoe.exceptions.FileWriteErrorException;

/**
 * Classe responsavel pelas manipulacoes de leitura/escrita dos descritores do sistema.
 * 
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class DescritoresDAO {
	
	private static ObjectOutputStream outputDescritores;
	private static ObjectInputStream inputDescritores;
	
	/**
	 * Construtor default da classe.
	 * 
	 */
	public DescritoresDAO() {
		
	}
	
	/**
	 * Metodo responsavel por ler todos os descritores que estejam armazenados dentro do arquivo.
	 * 
	 * @return Retorna uma colecao com todos os descritores encontrados no arquivo.
	 * 
	 * @throws FileReadErrorException Excecao gerada caso haja algum erro na leitura do arquivo.
	 * 
	 */
	public static ArrayList<String> lerDescritores() throws FileReadErrorException {
		
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
			
			throw new FileReadErrorException("Descritores.ser");
			
		}
	}
	
	/**
	 * Metodo responsavel pela escrita de todos os descritores do sistema no arquivo.
	 * 
	 * @param descritores Recebe uma colecao com todos os descritores do sistema.
	 * 
	 * @throws FileWriteErrorException Excecao gerada caso haja algum problema no momento na escrita dos 
	 * descritores no arquivo.
	 * 
	 */
	public static void escreverDescritores(HashSet<String> descritores) throws FileWriteErrorException {
		
		try {
			
			outputDescritores = new ObjectOutputStream(Files.newOutputStream(Paths.get("src/br/com/lp2/edoe/dao/files/Descritores.ser")));
			
			for(String descritor : descritores)
				outputDescritores.writeObject(descritor);
			
			outputDescritores.close();
		} catch (IOException ioe) {
			
			return;
			
		} catch (NoSuchElementException nse) {
			
			throw new FileWriteErrorException("Descritores.ser");
		}
	}
}
