/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 21, 2021 8:16:01 PM
 */
package com.softserve.kutsepalov.game.entity;

import com.softserve.kutsepalov.game.entity.ability.Fighter;

/**
 * @author Max Kutsepalov
 *
 */
public class Warrior extends Unit implements Fighter {
    public static final int MAX_HEALTH = 50;
    public static final int ATTACK = 5;
       
    @Override
    public boolean hit(Unit enemy) {
	boolean enemyhasKilled = false;
	if(this.isAlive() && enemy.isAlive()) {
	    enemy.getDamage(this.getAttack());
	    if(!enemy.isAlive()) {
		enemyhasKilled = true;
	    }
	}
	return enemyhasKilled;
    }

    @Override
    protected int getDefaultHealth() {
	return MAX_HEALTH;
    }

    @Override
    protected int getDefaultAttack() {
	return ATTACK;
    }
 
}
