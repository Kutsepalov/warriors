/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Oct 2, 2021 7:44:08 PM
 */
package com.softserve.kutsepalov.game.entity.item;

/**
 * @author Max Kutsepalov
 *
 */
public class Shield extends Weapon {
    public static final int HEALTH_MODIFICATOR = 20;
    public static final int ATTACK_MODIFICATOR = -1;
    public static final int DEFENSE_MODIFICATOR = 2;
    
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
}
