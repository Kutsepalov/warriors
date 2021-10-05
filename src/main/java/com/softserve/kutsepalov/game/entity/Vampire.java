/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 24, 2021 8:50:55 PM
 */
package com.softserve.kutsepalov.game.entity;

import com.softserve.kutsepalov.game.entity.item.Weapon;

/**
 * @author Max Kutsepalov
 *
 */
public class Vampire extends Warrior {
    public static final int MAX_HEALTH = 40;
    public static final int ATTACK = 4;
    public static final int VAMPIRISM_PERCENTAGE = 50;
    
    private int vampirism;
    
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
	this.setHealth(this.getHealth() + restoreHp);
    }
    
    @Override
    protected void updateStates() {
	vampirism = toPositiveOrZero(getDefaultVampirismPercentage() + sumAllValuesInEquipment(Weapon::getVampirism));
	super.updateStates();
    }
    
    @Override
    protected int getDefaultHealth() {
	return MAX_HEALTH;
    }

    @Override
    protected int getDefaultAttack() {
	return ATTACK;
    }
    
    protected int getDefaultVampirismPercentage() {
	return VAMPIRISM_PERCENTAGE;
    }
    
    /**
     * @return the vampirism
     */
    public int getVampirism() {
	return vampirism;
    }
    
    /**
     * @param percent the vampirism to set
     */
    protected void setVampirism(int percent) {
	this.vampirism = percent;
    }
}
