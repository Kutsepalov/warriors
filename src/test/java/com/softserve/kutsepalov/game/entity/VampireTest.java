/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 24, 2021 6:42:36 PM
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
class VampireTest {
    private static Warrior bruce;
    private static Warrior victim;
    
    @BeforeAll
    static void setUpBeforeAll() {
	bruce = new Vampire();
	victim = new Warrior();
    }
    
    @BeforeEach
    void setUpBeforeEach() {
	bruce.setHealth(20);
	victim.setHealth(50);
    }
    
    @Test
    void vampire_shouldnt_restore_health_from_damage_when_healthy() {
	bruce.setHealth(40);
	int vampireHealth = bruce.getHealth();
	bruce.hit(victim);
	assertEquals(Vampire.MAX_HEALTH, vampireHealth);
    }
    
    @Test
    void vampire_should_restore_health_by_fifty_percent_from_damage_to_Warrior() {
	int vampireHealth = bruce.getHealth();
	bruce.hit(victim);
	assertEquals(vampireHealth + bruce.getAttack() / 2, bruce.getHealth());
    }
    
    @Test
    void vampire_should_restore_health_by_fifty_percent_from_damage_to_Defender() {
	Defender victim = new Defender();
	int vampireHealth = bruce.getHealth();
	bruce.hit(victim);
	assertEquals(vampireHealth + (bruce.getAttack() - victim.getDefense()) / 2, bruce.getHealth());
    }
    
    @Test
    void vampire_shouldnt_restore_health_from_damage_after_death() {
	bruce.setHealth(0);
	bruce.hit(victim);
	assertEquals(0, bruce.getHealth());
    }

}
