/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 21, 2021 9:27:47 PM
 */
package com.softserve.kutsepalov.game;

import com.softserve.kutsepalov.game.entity.Warrior;

/**
 * @author Max Kutsepalov
 *
 */
public final class Battle {
    
    private Battle() {
	throw new IllegalStateException();
    }
    
    public static boolean fight(Warrior first, Warrior second) {
	boolean res = false;
	while (first.isAlive() && second.isAlive()) {
	    boolean hasSecondDied = first.hit(second);
	    if(!hasSecondDied) {		
		second.hit(first);
	    }
	}
	if(first.isAlive()) {
	    res = true;
	}
	return res;
    }
}
