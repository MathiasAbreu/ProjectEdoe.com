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
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class DoacoesDAO {

	private static ObjectOutputStream outputDoacao;
	private static ObjectInputStream inputDoacao;
	
	public DoacoesDAO() {
		
	}
	
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
