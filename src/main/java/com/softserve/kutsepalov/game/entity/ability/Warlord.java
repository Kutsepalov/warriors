/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Oct 6, 2021 8:47:08 PM
 */
package com.softserve.kutsepalov.game.entity.ability;

import java.util.Comparator;

import com.softserve.kutsepalov.game.entity.Unit;

/**
 * @author Max Kutsepalov
 *
 */
public interface Warlord extends Comparator<Unit> {
    
    @Override
    default int compare(Unit o1, Unit o2) {
	if (o1 instanceof Warlord) {
	    return 1;
	}
	if (o2 instanceof Warlord) {
	    return -1;
	}

	if (o1 instanceof Curer) {
	    return -1;
	}
	if (o2 instanceof Curer) {
	    return 1;
	}

	if (o1 instanceof MultiFighter && o2 instanceof Fighter) {
	    return -1;
	}
	return 0;
    }
}
