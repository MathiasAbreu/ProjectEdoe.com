/**
 * 
 */
package br.com.lp2.edoe.comparators;

import java.util.Comparator;

import br.com.lp2.edoe.model.Doacao;

/**
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class ComparadorDoacao implements Comparator<Doacao> {

	@Override
	public int compare(Doacao doacao01, Doacao doacao02) {

		String[] data01 = doacao01.getData().split("/");
		String[] data02 = doacao02.getData().split("/");
		
		int numero = String.format("%s%s%s",data01[2],data01[1],data01[0]).compareTo(String.format("%s%s%s",data02[2],data02[1],data02[0]));
		
		if(numero == 0) {
			
			return doacao01.getItem().compareTo(doacao02.getItem());
		}
		
		return numero;
	}

}
