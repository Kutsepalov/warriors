/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Oct 3, 2021 10:04:46 AM
 */
package com.softserve.kutsepalov.game.entity.item;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.softserve.kutsepalov.game.Battle;
import com.softserve.kutsepalov.game.entity.Defender;
import com.softserve.kutsepalov.game.entity.Healer;
import com.softserve.kutsepalov.game.entity.Knight;
import com.softserve.kutsepalov.game.entity.Lancer;
import com.softserve.kutsepalov.game.entity.Unit;
import com.softserve.kutsepalov.game.entity.Vampire;
import com.softserve.kutsepalov.game.entity.Warrior;

/**
 * @author Max Kutsepalov
 *
 */
class WeaponTest {
    
    @Test
    @DisplayName("Weapon should increase parameters")
    void weaponTest1() {
	Weapon weapon = new Weapon(5, 5, 5, 5, 5);
	Warrior warrior = new Warrior();
	warrior.equipWeapon(weapon);
	assertNotEquals(Warrior.ATTACK, warrior.getAttack());
	assertNotEquals(Warrior.MAX_HEALTH, warrior.getHealth());
    }
    
    @Test
    @DisplayName("Warrior should died after equip weapon")
    void weaponTest2() {
	Weapon weapon = new Weapon(-100, 0, 0, 0, 0);
	Warrior warrior = new Warrior();
	warrior.equipWeapon(weapon);
	assertFalse(warrior.isAlive());
    }
    
    @Test
    @DisplayName("Weapons should increase parameters")
    void weaponTest3() {
	Weapon weapon1 = new Weapon(5, 0, 0, 0, 0);
	Weapon weapon2 = new Weapon(5, 0, 0, 0, 0);

	Warrior warrior = new Warrior();
	warrior.equipWeapon(weapon1);
	warrior.equipWeapon(weapon2);

	assertEquals(Warrior.MAX_HEALTH + 10, warrior.getHealth());
    }
    
    @Test
    void testUnitsWithWeapon1() {
	Unit unit1 = new Warrior();
	Unit unit2 = new Vampire();
	Weapon weapon1 = new Weapon(-10, 5, 0, 40, 0);
	Weapon weapon2 = new Sword();
	unit1.equipWeapon(weapon1);
	unit2.equipWeapon(weapon2);
	assertTrue(Battle.fight(unit1, unit2));
    }
    
    @Test
    void testUnitsWithWeapon2() {
	Unit unit1 = new Defender();
	Unit unit2 = new Lancer();
	Weapon weapon1 = new Shield();
	Weapon weapon2 = new GreatAxe();
	unit1.equipWeapon(weapon1);
	unit2.equipWeapon(weapon2);
	assertFalse(Battle.fight(unit1, unit2));
    }
    
    @Test
    void testUnitsWithWeapon3() {
	Unit unit1 = new Healer();
	Unit unit2 = new Knight();
	Weapon weapon1 = new MagicWand();
	Weapon weapon2 = new Katana();
	unit1.equipWeapon(weapon1);
	unit2.equipWeapon(weapon2);
	assertFalse(Battle.fight(unit1, unit2));
    }
    
    @Test
    void testUnitsWithWeapon4() {
	Unit unit1 = new Defender();
	Unit unit2 = new Vampire();
	Weapon weapon1 = new Shield();
	Weapon weapon2 = new MagicWand();
	Weapon weapon3 = new Shield();
	Weapon weapon4 = new Katana();
	unit1.equipWeapon(weapon1);
	unit1.equipWeapon(weapon2);
	unit2.equipWeapon(weapon3);
	unit2.equipWeapon(weapon4);
	assertFalse(Battle.fight(unit1, unit2));
    }
}
