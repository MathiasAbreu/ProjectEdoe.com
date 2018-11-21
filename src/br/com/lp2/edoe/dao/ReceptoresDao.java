package br.com.lp2.edoe.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por acessar e realizar a leitura dos arquivos que contém os dados dos Usuários Receptores a serem 
 * cadastrados no sistema.
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 *
 */
public class ReceptoresDao {
	
	/**
	 * Método que recebe o caminho do arquivo a ser lido, lê o determinado arquivo e retorna todos os usuários encontrados 
	 * em concatenação String.
	 * 
	 * @param caminho caminho do arquivo a ser lido
	 * 
	 * @return Retorna um coleção com todos os Usuários lidos.
	 * 
	 */
	public ArrayList<String> lerReceptores(String caminho) {
		
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
	    	
			System.out.println("Erro na abertura do arquivo: " + e.getMessage());
	    }
		
		receptores.remove(0);
		return receptores;
	}
}
