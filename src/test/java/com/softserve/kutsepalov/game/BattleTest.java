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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.softserve.kutsepalov.game.entity.Defender;
import com.softserve.kutsepalov.game.entity.Healer;
import com.softserve.kutsepalov.game.entity.Knight;
import com.softserve.kutsepalov.game.entity.Lancer;
import com.softserve.kutsepalov.game.entity.Unit;
import com.softserve.kutsepalov.game.entity.UnitTypes;
import com.softserve.kutsepalov.game.entity.Vampire;
import com.softserve.kutsepalov.game.entity.Warrior;
import com.softserve.kutsepalov.game.entity.item.GreatAxe;
import com.softserve.kutsepalov.game.entity.item.Katana;
import com.softserve.kutsepalov.game.entity.item.MagicWand;
import com.softserve.kutsepalov.game.entity.item.Sword;
import com.softserve.kutsepalov.game.entity.item.Weapon;
import com.softserve.kutsepalov.game.factory.UnitFactory;
import com.softserve.kutsepalov.game.platoon.Army;

/**
 * @author Max Kutsepalov
 *
 */
class BattleTest {
    private UnitFactory factory = new UnitFactory();

    private Army<Unit> hero; 
    private Army<Unit> enemy;
    
    @BeforeEach
    void setUpBefore() {
	hero = new Army<>();
	enemy = new Army<>();
    }
    
    @Test
    @DisplayName("Knight should win Warrior in fight")
    void fightBetweenUnits1() {
	assertTrue(Battle.fight(factory.getUnit(UnitTypes.KNIGHT),
		factory.getUnit(UnitTypes.WARRIOR)));
    }
    
    @Test
    @DisplayName("Knight should win Warrior in fight")
    void fightBetweenUnits2() {
	assertFalse(Battle.fight(factory.getUnit(UnitTypes.WARRIOR),
		factory.getUnit(UnitTypes.KNIGHT)));
    }
    
    @Test
    @DisplayName("First Vampire should win second in fight")
    void fightBetweenUnits3() {
	assertTrue(Battle.fight(factory.getUnit(UnitTypes.VAMPIRE),
		factory.getUnit(UnitTypes.VAMPIRE)));
    }
    
    @Test
    @DisplayName("Fight between Healers should return false")
    void fightBetweenUnits4() {
	assertFalse(Battle.fight(factory.getUnit(UnitTypes.HEALER),
		factory.getUnit(UnitTypes.HEALER)));
    }
    
    
    
    @Test
    @DisplayName("Hero army should win enemy army")
    void fightBetweenArmies1() {
	hero.addUnit(3, Knight.class);
	enemy.addUnit(3, Warrior.class);
	assertTrue(Battle.fight(hero, enemy));
    }
    
    @Test
    @DisplayName("Hero army should lose enemy army")
    void fightBetweenArmies2() {	
	hero.addUnit(20, Warrior.class);
	hero.addUnit(5, Knight.class);
	enemy.addUnit(30, Warrior.class);
	assertFalse(Battle.fight(hero, enemy));
    }
    
    
    
    @Test
    @DisplayName("Battle between army with Lancers should return false")
    void battleBetweenArmyWithLancers1() {
	hero.addUnit(5, Lancer.class);
	hero.addUnit(3, Vampire.class);
	hero.addUnit(4, Warrior.class);
	hero.addUnit(2, Defender.class);
	
	enemy.addUnit(4, Warrior.class);
	enemy.addUnit(4, Defender.class);
	enemy.addUnit(6, Vampire.class);
	enemy.addUnit(5, Lancer.class);
	assertFalse(Battle.fight(hero, enemy));
    }
    
    @Test
    @DisplayName("Battle between army with Lancers should return true")
    void battleBetweenArmyWithLancers2() {
	hero.addUnit(7, Lancer.class);
	hero.addUnit(3, Vampire.class);
	hero.addUnit(4, Warrior.class);
	hero.addUnit(2, Defender.class);
	
	enemy.addUnit(4, Warrior.class);
	enemy.addUnit(4, Defender.class);
	enemy.addUnit(6, Vampire.class);
	enemy.addUnit(4, Lancer.class);
	assertTrue(Battle.fight(hero, enemy));
    }
    
    
    
    @Test
    @DisplayName("Battle between army with Healers should return true")
    void battleWithHealers1() {
	hero.addUnit(7, Lancer.class);
	hero.addUnit(3, Vampire.class);
	hero.addUnit(1, Healer.class);
	hero.addUnit(4, Warrior.class);
	hero.addUnit(1, Healer.class);
	hero.addUnit(2, Defender.class);
	
	enemy.addUnit(4, Warrior.class);
	enemy.addUnit(4, Defender.class);
	enemy.addUnit(1, Healer.class);
	enemy.addUnit(6, Vampire.class);
	enemy.addUnit(4, Lancer.class);
	assertTrue(Battle.fight(hero, enemy));
    }
    
    @Test
    @DisplayName("Battle between army with Healers should return false")
    void battleWithHealers2() {
	hero.addUnit(1, Lancer.class);
	hero.addUnit(3, Warrior.class);
	hero.addUnit(1, Healer.class);
	hero.addUnit(4, Warrior.class);
	hero.addUnit(1, Healer.class);
	hero.addUnit(2, Knight.class);
		
	enemy.addUnit(4, Warrior.class);
	enemy.addUnit(4, Defender.class);
	enemy.addUnit(1, Healer.class);
	enemy.addUnit(6, Vampire.class);
	enemy.addUnit(4, Lancer.class);
	assertFalse(Battle.fight(hero, enemy));
    }
    
    

