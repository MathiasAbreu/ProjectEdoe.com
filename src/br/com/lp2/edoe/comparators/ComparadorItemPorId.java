package br.com.lp2.edoe.comparators;

import java.util.Comparator;

import br.com.lp2.edoe.model.Item;

public class ComparadorItemPorId implements Comparator<Item> {

	@Override
	public int compare(Item item01, Item item02) {
		
		return item01.getId().compareTo(item02.getId());
	}

}
