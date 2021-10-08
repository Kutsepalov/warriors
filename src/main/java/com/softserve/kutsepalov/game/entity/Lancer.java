/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 28, 2021 11:36:31 AM
 */
package com.softserve.kutsepalov.game.entity;

import com.softserve.kutsepalov.game.entity.ability.MultiFighter;
import com.softserve.kutsepalov.game.platoon.Army;

/**
 * @author Max Kutsepalov
 *
 */
public class Lancer extends Warrior implements MultiFighter {
    public static final int MAX_HEALTH = 50;
    public static final int ATTACK = 6;
    public static final int PERCENT_DAMAGE_TO_NEXT_WARRIOR = 50;
    
    private int percentSecondDamage = getDefaultPercentSecondDamage();
    
    @Override
    public boolean hit(Army<? extends Unit> army) {
	final int maxPercent = 100;
	boolean res = false;
	if (!army.isEmpty()) {
	    this.hit(army.getUnit(0));
	    if(army.size() > 1) {
		Unit second = army.getUnit(1);
		second.getDamage(getDefaultAttack() * getDefaultPercentSecondDamage() / maxPercent);
	    }
	}

	if (army.isEmpty()) {
	    res = true;
	}
	return res;
    }

    @Override
    protected int getDefaultHealth() {
	return MAX_HEALTH;
    }

    @Override
    protected int getDefaultAttack() {
	return ATTACK;
    }
    
    protected int getDefaultPercentSecondDamage() {
	return PERCENT_DAMAGE_TO_NEXT_WARRIOR;
    }
    
    public int getPercentSecondDamage() {
	return percentSecondDamage;
    }

    /**
     * @param secondDamage the secondDamage to set
     */
    protected void setSercentSecondDamage(int percentSecondDamage) {
        this.percentSecondDamage = percentSecondDamage;
    }
}
