/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 24, 2021 8:50:55 PM
 */
package com.softserve.kutsepalov.game.entity;

/**
 * @author Max Kutsepalov
 *
 */
public class Vampire extends Warrior {
    public static final int MAX_HEALTH = 40;
    public static final int DEFAULT_ATTACK = 4;
    public static final int VAMPIRISM_PERCENTAGE = 50;
    
    private int vampirism;
    
    public Vampire() {
	this.setHealth(MAX_HEALTH);
	this.setAttack(DEFAULT_ATTACK);
	this.setVampirism(VAMPIRISM_PERCENTAGE);
    }
    
    @Override
    public boolean hit(Unit enemy) {
	int hpBefore = enemy.getHealth();
	boolean res = super.hit(enemy);
	int hpAfter = enemy.getHealth();
	restoreHealth(hpBefore - hpAfter);
	return res;
    }
    
    private void restoreHealth(int damage) {
	final int maxPercent = 100;
	int restoreHp = damage * vampirism / maxPercent;
	int futureHp = this.getHealth() + restoreHp;
	if(futureHp > MAX_HEALTH) {
	    futureHp = MAX_HEALTH;
	}
	this.setHealth(futureHp);
    }
    
    /**
     * @return the vampirism
     */
    protected int getVampirism() {
        return vampirism;
    }

    /**
     * @param percent the vampirism to set
     */
    protected void setVampirism(int percent) {
        this.vampirism = percent;
    }
}
