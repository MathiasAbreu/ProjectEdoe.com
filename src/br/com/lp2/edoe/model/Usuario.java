package br.com.lp2.edoe.model;

/**
 * Classe que representa uma abstração de um Usuário no sistema, é uma classe básica que fornece atributos e métodos 
 * básicos para as classes especializadas deste mesmo tipo de Usuario.
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
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
	 * Construtor reponsável por instanciar um novo Usuario, ele recebe todos os parâmetros necessários para preencher 
	 * os atributos básicos de um Usuario.
	 * 
	 * @param nome nome do usuário
	 * @param email email do usuário
	 * @param celular celular do usuário
	 * @param classe classe do usuário
	 * @param identificacao número de identificação do usuário
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
	 * Método que retorna o nome do Usuário.
	 * 
	 * @return O nome do usuário.
	 * 
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método que altera o nome do Usuário.
	 * 
	 * @param nome O novo nome do usuário.
	 * 
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método que retorna o email do Usuário.
	 * 
	 * @return O email do usuário.
	 * 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Método que altera o email do Usuário.
	 * 
	 * @param email O novo email do usuário.
	 * 
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Método que retorna o celular do Usuário.
	 * 
	 * @return O celular do Usuário.
	 *
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * Método que altera o celular do Usuário.
	 * 
	 * @param celular O novo celular do Usuário.
	 * 
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * Método que retorna a classe do Usuário.
	 * 
	 * @return A classe do Usuário.
	 * 
	 */
	public String getClasse() {
		return classe;
	}

	/**
	 * Método que retorna o número de identificação do Usuário.
	 * 
	 * @return O número de identificação do Usuário.
	 * 
	 */
	public String getIdentificacao() {
		return identificacao;
	}

	/**
	 * Método que retorna o status do Usuário.
	 * 
	 * @return O status do Usuário.
	 * 
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Método responsável por gerar um número de identificação que pode ser usado internamente para armazenar o usuário em 
	 * alguma coleção de armazenamento especifica.
	 * 
	 * @return Retorna o número usado para armazenar em determinado indice.
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
	 * Método responsável por verificar se dois usuários são iguais baseado nos seus documentos de identificação.
	 * 
	 * @param obj Recebe como parametro qualquer objeto.
	 * 
	 * @return Retorna uma confirmação ou não da igualdade entre dois Usuários.
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
	 * Método que gera e retorna uma representação textual do Usuário.
	 * 
	 * @return Retorna a representação textual do Usuário.
	 * 
	 */
	@Override
	public String toString() {
		
		return String.format("%s/%s, %s, %s, status: %s",nome,formatarId(identificacao),email,celular,status);
	}
	
}
