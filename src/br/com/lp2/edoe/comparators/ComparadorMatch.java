package br.com.lp2.edoe.comparators;

import java.util.Comparator;

import br.com.lp2.edoe.model.Match;

/**
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class ComparadorMatch implements Comparator<Match> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Match match01, Match match02) {
		
		if(match01.getCoeficienteDeCombinacao() > match02.getCoeficienteDeCombinacao())
			return -1;
		
		if(match01.getCoeficienteDeCombinacao() < match02.getCoeficienteDeCombinacao())
			return 1;
		
		return match01.getItem().getId().compareTo(match02.getItem().getId());
	}

}
