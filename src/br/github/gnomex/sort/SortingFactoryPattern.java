package br.github.gnomex.sort;

import static br.github.gnomex.sort.common.SortDefinitions.*;

import br.github.gnomex.sort.algorithms.Bubble;
import br.github.gnomex.sort.algorithms.Insertion;
import br.github.gnomex.sort.algorithms.Selection;

public class SortingFactoryPattern {

	public static Sort getClass(int algorithm)	{
		switch (algorithm) {
		case BUBBLE:
			return new Bubble(); 
		case SELECTION:
			return new Selection();
		case INSERTION:
			return new Insertion();

		default:
			return null;
		}
	}
	
}
