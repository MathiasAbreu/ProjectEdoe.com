/**
 * 
 */
package br.com.lp2.edoe.controller;

import java.util.HashMap;
import java.util.Map;

import br.com.lp2.edoe.model.Usuario;
import br.com.lp2.edoe.model.UsuarioDoador;

/**
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * @author Klaywert
 * @author Caio
 * 
 */
public class ControllerUsuario {

	private Map<String,Usuario> usuarios;
	
	public ControllerUsuario() {
		
		usuarios = new HashMap<>();
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

	/**
	 * @param id
	 * @return
	 */
	public String buscarUsuarioPorId(String id) {
		// TODO Auto-generated method stub
		return null;
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
	public String lerReceptores(String caminho) {
		// TODO Auto-generated method stub
		return null;
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
