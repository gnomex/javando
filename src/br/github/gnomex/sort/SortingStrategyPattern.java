package br.github.gnomex.sort;

import java.util.List;

public interface SortingStrategyPattern {

	public void doSort(List<? extends Comparable<?>> list); 
	
}
