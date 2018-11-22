package br.com.lp2.edoe.model;

import java.time.LocalDate;
import java.util.Arrays;

public class Item {
	
	private String dataInsercao;
	private String descritor;
	private String[] tags;
	private String id;
	private int quantidade;
	
	public Item(String descritor, String[] tags, String id, int quantidade) {
		
		this.dataInsercao = String.format("%d/%d/%d",LocalDate.now().getDayOfMonth(),LocalDate.now().getMonthValue() + 1,LocalDate.now().getYear());
		
		this.descritor = descritor;
		this.tags = tags;
		this.id = id;
		this.quantidade = quantidade;
	}

	/**
	 * @return the tags
	 */
	public String getTags() {
		
		return Arrays.toString(tags);
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
	
	

}
