package com.company;

import javax.swing.*;
import java.awt.*;


/**
 * Created by admin on 14.04.2020.
 */
public class Space extends JPanel {
    public Image img = new ImageIcon("res/road.png").getImage();// агружает картинку в класс
    Hero hero = new Hero();                      //создаем героя

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(img,0,0,img.getWidth(null),img.getHeight(null),null);
        hero.paint(graphics);                    // рисуем героя
    }
}
