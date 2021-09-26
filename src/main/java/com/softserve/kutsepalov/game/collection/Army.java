/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 23, 2021 12:08:35 PM
 */
package com.softserve.kutsepalov.game.collection;

import java.util.Deque;
import java.util.LinkedList;

import com.softserve.kutsepalov.game.entity.Unit;

/**
 * @author Max Kutsepalov
 *
 */
public class Army<T extends Unit> {
    private Deque<T> units = new LinkedList<>();
    
    public void addUnit(T unit) {
	units.push(unit);
    }
    
    @SuppressWarnings("deprecation")
    public void addUnit(int amount, Class<? extends T> unit) {
	try {
	    for(int i = 0; i < amount; i++) {		
		units.push(unit.newInstance());
	    }
	} catch (ReflectiveOperationException e) {
	    throw new IllegalStateException("Something wrong with class");
	}
    }
    
    public T removeUnit() {
	return units.pollFirst();
    }
    
    public T peek() {
	return units.peek();
    }
    
    public int size() {
	return units.size();
    }
    
    public boolean isEmpty() {
	return units.isEmpty();
    }
    
}
