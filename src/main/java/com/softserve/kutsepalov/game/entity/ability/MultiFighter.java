/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 28, 2021 11:24:41 AM
 */
package com.softserve.kutsepalov.game.entity.ability;

import com.softserve.kutsepalov.game.entity.Unit;
import com.softserve.kutsepalov.game.platoon.Army;

/**
 * @author Max Kutsepalov
 *
 */
public interface MultiFighter extends Fighter {
    boolean hit(Army<? extends Unit> army);
}
