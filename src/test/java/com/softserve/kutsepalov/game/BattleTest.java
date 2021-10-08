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
import com.softserve.kutsepalov.game.entity.Vampire;
import com.softserve.kutsepalov.game.entity.Warrior;
import com.softserve.kutsepalov.game.entity.item.GreatAxe;
import com.softserve.kutsepalov.game.entity.item.Katana;
import com.softserve.kutsepalov.game.entity.item.MagicWand;
import com.softserve.kutsepalov.game.entity.item.Sword;
import com.softserve.kutsepalov.game.entity.item.Weapon;
import com.softserve.kutsepalov.game.platoon.Army;

/**
 * @author Max Kutsepalov
 *
 */
class BattleTest {
    private Warrior chuck;
    private Warrior bruce;

    private Army<Unit> hero; 
    private Army<Unit> enemy;
    
    @BeforeEach
    void setUpBefore() {
	hero = new Army<>();
	enemy = new Army<>();
	
	chuck = new Warrior();
	bruce = new Knight();
    }
    
    @Test
    void bruceShouldWinChuck() {
	assertTrue(Battle.fight(bruce, chuck));
    }
    
    @Test
    void chuckShouldLoseBruce() {
	assertFalse(Battle.fight(chuck, bruce));
    }
    
    @Test
    @DisplayName("First vampire should win second")
    void fightBetweenVampires() {
	bruce = new Vampire();
	chuck = new Vampire();
	assertTrue(Battle.fight(bruce, chuck));
    }
    
    @Test
    void heroArmyShouldWinEnemyArmy() {
	hero.addUnit(3, Knight.class);
	enemy.addUnit(3, Warrior.class);
	assertTrue(Battle.fight(hero, enemy));
    }
    
    @Test
    void heroArmyShouldLoseEnemyArmy() {	
	hero.addUnit(20, Warrior.class);
	hero.addUnit(5, Knight.class);
	enemy.addUnit(30, Warrior.class);
	assertFalse(Battle.fight(hero, enemy));
    }
    
    @Test
    void battleBetweenArmyWithLancers() {
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
    void battleWithHealers() {
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
    void straightBattle() {
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
