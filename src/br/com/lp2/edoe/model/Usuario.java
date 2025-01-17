package br.com.lp2.edoe.model;

import java.io.Serializable;

/**
 * Classe que representa um Usuario no sistema, eh uma classe que fornece atributos e metodos 
 * que controlam e manipulam tais dados.
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 *
 */
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String email;
	private String celular;
	private String classe;
	private String identificacao;
	private String status;
	
	/**
	 * Construtor reponsavel por instanciar um novo Usuario, ele recebe todos os parametros necessarios para preencher 
	 * os atributos basicos de um Usuario.
	 * 
	 * @param nome nome do usuario
	 * @param email email do usuario
	 * @param celular celular do usuario
	 * @param classe classe do usuario
	 * @param identificacao numero de identificacao do usuario
	 * 
	 */
	public Usuario(String nome, String email, String celular, String classe,String identificacao,String status) {
		
		this.nome = nome;
		this.email = email;
		this.celular = celular;
		this.classe = classe;
		this.identificacao = identificacao;
		this.status = status;
		
	}

	/**
	 * Metodo que retorna o nome do Usuario.
	 * 
	 * @return O nome do usuario.
	 * 
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo que altera o nome do Usuario.
	 * 
	 * @param nome O novo nome do usuario.
	 * 
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo que retorna o email do Usuario.
	 * 
	 * @return O email do usuario.
	 * 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo que altera o email do Usuario.
	 * 
	 * @param email O novo email do usuario.
	 * 
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Metodo que retorna o celular do Usuario.
	 * 
	 * @return O celular do Usuario.
	 *
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * Metodo que altera o celular do Usuario.
	 * 
	 * @param celular O novo celular do Usuario.
	 * 
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * Metodo que retorna a classe do Usuario.
	 * 
	 * @return A classe do Usuario.
	 * 
	 */
	public String getClasse() {
		return classe;
	}

	/**
	 * Metodo que retorna o numero de identificacao do Usuario.
	 * 
	 * @return O numero de identificacao do Usuario.
	 * 
	 */
	public String getIdentificacao() {
		return identificacao;
	}

	/**
	 * Metodo que retorna o status de um usuario.
	 * 
	 * @return Retorna 'doador' ou 'receptor'.
	 * 
	 */
	public String getStatus() {
		
		if(status.equals("receptor")) {
			return status.substring(0,1).toUpperCase().concat(status.substring(1));
		}
		return status;
	}

	/**
	 * Metodo responsavel por gerar um numero de identificacao que pode ser usado internamente para armazenar o usuario em 
	 * alguma colecao de armazenamento especifica.
	 * 
	 * @return Retorna o numero usado para armazenar em determinado indice.
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificacao == null) ? 0 : identificacao.hashCode());
		return result;
	}

	/**
	 * Metodo responsavel por verificar se dois usuarios sao iguais baseado nos seus documentos de identificacao.
	 * 
	 * @param obj Recebe como parametro qualquer objeto.
	 * 
	 * @return Retorna uma confirmacao ou nao da igualdade entre dois Usuarios.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		
		if(this.getClass() == obj.getClass()) {
			
			Usuario other = (Usuario) obj;
			
			if(this.identificacao.equals(other.getIdentificacao()))
				return true;
			
		}
		
		return false;
	}
	
	/**
	 * Metodo que gera e retorna uma representacao textual do Usuario.
	 * 
	 * @return Retorna a representacao textual do Usuario.
	 * 
	 */
	@Override
	public String toString() {
		
		return String.format("%s/%s, %s, %s, status: %s",getNome(),getIdentificacao(),getEmail(),getCelular(),status);
	}
}