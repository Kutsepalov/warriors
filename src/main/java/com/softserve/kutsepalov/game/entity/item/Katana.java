/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Oct 2, 2021 8:22:39 PM
 */
package com.softserve.kutsepalov.game.entity.item;

/**
 * @author Max Kutsepalov
 *
 */
public class Katana extends Weapon {
    public static final int HEALTH_MODIFICATOR = -20;
    public static final int ATTACK_MODIFICATOR = 6;
    public static final int DEFENSE_MODIFICATOR = -5;
    public static final int VAMPIRISM_MODIFICATOR = 50;
    
    @Override
    protected int getDefaultHealth() {
	return HEALTH_MODIFICATOR;
    }
    @Override
    protected int getDefaultAttack() {
	return ATTACK_MODIFICATOR;
    }
    @Override
    protected int getDefaultDefense() {
	return DEFENSE_MODIFICATOR;
    }
    @Override
    protected int getDefaultVampirism() {
	return VAMPIRISM_MODIFICATOR;
    }
}
