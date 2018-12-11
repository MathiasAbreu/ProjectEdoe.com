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
import br.com.lp2.edoe.model.Doacao;

/**
 * Classe responsavel pelas manipulacoes de leitura/escrita das doacoes do sistema.
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class DoacoesDAO {

	private static ObjectOutputStream outputDoacao;
	private static ObjectInputStream inputDoacao;
	
	/**
	 * Construtor default da classe.
	 * 
	 */
	public DoacoesDAO() {
		
	}
	
	/**
	 * Metodo responsavel por ler todos as doacoes que estejam armazenadas dentro do arquivo.
	 * 
	 * @return Retorna uma colecao com todas as doacoes encontradas no arquivo.
	 * 
	 * @throws FileReadErrorException Excecao gerada caso haja algum erro na leitura do arquivo.
	 * 
	 */
	public static ArrayList<Doacao> lerDoacoes() throws FileReadErrorException {
		
		ArrayList<Doacao> doacoes = new ArrayList<>();
		
		try {
			
			inputDoacao = new ObjectInputStream(Files.newInputStream(Paths.get("src/br/com/lp2/edoe/dao/files/Doacoes.ser")));
			
			while(true) {
				
				Doacao doacao = (Doacao) inputDoacao.readObject();
				doacoes.add(doacao);
			}
			
		} catch (IOException ioe) {
			
			return doacoes;
			
		} catch (ClassNotFoundException cnf) {
			
			throw new FileReadErrorException("Doacoes.ser");
		}
	}
	
	/**
	 * Metodo responsavel pela escrita de todas as doacoes do sistema no arquivo.
	 * 
	 * @param doacoes Recebe uma colecao com todas as doacoes do sistema.
	 * 
	 * @throws FileWriteErrorException Excecao gerada caso haja algum problema no momento na escrita das 
	 * doacoes no arquivo.
	 * 
	 */
	public static void escreverDoacoes(Collection<Doacao> doacoes) throws FileWriteErrorException {
		
		try {
			
			outputDoacao = new ObjectOutputStream(Files.newOutputStream(Paths.get("src/br/com/lp2/edoe/dao/files/Doacoes.ser")));
			
			for(Doacao doacao : doacoes)
				outputDoacao.writeObject(doacao);
			
			outputDoacao.close();
		} catch (IOException ioe) {
			
			return;
			
		} catch (NoSuchElementException nse) {
			
			throw new FileWriteErrorException("Doacoes.ser");
		}
	}
}
