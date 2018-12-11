package br.com.lp2.edoe.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import br.com.lp2.edoe.dao.DescritoresDAO;
import br.com.lp2.edoe.dao.DoacoesDAO;
import br.com.lp2.edoe.dao.ItensDAO;
import br.com.lp2.edoe.dao.UsuariosDAO;
import br.com.lp2.edoe.dao.UsuariosQuePossuemItensDAO;
import br.com.lp2.edoe.exceptions.FileReadErrorException;
import br.com.lp2.edoe.exceptions.FileWriteErrorException;
import br.com.lp2.edoe.model.Doacao;
import br.com.lp2.edoe.model.Item;
import br.com.lp2.edoe.model.Usuario;

/**
 * Classe de controle responsavel pelo controle da leitura e escrita de todos os dados do sistema.
 * 
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class ControllerDao {

	/**
	 * Construtor default da classe.
	 * 
	 */
	public ControllerDao() {
		
	}
	
	/**
	 * Metodo responsavel pela leitura de todos os descritores que estavam armazenados em arquivo.
	 * 
	 * @return Retorna uma colecao de todos os descritores armazenados.
	 * 
	 * @throws FileReadErrorException Excecao gerada caso haja algum problema na leitura do arquivo.
	 * 
	 */
	public ArrayList<String> lerDescritores() throws FileReadErrorException {
		
		return DescritoresDAO.lerDescritores();
	}
	
	/**
	 * Metodo responsavel pela leitura de todos os usuarios que estavam armazenados em arquivo.
	 * 
	 * @return Retorna uma colecao de todos os usuarios armazenados.
	 * 
	 * @throws FileReadErrorException Excecao gerada caso haja algum problema na leitura do arquivo.
	 * 
	 */
	public ArrayList<Usuario> lerUsuarios() throws FileReadErrorException {
		
		return UsuariosDAO.lerUsuarios();
		
	}
	
	/**
	 * Metodo responsavel pela leitura de todos os itens que estavam armazenados em arquivo.
	 * 
	 * @return Retorna uma colecao de todos os itens armazenados.
	 * 
	 * @throws FileReadErrorException Excecao gerada caso haja algum problema na leitura do arquivo.
	 * 
	 */
	public ArrayList<Item> lerItens() throws FileReadErrorException {
		
		return ItensDAO.lerItens();
	}
	
	/**
	 * Metodo responsavel pela leitura de todos os usuarios que possuem itens que estavam armazenados em arquivo.
	 * 
	 * @return Retorna uma colecao de todos os usuarios que possuem itens armazenados.
	 * 
	 * @throws FileReadErrorException Excecao gerada caso haja algum problema na leitura do arquivo.
	 * 
	 */
	public ArrayList<String> lerUsuariosQuePossuemItens() throws FileReadErrorException {
		
		return UsuariosQuePossuemItensDAO.lerUsuarios();
	}
	
	/**
	 * Metodo responsavel pela leitura de todos os registros de doacoes que estavam armazenados em arquivo.
	 * 
	 * @return Retorna uma colecao de todos os registros de doacoes armazenados.
	 * 
	 * @throws FileReadErrorException Excecao gerada caso haja algum problema na leitura do arquivo.
	 * 
	 */
	public ArrayList<Doacao> lerDoacoes() throws FileReadErrorException {
		
		return DoacoesDAO.lerDoacoes();
		
	}
	
	/**
	 * Metodo responsavel pela escrita de todos os descritores do sistema em um arquivo.
	 * 
	 * @param descritores Colecao com todos os descritores do sistema.
	 * 
	 * @throws FileWriteErrorException Excecao gerada caso haja algum erro na escrita de tais dados.
	 * 
	 */
	public void escreverDescritores(HashSet<String> descritores) throws FileWriteErrorException {
		
		DescritoresDAO.escreverDescritores(descritores);
		
	}
	
	/**
	 * Metodo responsavel pela escrita de todos os usuarios do sistema em um arquivo.
	 * 
	 * @param usuarios Colecao com todos os usuarios do sistema.
	 * 
	 * @throws FileWriteErrorException Excecao gerada caso haja algum erro na escrita de tais dados.
	 * 
	 */
	public void escreverUsuarios(Collection<Usuario> usuarios) throws FileWriteErrorException {
		
		UsuariosDAO.escreverUsuarios(usuarios);
	}
	
	/**
	 * Metodo responsavel pela escrita de todos os usuarios que possuem itens do sistema em um arquivo.
	 * 
	 * @param usuarios Colecao com todos os usuarios que possuem itens do sistema.
	 * 
	 * @throws FileWriteErrorException Excecao gerada caso haja algum erro na escrita de tais dados.
	 * 
	 */
	public void escreverUsuariosQuePossuemItens(Collection<String> usuarios) throws FileWriteErrorException {
		
		UsuariosQuePossuemItensDAO.escreverUsuarios(usuarios);
	}
	
	/**
	 * Metodo responsavel pela escrita de todos os itens do sistema em um arquivo.
	 * 
	 * @param itens Colecao com todos os itens do sistema.
	 * 
	 * @throws FileWriteErrorException Excecao gerada caso haja algum erro na escrita de tais dados.
	 * 
	 */
	public void escreverItens(Collection<Item> itens) throws FileWriteErrorException {
		
		ItensDAO.escreverItens(itens);
	}
	
	/**
	 * Metodo responsavel pela escrita de todos as doacoes do sistema em um arquivo.
	 * 
	 * @param doacoes Colecao com todos as doacoes do sistema.
	 * 
	 * @throws FileWriteErrorException Excecao gerada caso haja algum erro na escrita de tais dados.
	 */
	public void escreverDoacoes(Collection<Doacao> doacoes) throws FileWriteErrorException {
		
		DoacoesDAO.escreverDoacoes(doacoes);
	}
}
