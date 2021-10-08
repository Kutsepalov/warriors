/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Oct 4, 2021 5:38:49 PM
 */
package com.softserve.kutsepalov.game.platoon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.softserve.kutsepalov.game.entity.Healer;
import com.softserve.kutsepalov.game.entity.Lancer;
import com.softserve.kutsepalov.game.entity.Unit;
import com.softserve.kutsepalov.game.entity.General;

/**
 * @author Max Kutsepalov
 *
 */
class ArmyTest {
    private Army<Unit> a1;
    private General lord;
    
    @BeforeEach
    void beforeEach() {
	a1 = new Army<>();
	lord = new General();
    }
    
    @Test
    @DisplayName("After sort Lancer should stay first and then Healers")
    void warlordTest() {         
        a1.addUnit(3, Healer.class);
        a1.addUnit(3, Lancer.class);
        a1.addUnit(lord);
        a1.moveUnits();
        assertTrue(a1.peek() instanceof Lancer 
        	&& a1.getUnit(1) instanceof Healer);
    }
    
    @Test
    @DisplayName("Army can't be sorted without Warlord")
    void warlordTest2() {         
        a1.addUnit(3, Healer.class);
        a1.addUnit(3, Lancer.class);
        a1.addUnit(lord);
        try {	    
            a1.moveUnits();
            fail();
	} catch (IllegalStateException e) {
	    return;
	}
    }
}
