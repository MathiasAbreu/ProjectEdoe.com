package br.com.lp2.edoe.comparators;

import java.util.Comparator;

import br.com.lp2.edoe.model.Match;

/**
 * Classe utilizada para ordenar matchs de acordo com seu coeficiente de combinacao , esta classe implementa uma inteface que permite 
 * que dois matchs sejam comparados gerando um numero utilizado para ordenar uma colecao de matchs.
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class ComparadorMatch implements Comparator<Match> {
 
	/**
	 * Metodo que compara dois matchs de acordo com seus coneficientes de combinacao, ele recebe os dois matchs como parametro, 
	 * e retorna um inteiro que seja utilizado no criterio de ordenacao.
	 * 
	 * @param match01 primeiro match a ser comparado
	 * @param match02 segundo match a ser comparado
	 * 
	 * @return Retorna um inteiro que sera utilizado como parametro de ordenacao.
	 * 
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
