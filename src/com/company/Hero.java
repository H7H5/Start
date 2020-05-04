package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

/**
 * Created by admin on 21.04.2020.
 */
public class Hero {

    public  ImageIcon imageIcon = new ImageIcon("res/car1.png");
    Image img = imageIcon.getImage();

    public Image img1 = new ImageIcon("res/car1.png").getImage();// агружает картинку в класс

    public void paint(Graphics graphics)
    {
        graphics.drawImage(img,50,100,img.getWidth(null)/2,img.getHeight(null)/2,null);// рисуем картинку
    }
}
