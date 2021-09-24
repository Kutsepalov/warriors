/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 24, 2021 12:18:27 PM
 */
package com.softserve.kutsepalov.game.entity;

/**
 * @author Max Kutsepalov
 *
 */
public class Defender extends Warrior {
    private int defense;
    
    public Defender() {
	this.setHealth(60);
	this.setAttack(3);
	this.setDefense(2);
    }
    
    @Override
    protected void doDamage(int damage) {
	damage -= defense;
	if(damage < 0) {
	    damage = 0;
	}
	super.doDamage(damage);
    }

    /**
     * @return the defense
     */
    public int getDefense() {
        return defense;
    }

    /**
     * @param defense the defense to set
     */
    protected void setDefense(int defense) {
        this.defense = defense;
    }
}
