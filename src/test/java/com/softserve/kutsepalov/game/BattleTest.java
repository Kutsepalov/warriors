/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 21, 2021 10:40:47 PM
 */
package com.softserve.kutsepalov.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.softserve.kutsepalov.game.entity.Army;
import com.softserve.kutsepalov.game.entity.Knight;
import com.softserve.kutsepalov.game.entity.Warrior;

/**
 * @author Max Kutsepalov
 *
 */
class BattleTest {
    private Warrior knight;
    private Warrior warrior;
    private Army<Warrior> hero; 
    private Army<Warrior> enemy;
    
    @BeforeEach
    void setUpBefore() {
	knight = new Knight();
	warrior = new Warrior();
	hero = new Army<>();
	enemy = new Army<>();
    }
    
    @Test
    void knightMustWinWarrior() {
	assertTrue(Battle.fight(knight, warrior));
    }
    
    @Test
    void warriorMustLoseKnight() {
	assertFalse(Battle.fight(warrior, knight));
    }
    
    @Test
    void heroShouldWinEnemy() {
	hero.addUnit(3, Knight.class);
	enemy.addUnit(3, Warrior.class);
	assertTrue(Battle.fight(hero, enemy));
    }
    
    @Test
    void heroShouldLoseEnemy() {
	hero.addUnit(20, Warrior.class);
	hero.addUnit(5, Knight.class);
	enemy.addUnit(30, Warrior.class);
	assertFalse(Battle.fight(hero, enemy));
    }
}
