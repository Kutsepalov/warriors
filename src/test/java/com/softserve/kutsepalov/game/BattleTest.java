/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 21, 2021 10:40:47 PM
 */
package com.softserve.kutsepalov.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.softserve.kutsepalov.game.entity.Knight;
import com.softserve.kutsepalov.game.entity.Warrior;

/**
 * @author Max Kutsepalov
 *
 */
class BattleTest {
    private static Warrior knight;
    private static Warrior warrior;

    @BeforeAll
    static void setUpBeforeClass() {
	knight = new Knight();
	warrior = new Warrior();
    }

    @Test
    void knightMustWinWarrior() {
	assertTrue(Battle.fight(knight, warrior));
    }
    
    @Test
    void warriorMustLoseKnight() {
	assertFalse(Battle.fight(warrior, knight));
    }

}
