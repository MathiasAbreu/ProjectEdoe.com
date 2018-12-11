/**
 * 
 */
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

/**
 * Classe responsavel pelas manipulacoes de leitura/escrita dos usuarios que possuem itens no sistema.
 * 
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class UsuariosQuePossuemItensDAO {

	private static ObjectOutputStream outputUsuario;
	private static ObjectInputStream inputUsuario;
	
	/**
	 * Construtor default da classe.
	 * 
	 */
	public UsuariosQuePossuemItensDAO() {
		
	}
	
	/**
	 * Metodo responsavel por ler todos os usuarios que possuem itens que estejam armazenados dentro do arquivo.
	 * 
	 * @return Retorna uma colecao com todos os usuarios que possuem itens encontrados no arquivo.
	 * 
	 * @throws FileReadErrorException Excecao gerada caso haja algum erro na leitura do arquivo.
	 * 
	 */
	public static ArrayList<String> lerUsuarios() throws FileReadErrorException {
		
		ArrayList<String> usuarios = new ArrayList<>();
		
		try {
			
			inputUsuario = new ObjectInputStream(Files.newInputStream(Paths.get("src/br/com/lp2/edoe/dao/files/UsuariosQuePossuemItens.ser")));
			
			while(true) {
				
				String usuario = (String) inputUsuario.readObject();
				usuarios.add(usuario);
			}
			
		} catch (IOException ioe) {
			
			return usuarios;
			
		} catch (ClassNotFoundException cnf) {
			
			throw new FileReadErrorException("UsuariosQuePossuemItens.ser");
			
		}
	}
	
	/**
	 * Metodo responsavel pela escrita de todos os usuarios que possuem itens no sistema no arquivo.
	 * 
	 * @param usuarios Recebe uma colecao com todos os usuarios que possuem itens do sistema.
	 * 
	 * @throws FileWriteErrorException Excecao gerada caso haja algum problema no momento na escrita dos 
	 * usuarios que possuem itens no arquivo.
	 * 
	 */
	public static void escreverUsuarios(Collection<String> usuarios) throws FileWriteErrorException {
		
		try {
			
			outputUsuario = new ObjectOutputStream(Files.newOutputStream(Paths.get("src/br/com/lp2/edoe/dao/files/UsuariosQuePossuemItens.ser")));
			
			for(String usuario : usuarios)
				outputUsuario.writeObject(usuario);
			
			outputUsuario.close();
		} catch (IOException ioe) {
			
			return;
			
		} catch (NoSuchElementException nse) {
			
			throw new FileWriteErrorException("UsuariosQuePossuemItens.ser");
			
		}
	}
}
