/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Oct 2, 2021 8:26:37 PM
 */
package com.softserve.kutsepalov.game.entity.item;

/**
 * @author Max Kutsepalov
 *
 */
public class MagicWand extends Weapon {
    public static final int HEALTH_MODIFICATOR = 30;
    public static final int ATTACK_MODIFICATOR = 3;
    public static final int HEAL_POWER_MODIFICATOR = 3;
    
    @Override
    protected int getDefaultHealth() {
	return HEALTH_MODIFICATOR;
    }
    @Override
    protected int getDefaultAttack() {
	return ATTACK_MODIFICATOR;
    }
    @Override
    protected int getDefaultHealPower() {
	return HEAL_POWER_MODIFICATOR;
    }
}
