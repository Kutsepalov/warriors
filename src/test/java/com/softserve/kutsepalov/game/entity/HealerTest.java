/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 29, 2021 12:31:29 PM
 */
package com.softserve.kutsepalov.game.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Max Kutsepalov
 *
 */
class HealerTest {

    @Test
    void healerShouldHealWarrior() {
	Warrior bruce = new Warrior();
	Healer bill = new Healer();
	bruce.hit(bruce);
	int hpBefore = bruce.getHealth();
	bill.heal(bruce);
	int hpAfter = bruce.getHealth();
	assertEquals(bill.getPowerHeal(), hpAfter - hpBefore);;
    }
    
    @Test
    void healerShouldntHealDeadWarrior() {
	Warrior bruce = new Warrior();
	Healer bill = new Healer();
	bruce.setHealth(0);
	assertFalse(bill.heal(bruce));
    }

}
