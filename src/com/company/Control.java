package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by admin on 05.05.2020.
 */
public class Control extends KeyAdapter {
    Hero hero;
    public Control(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        hero.keyPressed(e);
    }
    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        hero.keyReleased(e);
    }
}