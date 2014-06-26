package br.github.gnomex.sort.algorithms;

import java.util.Collections;
import java.util.List;

import br.github.gnomex.sort.SortingStrategyPattern;

public class Magic implements SortingStrategyPattern{

	@Override
	public <T extends Comparable<? super T>> List<T> sort(List<T> list) {
		Collections.sort(list);
		
		return list;
	}

}
