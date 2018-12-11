package br.com.lp2.edoe.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import br.com.lp2.edoe.exceptions.FileReadErrorException;
import br.com.lp2.edoe.exceptions.FileWriteErrorException;

/**
 * Classe responsavel por acessar e realizar a leitura dos arquivos que contem os dados dos Usuarios Receptores a serem 
 * cadastrados no sistema.
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 *
 */
public class ReceptoresDAO {
	
	/**
	 * Metodo que recebe o caminho do arquivo a ser lido, le o determinado arquivo e retorna todos os usuarios encontrados 
	 * em concatenacao String.
	 * 
	 * @param caminho caminho do arquivo a ser lido
	 * 
	 * @return Retorna um colecao com todos os Usuarios lidos.
	 * 
	 * @throws IOException Excecao gerada caso haja algum problema na leitura do arquivo.
	 * @throws FileReadErrorException 
	 * 
	 */
	public static ArrayList<String> lerReceptores(String caminho) throws FileReadErrorException {
		
		ArrayList<String> receptores = new ArrayList<>();
		
		try {
			
			FileReader arquivo = new FileReader(caminho);
			BufferedReader lerArquivo = new BufferedReader(arquivo);
	 
			String linha = lerArquivo.readLine();
	
			while (linha != null) {
	        
				receptores.add(linha);
				linha = lerArquivo.readLine();
			}
	 
			arquivo.close();
	      
		} catch (IOException e) {
	    	
			throw new FileReadErrorException("Receptores.csv");
	    }
		
		receptores.remove(0);
		return receptores;
	}
}
