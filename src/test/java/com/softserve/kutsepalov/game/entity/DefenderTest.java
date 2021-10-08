/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 24, 2021 12:56:13 PM
 */
package com.softserve.kutsepalov.game.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.softserve.kutsepalov.game.Battle;
import com.softserve.kutsepalov.game.platoon.Army;

/**
 * @author Max Kutsepalov
 *
 */
class DefenderTest {
    private Warrior chuck;
    private Warrior bruce;
    private Warrior carl;

    private Army<Warrior> hero; 
    private Army<Warrior> enemy;
    
    @BeforeEach
    void setUpBefore() {
	hero = new Army<>();
	enemy = new Army<>();
	
	chuck = new Warrior();
	bruce = new Knight();
	carl = new Defender();
    }
    
    @Test
    void carlShouldWinChuck() {
	assertTrue(Battle.fight(carl, chuck));
    }
    
    @Test
    void carlShouldLoseBruce() {
	assertFalse(Battle.fight(carl, bruce));
    }
    
    @Test
    void defenderArmyShouldLoseWarriorArmy() {	
	hero.addUnit(1, Defender.class);
	enemy.addUnit(2, Warrior.class);
	assertFalse(Battle.fight(hero, enemy));
    }
    
    @Test
    void defenderArmyShouldWinWarriorArmy() {
	hero.addUnit(1, Warrior.class);
	hero.addUnit(1, Defender.class);
	enemy.addUnit(2, Warrior.class);
	assertTrue(Battle.fight(hero, enemy));
    }
}
