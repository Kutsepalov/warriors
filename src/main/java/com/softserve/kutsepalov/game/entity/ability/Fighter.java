/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Sep 22, 2021 9:35:17 AM
 */
package com.softserve.kutsepalov.game.entity;

/**
 * @author Max Kutsepalov
 *
 */
@FunctionalInterface
public interface Fighter {
    /**
     * Method which implements hit action from attacker to another entity
     * @param entity
     * @return <b>true</b> if entity has died
     */
    boolean hit(Unit entity);
}
