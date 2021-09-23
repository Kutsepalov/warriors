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
    private int health;
    private int attack;
    private boolean isAlive = false;
 
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

    /**
     * @param health the health of unit to set
     */
    protected void setHealth(int health) {
        this.health = health;
        updateVitalState();
    }
    
    /**
     * @param attack the attack of unit to set
     */
    protected void setAttack(int attack) {
        this.attack = attack;
    }
    
    private void updateVitalState() {
	if(health <= 0) {
	    isAlive = false;
	    health = 0;
	} else {
	    isAlive = true;
	}
    }
}
