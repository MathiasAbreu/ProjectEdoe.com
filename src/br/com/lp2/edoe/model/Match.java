package br.com.lp2.edoe.model;

/**
 * Classe que representa um match (casamento entre dois itens) no sistema, possui todos os dados necessarios, assim como 
 * os metodos que manipulam e controlam tais dados.
 * 
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class Match {
	
	private Item itemDeReferencia;
	private Item item;
	private int coeficienteDeCombinacao;
	
	/**
	 * Construtor que instancia um novo match, recebendo como parametros, os itens que compoem esse casamento. Tambem 
	 * inicia o calculo do coeficiente de combinacao entre os dois itens.
	 * 
	 * @param itemDeReferencia item de referencia
	 * @param item item que pode ser doado
	 * 
	 */
	public Match(Item itemDeReferencia, Item item) {
		
		this.item = item;
		this.itemDeReferencia = itemDeReferencia;
		
		this.coeficienteDeCombinacao = calculaCoeficiente();
	}

	/**
	 * Método que retorna o Item De Referencia do match.
	 *
	 * @return O itme de referencia do match.
	 * 
	 */
	public Item getItemDeReferencia() {
		return itemDeReferencia;
	}

	/**
	 * Método que retorna o item possivel de doacao do match.
	 *
	 * @return O item que pode ser doado.
	 * 
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * Método que retorna o coeficiente de combinacacao entre os dois itens.
	 * 
	 *
	 * @return O coeficiente de conbinacao dos dois itens.
	 */
	public int getCoeficienteDeCombinacao() {
		return coeficienteDeCombinacao;
	}
	
	private int calculaCoeficiente() {
		
		int coeficienteTemp = 0;
		
		if(itemDeReferencia.getDescritor().equals(item.getDescritor()))
			coeficienteTemp += 20;
		
		if(itemDeReferencia.getTags().length == item.getTags().length) {
			
			for(int i = 0; i < item.getTags().length; i++) {
				if(item.getTags()[i].toLowerCase().equals(itemDeReferencia.getTags()[i].toLowerCase()))
					coeficienteTemp += 10;
				else
					coeficienteTemp += 5;
			}
		}
		else {
			
			for(int i = 0; i < item.getTags().length; i++) {
				if(i < itemDeReferencia.getTags().length) {
					
					if(item.getTags()[i].equals(itemDeReferencia.getTags()[i]))
						coeficienteTemp += 10;
					else
						coeficienteTemp += 5;
				}
			}
		}
		
		return coeficienteTemp;
	}
}
