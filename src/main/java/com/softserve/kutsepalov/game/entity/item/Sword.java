/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Oct 2, 2021 7:06:05 PM
 */
package com.softserve.kutsepalov.game.entity.item;

/**
 * @author Max Kutsepalov
 *
 */
public class Sword extends Weapon {
    public static final int HEALTH_MODIFICATOR = 5;
    public static final int ATTACK_MODIFICATOR = 2;

    @Override
    protected int getDefaultHealth() {
	return HEALTH_MODIFICATOR;
    }

    @Override
    protected int getDefaultAttack() {
	return ATTACK_MODIFICATOR;
    }
}
