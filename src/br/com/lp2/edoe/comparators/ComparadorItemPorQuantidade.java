package br.com.lp2.edoe.comparators;

import java.util.Comparator;

import br.com.lp2.edoe.model.Item;

/**
 * Classe utilizada para ordenar itens de acordo com sua quantidade, esta classe implementa uma inteface que permite 
 * que dois itens sejam comparados gerando um numero utilizado para ordenar uma coleção de itens.
 * 
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class ComparadorItemPorQuantidade implements Comparator<Item> {

	/**
	 * Metodo que compara dois itens de acordo com sua quantidade, ele recebe os dois itens como parametro, 
	 * e retorna um inteiro que seja utilizado no criterio de ordenacao.
	 * 
	 * @param item01 primeiro item a ser comparado
	 * @param item02 segundo item a ser comparado
	 * 
	 * @return Retorna um inteiro que sera utilizado como criterio de ordenacao.
	 * 
	 */
	@Override
	public int compare(Item item01, Item item02) {
		
		if(item01.getQuantidade() < item02.getQuantidade())
			return 1;
		
		if(item01.getQuantidade() > item02.getQuantidade())
			return -1;
		
		return item01.getDescritor().compareTo(item02.getDescritor());
	}
}