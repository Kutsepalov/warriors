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
public class Warrior implements Fighter {
    protected int health;
    protected int attack;
    private boolean isAlive;
    
    public Warrior() {
	health = 50;
	attack = 5;
	isAlive = true;
    }
       
    @Override
    public boolean hit(Warrior enemy) {
	boolean enemyhasKilled = false;
	if(isAlive && enemy.isAlive) {
	    enemy.health -= attack;
	    enemy.updateVitalState();
	    if(!enemy.isAlive) {
		enemyhasKilled = true;
	    }
	}
	return enemyhasKilled;
    }
    
    private void updateVitalState() {
	if(health <= 0) {
	    isAlive = false;
	    health = 0;
	}
    }
    
    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }
    /**
     * @return the damage
     */
    public int getAttack() {
        return attack;
    }
    /**
     * @return the isAlive
     */
    public boolean isAlive() {
        return isAlive;
    }
}
