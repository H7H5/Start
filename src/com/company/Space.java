package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by admin on 14.04.2020.
 */
public class Space extends JPanel implements ActionListener {
    int roadX = 0;
    int roadX2 = 1280;
    public Image img = new ImageIcon("res/road.png").getImage();// агружает картинку в класс
    public Image img2 = new ImageIcon("res/road.png").getImage();// агружает картинку в класс
    Hero hero = new Hero();                      //создаем героя
    Luke luke = new Luke();
    Timer timer = new Timer(20,this);
    public Space() {
        setFocusable(true);
        timer.start();
    }

    public void update()
    {
        roadX =  roadX - 5;
        roadX2 =  roadX2 - 5;
        if(roadX2<0)
        {
            roadX =  0;
            roadX2 =  1280;
        }
        luke.update();
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(img,roadX,0,img.getWidth(null),(int)(img.getHeight(null)/1.5f),null);// рисуем дорогу
        graphics.drawImage(img2,roadX2,0,img.getWidth(null),(int)(img.getHeight(null)/1.5f),null);
        luke.paint(graphics);
        hero.paint(graphics);                                                                                            // рисуем героя
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }
}