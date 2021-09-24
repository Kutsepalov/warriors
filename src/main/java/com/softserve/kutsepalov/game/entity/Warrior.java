/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 21, 2021 8:16:01 PM
 */
package com.softserve.kutsepalov.game.entity;

/**
 * @author Max Kutsepalov
 *
 */
public class Warrior extends Unit implements Fighter {
    public static final int MAX_HEALTH = 50;
    public static final int DEFAULT_ATTACK = 5;
    
    public Warrior() {
	this.setHealth(MAX_HEALTH);
	this.setAttack(DEFAULT_ATTACK);
    }
       
    @Override
    public boolean hit(Unit enemy) {
	boolean enemyhasKilled = false;
	if(this.isAlive() && enemy.isAlive()) {
	    enemy.doDamage(this.getAttack());
	    if(!enemy.isAlive()) {
		enemyhasKilled = true;
	    }
	}
	return enemyhasKilled;
    }
 
}
