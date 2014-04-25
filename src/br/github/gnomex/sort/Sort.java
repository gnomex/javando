package br.github.gnomex.sort;

import br.github.gnomex.lists.AbstractList;

public interface Sort {

	public AbstractList<?> sort(AbstractList<? extends Comparable<?>> list, int order);
	
}
