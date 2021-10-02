/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 29, 2021 11:46:40 AM
 */
package com.softserve.kutsepalov.game.entity.ability;

import com.softserve.kutsepalov.game.entity.Unit;

/**
 * @author Max Kutsepalov
 *
 */
@FunctionalInterface
public interface Curer {
    boolean heal(Unit ally);
}
