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
import org.junit.jupiter.api.Test;

/**
 * @author Max Kutsepalov
 *
 */
class WarriorTest {
    private static Warrior victim;
    private static Warrior attacker;
    
    /**
     * @throws java.lang.Exception
     */
    @BeforeAll
    static void setUpBeforeClass() {
	attacker = new Knight();
	attacker.attack = 25;
	victim = new Warrior();
    }
    
    @BeforeEach
    void setUpBefore() {
	victim.health = 50;
    }
    
    @Test
    void hitShouldReturnFalse() {
	assertFalse(attacker.hit(victim));
    }
    
    @Test
    void hitsShouldReturnTrue() {
	attacker.hit(victim);
	assertTrue(attacker.hit(victim));
    }

}
