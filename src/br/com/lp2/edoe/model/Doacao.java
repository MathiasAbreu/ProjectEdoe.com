package br.com.lp2.edoe.model;

import java.io.Serializable;

/**
 * Classe que representa uma doacao no sistema, ela contem todos os dados basicos de uma doacao, assim como metodos que 
 * controlam e manipulam tais dados. 
 * 
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class Doacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nomeDoador;
	private String idDoDoador;
	
	private String nomeReceptor;
	private String idDoReceptor;
	
	private String data;
	
	private String item;
	private int quantidade;
	
	/**
	 * Construtor que inicializa uma nova doacao, recebe todos os dados necessarios de uma doacao.
	 * 
	 * @param idDoDoador id do doador do item
	 * @param idDoReceptor id do receptor do item
	 * @param data data da doacao
	 * @param item id do item que foi doado
	 * @param quantidade quantidade doada
	 * 
	 */
	public Doacao(String nomeDoador,String idDoDoador,String nomeReceptor,String idDoReceptor, String data, String item, int quantidade) {

		this.nomeDoador = nomeDoador;
		this.idDoDoador = idDoDoador;
		
		this.nomeReceptor = nomeReceptor;
		this.idDoReceptor = idDoReceptor;
		
		this.data = data;
		
		this.item = item;
		this.quantidade = quantidade;
	}
	
	/**
	 * Método que retorna o nome do Doador.
	 *
	 * @return O nome do Doador.
	 */
	public String getNomeDoador() {
		return nomeDoador;
	}

	/**
	 * Método que retorna o nome do Receptor.
	 *
	 * @return O nome do Receptor.
	 */
	public String getNomeReceptor() {
		return nomeReceptor;
	}

	/**
	 * Metodo que retorna o Id do Doador.
	 *
	 * @return O id do doador.
	 * 
	 */
	public String getIdDoDoador() {
		return idDoDoador;
	}
	
	/**
	 * Metodo que retorna o Id do Receptor.
	 *
	 * @return O id do receptor.
	 * 
	 */
	public String getIdDoReceptor() {
		return idDoReceptor;
	}
	
	/**
	 * Metodo que retorna a data da doacao.
	 *
	 * @return A data da doacao.
	 * 
	 */
	public String getData() {
		return data;
	}
	
	/**
	 * Metodo que retorna o id do item doado.
	 *
	 * @return O id do item doado.
	 * 
	 */
	public String getItem() {
		return item;
	}
	
	/**
	 * Metodo que retorna a quantidade doada.
	 *
	 * @return A quantidade doada.
	 * 
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * Metodo que retorna uma representacao textual com todos os dados da doacao.
	 * 
	 * @return Retorna uma representacao textual da doacao.
	 * 
	 */
	@Override
	public String toString() {
		
		return String.format("%s - doador: %s/%s, item: %s, quantidade: %d, receptor: %s/%s",data,nomeDoador,idDoDoador,item,quantidade,nomeReceptor,idDoReceptor);
	}
	
	
}
