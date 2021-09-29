/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 24, 2021 6:42:36 PM
 */
package com.softserve.kutsepalov.game.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.softserve.kutsepalov.game.collection.Army;
import com.softserve.kutsepalov.game.factory.WarriorFactory;

/**
 * @author Max Kutsepalov
 *
 */
class LancerTest {
    private WarriorFactory factory = new WarriorFactory();
    
    private Lancer bruce = (Lancer) factory.getWarrior(WarriorTypes.LANCER);
    
    @Test
    void lancer_should_damage_two_warriors_in_army() {
	Army<Warrior> army = new Army<>();
	army.addUnit(3, Warrior.class);
	bruce.hit(army);
	if(army.getUnit(2).getHealth() != Warrior.MAX_HEALTH) {
	    fail("Third unit not healthy");
	}
	if(army.getUnit(0).getHealth() == Warrior.MAX_HEALTH ||
		army.getUnit(1).getHealth() == Warrior.MAX_HEALTH) {
	    fail("The first two warriors should have been damaged");
	}
    }
    
    @Test
    void lancers_damage_to_the_second_defender_soldier_should_be_halved_and_reduced_by_defense() {
	Army<Warrior> army = new Army<>();
	army.addUnit(1, Warrior.class);
	army.addUnit(new Defender());
	bruce.hit(army);
	int healthAfterDamage = army.getUnit(1).getHealth();
	assertEquals(bruce.getAttack() / 2 - Defender.DEFAULT_DEFENSE, Defender.MAX_HEALTH - healthAfterDamage);
    }
    
    @Test
    void lancer_should_damage_next_warrior_after_death_second_warrior() {
	Army<Warrior> army = new Army<>();
	army.addUnit(2, Warrior.class);
	army.getUnit(1).setHealth(1);
	Warrior checked = new Warrior();
	army.addUnit(checked);
	
	bruce.hit(army); // This hit will kill second soldier in army
	bruce.hit(army);
	
	assertEquals(true,checked.getHealth() != Warrior.MAX_HEALTH);
    }
}
