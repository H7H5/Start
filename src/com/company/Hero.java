package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by admin on 21.04.2020.
 */
public class Hero {
    public int x = 70;             // координата x
    public int y = 300;            // координата y
    public int speed = 2;          // скорость героя
    public int distanse = 0;       // дистанция которую ми проехали
    public int acceleration = 0;   // ускорение
    public int biasY = 0;          // смещение по вертикале
    public int maxSpeed = 50;      // максимальная скорость

    public Image img = new ImageIcon("res/car1.png").getImage();// агружает картинку в класс

    public void paint(Graphics graphics)
    {
        graphics.drawImage(img,x,y,img.getWidth(null)/2,img.getHeight(null)/2,null);// рисуем картинку
    }
    public void update()
    {
        speed = speed + acceleration; // передвигаем по оси x
        if (speed<=0)
        {
            speed = 0;
        }
        if (speed >= maxSpeed)
        {
            speed = maxSpeed;
        }
        if(speed>0) {
            y = y - biasY;     //передвигаем по оси y

        }
        if (y<5)
        {
            y = 5;
        }
        if (y>410)
        {
            y = 410;
        }
        distanse = distanse + speed;
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
    public  Rectangle getRectangle (){
        Rectangle rectangle = new Rectangle(x+10,y+10,img.getWidth(null)/2-20,img.getHeight(null)/2-20);
        return rectangle;
    }
}

