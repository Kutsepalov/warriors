/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 21, 2021 9:27:47 PM
 */
package com.softserve.kutsepalov.game;

import com.softserve.kutsepalov.game.collection.Army;
import com.softserve.kutsepalov.game.entity.Knight;
import com.softserve.kutsepalov.game.entity.Unit;
import com.softserve.kutsepalov.game.entity.Warrior;
import com.softserve.kutsepalov.game.entity.ability.Curer;
import com.softserve.kutsepalov.game.entity.ability.Fighter;
import com.softserve.kutsepalov.game.entity.ability.MultiFighter;
import static java.lang.Math.min;

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
     * 
     * @param attacker warrior
     * @param defender warrior
     * @return <b>true</b> if the attacker wins the battle
     */
    public static boolean fight(Unit attacker, Unit defender) {
	Fighter attackerF = null;
	Fighter defenderF = null;
	
	if(attacker instanceof Fighter) {
	    attackerF = (Fighter) attacker;
	}
	if(defender instanceof Fighter) {
	    defenderF = (Fighter) defender;
	}	
	killIfNotFighters(attacker, defender);	
	while (attacker.isAlive() && defender.isAlive()) {
	    boolean hasDefenderDied = false;
	    
	    if(attackerF != null) {
		hasDefenderDied = attackerF.hit(defender);
	    }
	    
	    if (!hasDefenderDied && defenderF != null) {
		defenderF.hit(attacker);
	    }
	}
	return attacker.isAlive();
    }
    
    public static boolean straightFight(Army<? extends Unit> attacker, Army<? extends Unit> defender) {
	Unit[] attackers;
	Unit[] defenders;
	
	while(!attacker.isEmpty() && !defender.isEmpty()) {
	    int minSize = min(attacker.size(), defender.size());
	    
	    attackers = toArray(minSize, attacker);
	    defenders = toArray(minSize,  defender);
	    for(int i = 0; i < minSize; i++) {
		fight(attackers[i], defenders[i]);
	    }
	}
	return !attacker.isEmpty();
    }

    
    public static boolean fight(Army<? extends Unit> attacker, Army<? extends Unit> defender) {
	while (!attacker.isEmpty() && !defender.isEmpty()) {
	    Unit x = defender.peek();
	    halfRoundWithArmies(attacker, defender);
	    if (x.isAlive()) {
		halfRoundWithArmies(defender, attacker);
	    }
	}
	return !attacker.isEmpty();
    }

    private static void halfRoundWithArmies(Army<? extends Unit> first, Army<? extends Unit> second) {
	if (!killIfNotFighters(first.peek(), second.peek())
		&& first.peek() instanceof Fighter) {	    
	    if (first.peek() instanceof MultiFighter) {
		((MultiFighter) first.peek()).hit(second);
	    } else {
		((Fighter) first.peek()).hit(second.peek());
	    }
	    if (first.size() > 1 && first.getUnit(1) instanceof Curer) {
		((Curer) first.getUnit(1)).heal(first.peek());
	    }
	}
    }
    
    private static boolean killIfNotFighters(Unit one, Unit two) {
	boolean res = false;
	Warrior arbiter = new Knight();
	if(!(one instanceof Fighter) && !(two instanceof Fighter)) {
	    fight(arbiter, one);
	    fight(arbiter, two);
	    res = true;
	}
	return res;
    }
    
    private static Unit[] toArray(int size, Army<? extends Unit> army) {
	Unit[] units = new Unit[size];
	for(int i = 0; i < size; i++) {
	    units[i] = army.getUnit(i);
	}
	return units;
    }
}
