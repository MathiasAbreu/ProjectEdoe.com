package br.com.lp2.edoe.model;

import java.io.Serializable;
import java.util.Arrays;
/**
 * Classe que representa um Item no sistema, contem todos os dados que compoem um item, assim como metodos que administram e 
 * manipulam tais dados.
 * 
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 *
 */
public class Item implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String descritor;
	private String id;
	
	private String[] tags;

	private int quantidade;
	
	/**
	 * Construtor responsavel por instanciar um novo Item, ele recebe todos os dados de um Item como parametro.
	 * 
	 * @param descritor descricao do item
	 * @param tags tags de descricao do item
	 * @param id id unico do item
	 * @param quantidade quantidade disponivel do item
	 * 
	 */
	public Item(String descritor, String[] tags, String id, int quantidade) {
				
		this.descritor = descritor;
		this.tags = tags;
		this.id = id;
		this.quantidade = quantidade;
	}

	/**
	 * Metodo que retorna o Array de tags.
	 * 
	 * @return Retorna o Array de tags do item.
	 */
	public String[] getTags() {
		
		return tags;
	}

	/**
	 * Metodo que altera o Array de tags.
	 * 
	 * @param tags Novo Array de tags.
	 */
	public void setTags(String[] tags) {
		this.tags = tags;
	}

	/**
	 * Metodo que retorna a quantidade de itens.
	 * 
	 * @return A quantidade disponivel de tal item.
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * Metodo que altera a quantidade do tal item.
	 * 
	 * @param quantidade A nova quantidade de itens.
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * Metodo que retorna a descricao do item.
	 * 
	 * @return A descricao do item.
	 */
	public String getDescritor() {
		return descritor;
	}

	/**
	 * Metodo que retorna o Id unico do item.
	 * 
	 * @return Retorna o id do item.
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Metodo responsavel por gerar um numero de identificao que pode ser usado internamente para armazenar o item em 
	 * alguma colecao de armazenamento especifica.
	 * 
	 * @return Retorna o numero usado para armazenar em determinado indice.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descritor == null) ? 0 : descritor.hashCode());
		result = prime * result + Arrays.hashCode(tags);
		return result;
	}

	/**
	 * Metodo que serve para verificar se dois itens sao iguais.
	 * 
	 * @param obj Qualquer tipo de objeto.
	 * 
	 * @return Retorna uma confirmacao ao nao da igualdade entre dois itens.
	 */
	@Override
	public boolean equals(Object obj) {
		
		if(obj.getClass() == Item.class) {
			
			Item other = (Item) obj;
			
			if(this.descritor.equals(other.getDescritor())) {
				
				if(this.tags.length != other.tags.length)
					return false;
				
				for(int i = 0; i < tags.length; i++) {
					
					if(tags[i].equals(other.tags[i])) {
						
					}
					else
						return false;
				}
				
				return true;
			}
		}
		
		return false;
		
	}

	/**
	 * Metodo que retorna uma representacao textual do item.
	 * 
	 * @return Retorna uma representacao do item.
	 */
	@Override
	public String toString() {

		return String.format("%s - %s, tags: %s, quantidade: %d",this.id,this.descritor,Arrays.toString(tags),this.quantidade);
	}
}
