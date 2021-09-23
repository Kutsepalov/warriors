/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 21, 2021 9:27:47 PM
 */
package com.softserve.kutsepalov.game;

import com.softserve.kutsepalov.game.entity.Army;
import com.softserve.kutsepalov.game.entity.Warrior;

/**
 * @author Max Kutsepalov
 *
 */
public final class Battle {
    
    private Battle() {
	throw new IllegalStateException();
    }
    
    /**
     * Method which conduct fight between two warriors and return result of battle.
     * @param attacker warrior
     * @param defender warrior
     * @return <b>true</b> if the attacker wins the battle
     */
    public static boolean fight(Warrior attacker, Warrior defender) {
	boolean res = false;
	while (attacker.isAlive() && defender.isAlive()) {
	    boolean hasDefenderDied = attacker.hit(defender);
	    if(!hasDefenderDied) {		
		defender.hit(attacker);
	    }
	}
	if(attacker.isAlive()) {
	    res = true;
	}
	return res;
    }
    
    public static boolean fight(Army<Warrior> attacker, Army<Warrior> defender) {
	boolean res = false;
	while(!attacker.isEmpty() && !defender.isEmpty()) {
	    if(fight(attacker.peek(), defender.peek())) {
		defender.removeUnit();
	    } else {
		attacker.removeUnit();
	    }
	}
	if(!attacker.isEmpty()) {
	    res = true;
	}
	return res;
    }
}
