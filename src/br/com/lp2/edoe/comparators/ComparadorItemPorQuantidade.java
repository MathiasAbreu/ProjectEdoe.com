/**
 * 
 */
package br.com.lp2.edoe.comparators;

import java.util.Comparator;

import br.com.lp2.edoe.model.Item;

/**
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class ComparadorItemPorQuantidade implements Comparator<Item> {

	@Override
	public int compare(Item item01, Item item02) {
		
		if(item01.getQuantidade() < item02.getQuantidade())
			return -1;
		
		if(item01.getQuantidade() > item02.getQuantidade())
			return 1;
		
		return 0;
	}
}
