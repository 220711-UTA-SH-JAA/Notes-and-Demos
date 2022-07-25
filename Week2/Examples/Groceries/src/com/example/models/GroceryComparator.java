package com.example.models;

import java.util.Comparator;

/*
 * Comparator
 * Is an interface that defines the total ordering on some collection of objects
 * - Typically used by sorted/prioritized datastructures
 */
public class GroceryComparator implements Comparator<GroceryItem>{

	@Override
	public int compare(GroceryItem o1, GroceryItem o2) {
		
		if(o1.getValue() < o2.getValue()) {
			return 1;
		}
		
		if(o1.getValue() > o2.getValue()) {
			return -1;
		}
		
		return 0;
	}
	

}
