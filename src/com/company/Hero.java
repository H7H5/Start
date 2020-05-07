package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by admin on 21.04.2020.
 */
public class Hero {
    public int x = 70;
    public int y = 300;
    public int speed = 2;
    public int distanse = 0;
    public int acceleration = 0;
    public int biasY = 0;
    public int maxSpeed = 50;

    public Image img = new ImageIcon("res/car1.png").getImage();// агружает картинку в класс

    public void paint(Graphics graphics)
    {
        graphics.drawImage(img,x,y,img.getWidth(null)/2,img.getHeight(null)/2,null);// рисуем картинку
    }
    public void update()
    {
        speed = speed + acceleration;
        if (speed<=0)
        {
            speed = 0;
        }
        if (speed >= maxSpeed)
        {
            speed = maxSpeed;
        }
        if(speed>0) {
            y = y - biasY;

        }
        if (y<5)
        {
            y = 5;
        }
        if (y>410)
        {
            y = 410;
        }

    }

    public void  keyPressed(KeyEvent keyEvent)
    {
        int key = keyEvent.getKeyCode();
        if(key == KeyEvent.VK_RIGHT){
            acceleration = 1;
        }
        if(key == KeyEvent.VK_LEFT){
            acceleration = -1;
        }
        if(key == KeyEvent.VK_UP){
            biasY = 5;
        }
        if(key == KeyEvent.VK_DOWN){
            biasY = -5;
        }

    }
    public void  keyReleased(KeyEvent keyEvent)
    {
        int key = keyEvent.getKeyCode();
        if(key == KeyEvent.VK_RIGHT) {
            acceleration = 0;
        }
        if(key == KeyEvent.VK_LEFT){
            acceleration = 0;
        }
        if(key == KeyEvent.VK_UP){
            biasY = 0;
        }
        if(key == KeyEvent.VK_DOWN){
            biasY = 0;
        }
    }
}

