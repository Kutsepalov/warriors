/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 23, 2021 12:08:35 PM
 */
package com.softserve.kutsepalov.game.collection;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

import com.softserve.kutsepalov.game.entity.Lancer;
import com.softserve.kutsepalov.game.entity.Unit;
import com.softserve.kutsepalov.game.entity.Warlord;
import com.softserve.kutsepalov.game.entity.ability.Curer;

/**
 * @author Max Kutsepalov
 *
 */
public class Army<T extends Unit> {
    private Deque<T> units = new LinkedList<>();
    private Warlord lord;
    
    public void addUnit(T unit) {
	if(unit instanceof Warlord) {
	    lord = (Warlord) unit;
	}
	if(unit.isAlive()) {
	    units.add(unit);
	} else {
	    throw new IllegalArgumentException("Unit is dead");
	}
    }
    
    public void addUnit(int amount, Class<? extends T> unit) {
	try {
	    for(int i = 0; i < amount; i++) {		
		addUnit(unit.getDeclaredConstructor().newInstance());
	    }
	} catch (ReflectiveOperationException e) {
	    throw new IllegalStateException("Something wrong with class");
	}
    }
    
    public void moveUnits() {
	Objects.requireNonNull(lord, "Warlord is absent from the army");
	((LinkedList<T>) units).sort((f, s) -> {
	    int res = 0;
	    if(f instanceof Lancer) {	
		res = 1;
	    }
	    if(f instanceof Curer) {
		if(s == this.peek()) {	    
		    res = -1;
		} else {
		    res = 1;
		}
	    }
	    if(f instanceof Warlord) {
		res = -1;
	    }
	    return res;
	});
    }
    
    public T removeUnit() {
	clear();
	return units.poll();
    }
    
    public T peek() {
	clear();
	return units.peek();
    }
    
    public T getUnit(int id) {
	return ((LinkedList<T>) units).get(id);
    }
    
    public int size() {
	clear();
	return units.size();
    }
    
    public boolean isEmpty() {
	boolean res = true;
	if(size() != 0) {
	   res = false; 
	}
	return res;
    }
    
    private void clear() {
	Iterator<T> iterator = units.iterator();
	while(iterator.hasNext()) {
	    T unit = iterator.next();
	    if(!unit.isAlive()) {
		iterator.remove();
	    }
	}
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Army = ");
	builder.append(units);
	return builder.toString();
    }
}
