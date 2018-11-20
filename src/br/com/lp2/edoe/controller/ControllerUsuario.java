/**
 * 
 */
package br.com.lp2.edoe.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.lp2.edoe.dao.ReceptoresDao;
import br.com.lp2.edoe.model.Usuario;
import br.com.lp2.edoe.model.UsuarioDoador;
import br.com.lp2.edoe.model.UsuarioReceptor;

/**
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * @author Klaywert
 * @author Caio
 * 
 */
public class ControllerUsuario {

	private Map<String,Usuario> usuarios;
	private ReceptoresDao arquivoReceptores;
	
	public ControllerUsuario() {
		
		usuarios = new HashMap<>();
		arquivoReceptores = new ReceptoresDao();
	}
	
	/**
	 * @param id
	 * @param nome
	 * @param email
	 * @param celular
	 * @param classe
	 * @return
	 */
	public String adicionarDoador(String id, String nome, String email, String celular, String classe) {
		
		if(id == null || id.trim().isEmpty())
			throw new RuntimeException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		
		if(usuarios.containsKey(id)) {
			
			throw new NullPointerException("Usuario ja existente: " + id + ".");
		}
		else {
			
			if(nome == null || nome.trim().isEmpty())
				throw new RuntimeException("Entrada invalida: nome nao pode ser vazio ou nulo.");
			if(email == null || email.trim().isEmpty())
				throw new RuntimeException("Entrada invalida: email nao pode ser vazio ou nulo.");
			if(celular == null || celular.trim().isEmpty())
				throw new RuntimeException("Entrada invalida: celular nao pode ser vazio ou nulo.");
			if(classe == null || classe.trim().isEmpty())
				throw new RuntimeException("Entrada invalida: classe nao pode ser vazia ou nula.");
			
			if(classe.equals("PESSOA_FISICA") || classe.equals("IGREJA") || classe.equals("ORGAO_PUBLICO_ESTADUAL") || classe.equals("ORGAO_PUBLICO_FEDERAL") || classe.equals("ONG") || classe.equals("ASSOCIACAO") || classe.equals("SOCIEDADE")) {
				
				usuarios.put(id, new UsuarioDoador(nome, email, celular, classe, id));
				return id;
			}
			
			throw new IllegalArgumentException("Entrada invalida: opcao de classe invalida.");
		}
	}
	
	private void adicionarReceptores(ArrayList<String> receptores) {
		
		for (String receptor : receptores) {
			
			String[] dados = receptor.split(",");
			usuarios.put(dados[0],new UsuarioReceptor(dados[1],dados[2],dados[3],dados[4],dados[0]));
		}
	}

	/**
	 * @param id
	 * @return
	 */
	public String buscarUsuarioPorId(String id) {
		
		if(id == null || id.trim().isEmpty())
			throw new RuntimeException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		
		if(usuarios.containsKey(id)) {
			
			return usuarios.get(id).toString();
		}
		else
			throw new RuntimeException("Usuario nao encontrado: " + id + ".");
	}

	/**
	 * @param nome
	 * @return
	 */
	public String buscarUsuarioPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param caminho
	 * @return
	 */
	public void lerReceptores(String caminho) {
		
		ArrayList<String> receptores = arquivoReceptores.lerReceptores(caminho);
		
		adicionarReceptores(receptores);
		
	}

	/**
	 * @param id
	 * @param nome
	 * @param email
	 * @param celular
	 * @return
	 */
	public void atualizaUsuario(String id, String nome, String email, String celular) {
		// TODO Auto-generated method stub
	}

	/**
	 * @param id
	 */
	public void removeUsuario(String id) {
		// TODO Auto-generated method stub
		
	}

}
