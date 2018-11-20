package br.com.lp2.edoe.model;

/**
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * @author Klaywert
 * @author Caio 
 * 
 */
public abstract class Usuario {

	/**
	 * Nome do Usuário.
	 */
	private String nome;
	
	/**
	 * Email do Usuário.
	 */
	private String email;
	
	/**
	 * Número de celular do Usuário.
	 */
	private String celular;
	
	/**
	 * Classe do Usuário.
	 */
	private String classe;
	
	/**
	 * Identificação do Usuário. CPF se for uma pessoa fisica, CNPJ para demais usuários.
	 */
	private String identificacao;
		
	/**
	 * @param nome
	 * @param email
	 * @param celular
	 * @param classe
	 * @param identificacao
	 */
	public Usuario(String nome, String email, String celular, String classe,String identificacao) {
		
		this.nome = nome;
		this.email = email;
		this.celular = celular;
		this.classe = classe;
		this.identificacao = identificacao;
		
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @param celular the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * @return the classe
	 */
	public String getClasse() {
		return classe;
	}

	/**
	 * @return the identificacao
	 */
	public String getIdentificacao() {
		return identificacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificacao == null) ? 0 : identificacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(this.getClass() == obj.getClass()) {
			
			Usuario other = (Usuario) obj;
			
			if(this.identificacao.equals(other.getIdentificacao()))
				return true;
			
		}
		
		return false;
	}
	
	@Override
	public abstract String toString();
	
}
