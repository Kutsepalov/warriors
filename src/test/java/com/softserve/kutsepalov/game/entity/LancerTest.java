/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 24, 2021 6:42:36 PM
 */
package com.softserve.kutsepalov.game.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.softserve.kutsepalov.game.factory.UnitFactory;
import com.softserve.kutsepalov.game.platoon.Army;

/**
 * @author Max Kutsepalov
 *
 */
class LancerTest {
    private UnitFactory factory = new UnitFactory();
    
    private Lancer bruce = (Lancer) factory.getUnit(UnitTypes.LANCER);
    
    @Test
    @DisplayName("Lancer should damage two warriors in army")
    void lancerAbility1() {
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
    @DisplayName("Lancer damage to the second defender soldier should be halved and reduced by defense")
    void lancerAbility2() {
	Army<Warrior> army = new Army<>();
	army.addUnit(1, Warrior.class);
	army.addUnit(1, Defender.class);
	bruce.hit(army);
	int healthAfterDamage = army.getUnit(1).getHealth();
	assertEquals(bruce.getAttack() / 2 - Defender.DEFENSE, Defender.MAX_HEALTH - healthAfterDamage);
    }
    
    @Test
    @DisplayName("Lancer should damage next warrior after death second warrior")
    void lancerAbility3() {
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
