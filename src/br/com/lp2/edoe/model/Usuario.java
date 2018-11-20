package br.com.lp2.edoe.model;

/**
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * @author Klaywert
 * @author Caio 
 * 
 */
public abstract class Usuario {

	private String nome;
	private String email;
	private String celular;
	private String classe;
	private String identificacao;
	
	private String status;
		
	/**
	 * @param nome
	 * @param email
	 * @param celular
	 * @param classe
	 * @param identificacao
	 */
	public Usuario(String nome, String email, String celular, String classe,String identificacao,String status) {
		
		this.nome = nome;
		this.email = email;
		this.celular = celular;
		this.classe = classe;
		this.identificacao = formatarId(identificacao);
		this.status = status;
		
	}

	private String formatarId(String id) {
		
		String[] separaId = id.split("");
		
		if(separaId.length == 11) {
			
			return String.format("%s%s%s.%s%s%s.%s%s%s-%s%s",separaId[0],separaId[1],separaId[2],separaId[3],separaId[4],separaId[5],separaId[6],separaId[7],separaId[8],separaId[9],separaId[10]);
		}
		else {
			
			return String.format("%s%s.%s%s%s.%s%s%s/%s%s%s%s-%s%s",separaId[0],separaId[1],separaId[2],separaId[3],separaId[4],separaId[5],separaId[6],separaId[7],separaId[8],separaId[9],separaId[10],separaId[11],separaId[12],separaId[13]);
		}
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

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
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
	public String toString() {
		
		return String.format("%s/%s, %s, %s, status: %s",nome,identificacao,email,celular,status);
	}
	
}
