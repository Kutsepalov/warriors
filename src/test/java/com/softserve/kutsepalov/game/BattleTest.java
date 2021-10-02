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

import com.softserve.kutsepalov.game.collection.Army;
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
}
