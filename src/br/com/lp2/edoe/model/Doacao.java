package br.com.lp2.edoe.model;

/**
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class Doacao {
	
	private String nomeDoador;
	private String idDoDoador;
	
	private String nomeReceptor;
	private String idDoReceptor;
	
	private String data;
	
	private String item;
	private int quantidade;
	
	/**
	 * @param idDoDoador
	 * @param idDoReceptor
	 * @param data
	 * @param item
	 * @param quantidade
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
	 * Método que retorna o idDoDoador
	 *
	 * @return the idDoDoador
	 */
	public String getIdDoDoador() {
		return idDoDoador;
	}
	/**
	 * Método que altera o idDoDoador
	 *
	 * @param idDoDoador the idDoDoador to set
	 */
	public void setIdDoDoador(String idDoDoador) {
		this.idDoDoador = idDoDoador;
	}
	/**
	 * Método que retorna o idDoReceptor
	 *
	 * @return the idDoReceptor
	 */
	public String getIdDoReceptor() {
		return idDoReceptor;
	}
	/**
	 * Método que altera o idDoReceptor
	 *
	 * @param idDoReceptor the idDoReceptor to set
	 */
	public void setIdDoReceptor(String idDoReceptor) {
		this.idDoReceptor = idDoReceptor;
	}
	/**
	 * Método que retorna o data
	 *
	 * @return the data
	 */
	public String getData() {
		return data;
	}
	/**
	 * Método que altera o data
	 *
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}
	/**
	 * Método que retorna o item
	 *
	 * @return the item
	 */
	public String getItem() {
		return item;
	}
	/**
	 * Método que altera o item
	 *
	 * @param item the item to set
	 */
	public void setItem(String item) {
		this.item = item;
	}
	/**
	 * Método que retorna o quantidade
	 *
	 * @return the quantidade
	 */

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return String.format("%s - doador: %s/%s, item: %s, quantidade: %d, receptor: %s/%s",data,nomeDoador,idDoDoador,item,quantidade,nomeReceptor,idDoReceptor);
	}
	
	
}
