/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 22, 2021 10:21:23 AM
 */
package com.softserve.kutsepalov.game.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Max Kutsepalov
 *
 */
class WarriorTest {
    private static Warrior victim;
    private static Warrior attacker;

    @BeforeAll
    static void setUpBeforeClass() {
	attacker = new Knight();
	attacker.setAttack(25);
	victim = new Warrior();
    }
    
    @BeforeEach
    void setUpBefore() {
	victim.setHealth(50);
    }
    
    @Test
    @DisplayName("Method hit should return false")
    void warriorAbility1() {
	assertFalse(attacker.hit(victim));
    }
    
    @Test
    @DisplayName("Method hit should return true after death rival")
    void warriorAbility2() {
	attacker.hit(victim);
	assertTrue(attacker.hit(victim));
    }

}
