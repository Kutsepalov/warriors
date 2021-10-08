/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 23, 2021 11:33:56 AM
 */
package com.softserve.kutsepalov.game.entity;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;

import com.softserve.kutsepalov.game.entity.item.Weapon;

/**
 * @author Max Kutsepalov
 *
 */
public abstract class Unit {
    private List<Weapon> equipment = new ArrayList<>();
    private int health;
    private int attack;
    
    protected Unit() {
	updateStates();
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
    
    protected void getDamage(int damage) {
	this.setHealth(health - damage);
    }
    
    public Unit equipWeapon(Weapon weapon) {
	requireNonNull(weapon, "weapon must not be null");
	equipment.add(weapon);
	updateStates();
	return this;
    }
    
    protected void updateStates() {
	health = toPositiveOrZero(getDefaultHealth() + sumAllValuesInEquipment(Weapon::getHealth));
	attack = toPositiveOrZero(getDefaultAttack() + sumAllValuesInEquipment(Weapon::getAttack));
    }
    
    protected abstract int getDefaultHealth();
    protected abstract int getDefaultAttack();
    
    protected static int toPositiveOrZero(int value) {
	if(value < 0) {
	    value = 0;
	}
	return value;
    }
    
    protected final int sumAllValuesInEquipment(ToIntFunction<? super Weapon> func) {
	return equipment.stream().mapToInt(func).sum();
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
     * @param health the health of unit to set
     */
    protected void setHealth(int health) {
	if(health > getDefaultHealth()) {
	    health = getDefaultHealth();
	} else {
	    health = toPositiveOrZero(health);
	}
        this.health = health;
    }

    /**
     * @param attack the attack of unit to set
     */
    protected void setAttack(int attack) {
        this.attack = toPositiveOrZero(attack);
    }
}
