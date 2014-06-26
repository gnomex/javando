package br.github.gnomex.sort;

import java.util.List;

public interface SortingStrategyPattern {

	public <T extends Comparable<? super T >> List <T> sort( List<T> list );
	
}
