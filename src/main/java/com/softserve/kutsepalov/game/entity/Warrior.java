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
    
    public Warrior() {
	this.setHealth(50);
	this.setAttack(5);
    }
       
    @Override
    public boolean hit(Unit enemy) {
	boolean enemyhasKilled = false;
	if(this.isAlive() && enemy.isAlive()) {
	    enemy.setHealth(enemy.getHealth() - this.getAttack());
	    if(!enemy.isAlive()) {
		enemyhasKilled = true;
	    }
	}
	return enemyhasKilled;
    }
 
}
