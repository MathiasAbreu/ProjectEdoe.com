package br.com.lp2.edoe.model;

import java.time.LocalDate;
import java.util.Arrays;
/**
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 *
 */
public class Item {
	
	private String dataInsercao;
	private String descritor;
	private String id;
	
	private String[] tags;

	private int quantidade;
	
	public Item(String descritor, String[] tags, String id, int quantidade) {
		
		this.dataInsercao = String.format("%d/%d/%d",LocalDate.now().getDayOfMonth(),LocalDate.now().getMonthValue(),LocalDate.now().getYear());
		
		this.descritor = descritor;
		this.tags = tags;
		this.id = id;
		this.quantidade = quantidade;
	}

	/**
	 * @return the tags
	 */
	public String[] getTags() {
		
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(String[] tags) {
		this.tags = tags;
	}

	/**
	 * @return the quantidade
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return the dataInsercao
	 */
	public String getDataInsercao() {
		return dataInsercao;
	}

	/**
	 * @return the descritor
	 */
	public String getDescritor() {
		return descritor;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descritor == null) ? 0 : descritor.hashCode());
		result = prime * result + Arrays.hashCode(tags);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
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
	 * 
	 */
	@Override
	public String toString() {
		System.out.println("entrou");
		return String.format("%s - %s, tags: %s, quantidade: %d",this.id,this.descritor,Arrays.toString(tags),this.quantidade);
	}

}
