/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 23, 2021 12:08:35 PM
 */
package com.softserve.kutsepalov.game.platoon;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.softserve.kutsepalov.game.entity.Unit;
import com.softserve.kutsepalov.game.entity.ability.Fighter;
import com.softserve.kutsepalov.game.entity.ability.Warlord;

/**
 * @author Max Kutsepalov
 *
 */
public class Army<T extends Unit> {
    private Deque<T> units = new LinkedList<>();
    private Unit lord;

    public void addUnit(T unit) {
	if (unit.isAlive()) {
	    if (unit instanceof Warlord) {
		if(lord == null) {
		lord = unit;
		} else {
		    throw new IllegalArgumentException("Warlord is alredy in army");
		}
	    }
	    units.add(unit);
	} else {
	    throw new IllegalArgumentException("Unit is dead");
	}
    }

    public void addUnit(int amount, Class<? extends T> unit) {
	try {
	    for (int i = 0; i < amount; i++) {
		addUnit(unit.getDeclaredConstructor().newInstance());
	    }
	} catch (ReflectiveOperationException e) {
	    throw new IllegalStateException("Something wrong with class");
	}
    }

    public void moveUnits() {
	Objects.requireNonNull(lord, "Warlord is absent from the army");
	if (!lord.isAlive()) {
	    throw new IllegalStateException("Warlord is dead");
	}
	List<T> listUnits = (LinkedList<T>) this.units;
	listUnits.sort((Warlord) lord);
	var iterator = units.iterator();
	T warrior = null;
	while (iterator.hasNext()) {
	    warrior = iterator.next();
	    if (warrior instanceof Fighter && !(warrior instanceof Warlord)) {
		iterator.remove();
		break;
	    }
	}
	if (warrior != null) {
	    units.addFirst(warrior);
	}
    }

    public T removeUnit() {
	clear();
	T unit = units.poll();
	if (unit instanceof Warlord) {
	    lord = null;
	}
	return unit;
    }
    
    public T removeWarlord() {
	clear();
	T warlord = null;
	if(lord != null) {
	    var iterator = units.iterator();
	    while (iterator.hasNext()) {
		warlord = iterator.next();
		if (warlord instanceof Warlord) {
		    iterator.remove();
		    break;
		}
	    }
	}
	return warlord;
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
	if (size() != 0) {
	    res = false;
	}
	return res;
    }

    private void clear() {
	Iterator<T> iterator = units.iterator();
	while (iterator.hasNext()) {
	    T unit = iterator.next();
	    if (!unit.isAlive()) {
		if (unit instanceof Warlord) {
		    lord = null;
		}
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
