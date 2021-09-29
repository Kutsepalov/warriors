/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 21, 2021 9:37:16 PM
 */
package com.softserve.kutsepalov.game.entity;

/**
 * @author Max Kutsepalov
 *
 */
public class Knight extends Warrior {
    public static final int MAX_HEALTH = 50;
    public static final int DEFAULT_ATTACK = 7;   

    @Override
    protected int getDefaultAttack() {
	return DEFAULT_ATTACK;
    }
}
