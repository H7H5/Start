package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by admin on 21.04.2020.
 */
public class Hero {
    public Image img = new ImageIcon("res/car1.png").getImage();// агружает картинку в класс

    public void paint(Graphics graphics)
    {
        graphics.drawImage(img,50,100,img.getWidth(null),img.getHeight(null),null);
    }
}
