package br.com.lp2.edoe.model;

import java.time.LocalTime;

public class Item {
	
	private LocalTime dataInsercao;
	private String descritor;
	private String[] tags;
	private String id;
	private int quantidade;
	
	public Item(String descritor, String[] tags, String id, int quantidade) {
		this.dataInsercao = dataInsercao;
		this.descritor = descritor;
		this.tags = tags;
		this.id = id;
		this.quantidade = quantidade;
	}
	
	

}
