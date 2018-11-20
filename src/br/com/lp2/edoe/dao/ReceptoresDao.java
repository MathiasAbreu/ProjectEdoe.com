package br.com.lp2.edoe.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 * 
 */
public class ReceptoresDao {
	
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
