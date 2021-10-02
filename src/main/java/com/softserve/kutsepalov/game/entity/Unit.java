/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 23, 2021 11:33:56 AM
 */
package com.softserve.kutsepalov.game.entity;

/**
 * @author Max Kutsepalov
 *
 */
public abstract class Unit {
    private int health = getDefaultHealth();
    private int attack = getDefaultAttack();
    
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
	boolean isAlive;
	if(health <= 0) {
	    isAlive = false;
	} else {
	    isAlive = true;
	}
        return isAlive;
    }

    /**
     * @param health the health of unit to set
     */
    protected void setHealth(int health) {
	if(health < 0) {
	    health = 0;
	} else if(health > getDefaultHealth()) {
	    health = getDefaultHealth();
	}
        this.health = health;
    }
    
    /**
     * @param attack the attack of unit to set
     */
    protected void setAttack(int attack) {
        this.attack = attack;
    }
    
    protected void getDamage(int damage) {
	this.setHealth(health - damage);
    }
    
    protected abstract int getDefaultHealth();
    protected abstract int getDefaultAttack();
}
