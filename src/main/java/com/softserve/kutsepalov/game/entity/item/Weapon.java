/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Oct 2, 2021 6:57:37 PM
 */
package com.softserve.kutsepalov.game.entity.item;

/**
 * @author Max Kutsepalov
 *
 */
public class Weapon {
    private int defaultValue = 0;
    
    private int health = getDefaultHealth();
    private int attack = getDefaultAttack();
    private int defense = getDefaultDefense();
    private int vampirism = getDefaultVampirism();
    private int healPower = getDefaultHealPower();

    public Weapon() {

    }
    
    /**
     * @param health
     * @param attack
     * @param defense
     * @param vampirism
     * @param healPower
     */
    public Weapon(int health, int attack, int defense, int vampirism, int healPower) {
	this.health = health;
	this.attack = attack;
	this.defense = defense;
	this.vampirism = vampirism;
	this.healPower = healPower;
    }
    
    public static class Builder {
	private Weapon weapon;
	
	public Builder() {
	    weapon = new Weapon();
	}
	
	public Builder withHealth(int health) {
	    weapon.health = health;
	    return this;
	}
	
	public Builder withAttack(int attack) {
	    weapon.attack = attack;
	    return this;
	}
	
	public Builder withDefense(int defense) {
	    weapon.defense = defense;
	    return this;
	}
	
	public Builder withVampirism(int vampirism) {
	    weapon.vampirism = vampirism;
	    return this;
	}
	
	public Builder withHealPower(int healPower) {
	    weapon.healPower = healPower;
	    return this;
	}
	
	public Weapon build() {
	    return weapon;
	}	
    }
    
    protected int getDefaultHealth() {
	return defaultValue;
    }
    
    protected int getDefaultAttack() {
	return defaultValue;
    }
    
    protected int getDefaultDefense() {
	return defaultValue;
    }
    
    protected int getDefaultVampirism() {
	return defaultValue;
    }
    
    protected int getDefaultHealPower() {
	return defaultValue;
    }

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @return the attack
     */
    public int getAttack() {
        return attack;
    }

    /**
     * @return the defense
     */
    public int getDefense() {
        return defense;
    }

    /**
     * @return the vampirism
     */
    public int getVampirism() {
        return vampirism;
    }

    /**
     * @return the healPower
     */
    public int getHealPower() {
        return healPower;
    }

    /**
     * @param health the health to set
     */
    protected void setHealth(int health) {
        this.health = health;
    }

    /**
     * @param attack the attack to set
     */
    protected void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * @param defense the defense to set
     */
    protected void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * @param vampirism the vampirism to set
     */
    protected void setVampirism(int vampirism) {
        this.vampirism = vampirism;
    }

    /**
     * @param healPower the healPower to set
     */
    protected void setHealPower(int healPower) {
        this.healPower = healPower;
    }
}
