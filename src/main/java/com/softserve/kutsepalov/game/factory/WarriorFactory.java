/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 26, 2021 9:30:56 PM
 */
package com.softserve.kutsepalov.game.factory;

import com.softserve.kutsepalov.game.entity.*;

/**
 * @author Max Kutsepalov
 *
 */
public class WarriorFactory {
    public Warrior getWarrior(WarriorTypes type) {
	Warrior toReturn;
	switch(type) {
	    case WARRIOR:
    	    	toReturn = new Warrior();
    	    	break;
	    case KNIGHT:
    	    	toReturn = new Knight();
    	    	break;
	    case DEFENDER:
    	    	toReturn = new Defender();
    	    	break;
	    case VAMPIRE:
    	    	toReturn = new Vampire();
    	    	break;
    	    default: 
    		throw new IllegalArgumentException("Wrong type: " + type);
	}
	return toReturn;
    }
}
