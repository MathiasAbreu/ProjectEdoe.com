package br.com.lp2.edoe.model;

import java.util.Arrays;

/**
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
	
	public Match(Item itemDeReferencia, Item item) {
		
		this.item = item;
		this.itemDeReferencia = itemDeReferencia;
		
		this.coeficienteDeCombinacao = calculaCoeficiente();
	}

	/**
	 * Método que retorna o item
	 *
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * Método que retorna o coeficienteDeCombinacao
	 *
	 * @return the coeficienteDeCombinacao
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