    @Test
    @DisplayName("Hero army should lose in straight battle")
    void straightBattle1() {
	hero.addUnit(5, Lancer.class);
	hero.addUnit(3, Vampire.class);
	hero.addUnit(4, Warrior.class);
	hero.addUnit(2, Defender.class);
		
	enemy.addUnit(4, Warrior.class);
	enemy.addUnit(4, Defender.class);
	enemy.addUnit(6, Vampire.class);
	enemy.addUnit(5, Lancer.class);
	assertFalse(Battle.straightFight(hero, enemy));
    }
    
    @Test
    @DisplayName("Hero army should win in straight battle")
    void straightBattle2() {
	hero.addUnit(7, Lancer.class);
	hero.addUnit(3, Vampire.class);
	hero.addUnit(4, Warrior.class);
	hero.addUnit(2, Defender.class);
		
	enemy.addUnit(4, Warrior.class);
	enemy.addUnit(4, Defender.class);
	enemy.addUnit(6, Vampire.class);
	enemy.addUnit(4, Lancer.class);
	assertTrue(Battle.straightFight(hero, enemy));
    }
    
    @Test
    @DisplayName("Hero army should lose in straight battle")
    void straightBattle3() {
	hero.addUnit(7, Lancer.class);
	hero.addUnit(3, Vampire.class);
	hero.addUnit(1, Healer.class);
	hero.addUnit(3, Warrior.class);
	hero.addUnit(1, Healer.class);
	hero.addUnit(2, Defender.class);
		
	enemy.addUnit(4, Warrior.class);
	enemy.addUnit(4, Defender.class);
	enemy.addUnit(1, Healer.class);
	enemy.addUnit(6, Vampire.class);
	enemy.addUnit(4, Lancer.class);
	assertFalse(Battle.straightFight(hero, enemy));
    }
    
    @Test
    @DisplayName("Hero army should win in straight battle")
    void straightBattle4() {
	hero.addUnit(4, Lancer.class);
	hero.addUnit(3, Warrior.class);
	hero.addUnit(1, Healer.class);
	hero.addUnit(4, Warrior.class);
	hero.addUnit(1, Healer.class);
	hero.addUnit(2, Knight.class);
		
	enemy.addUnit(4, Warrior.class);
	enemy.addUnit(4, Defender.class);
	enemy.addUnit(1, Healer.class);
	enemy.addUnit(2, Vampire.class);
	enemy.addUnit(4, Lancer.class);
	assertTrue(Battle.straightFight(hero, enemy));
    }
    
    @Test
    @DisplayName("Battle between army with Weapons should return true")
    void battleBetweenArmiesWithWeapons1() {
	Weapon weapon1 = new MagicWand();
	Weapon weapon2 = new GreatAxe();
	Army<Unit> my = new Army<>();
	my.addUnit(1, Knight.class);
	my.addUnit(1, Lancer.class);
	
	Army<Unit> enemy = new Army<>();
	enemy.addUnit(1, Vampire.class);
	enemy.addUnit(1, Healer.class);
	
	my.getUnit(0).equipWeapon(weapon1);
	my.getUnit(1).equipWeapon(weapon2);
	
	enemy.getUnit(0).equipWeapon(weapon1);
	enemy.getUnit(1).equipWeapon(weapon2);
	
	assertTrue(Battle.fight(my, enemy));
    }
    
    @Test
    @DisplayName("Battle between army with Weapons should return true")
    void battleBetweenArmiesWithWeapons2() {
	Weapon weapon1 = new Sword();
	Weapon weapon2 = new GreatAxe();
	Army<Unit> my = new Army<>();
	my.addUnit(1, Defender.class);
	my.addUnit(1, Warrior.class);
	
	Army<Unit> enemy = new Army<>();
	enemy.addUnit(1, Knight.class);
	enemy.addUnit(1, Healer.class);
	
	my.getUnit(0).equipWeapon(weapon2);
	my.getUnit(1).equipWeapon(weapon2);
	
	enemy.getUnit(0).equipWeapon(weapon1);
	enemy.getUnit(1).equipWeapon(weapon1);
	
	assertTrue(Battle.fight(my, enemy));
    }
    
    @Test
    @DisplayName("Battle between army with Weapons should return false")
    void battleBetweenArmiesWithWeapons3() {
	Weapon weapon1 = new Katana();
	Army<Unit> my = new Army<>();
	my.addUnit(2, Defender.class);
	
	Army<Unit> enemy = new Army<>();
	enemy.addUnit(1, Knight.class);
	enemy.addUnit(1, Vampire.class);
	
	my.getUnit(0).equipWeapon(weapon1);
	my.getUnit(1).equipWeapon(weapon1);
	
	enemy.getUnit(0).equipWeapon(weapon1);
	enemy.getUnit(1).equipWeapon(weapon1);
	
	assertFalse(Battle.fight(my, enemy));
    }
    
    @Test
    @DisplayName("Battle between army with Weapons should return true")
    void battleBetweenArmiesWithWeapons4() {
	Weapon weapon1 = new Weapon(-20, 6, 1, 40, -2);
	Weapon weapon2 = new Weapon(20, -2, 2, -55, 3);
	Army<Unit> my = new Army<>();
	my.addUnit(3, Knight.class);
	
	Army<Unit> enemy = new Army<>();
	enemy.addUnit(1, Warrior.class);
	enemy.addUnit(2, Defender.class);
	
	my.getUnit(0).equipWeapon(weapon1);
	my.getUnit(1).equipWeapon(weapon1);
	my.getUnit(2).equipWeapon(weapon2);
	
	enemy.getUnit(0).equipWeapon(weapon1);
	enemy.getUnit(1).equipWeapon(weapon2);
	enemy.getUnit(2).equipWeapon(weapon2);

	assertTrue(Battle.fight(my, enemy));
    }
}
