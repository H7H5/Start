package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by admin on 28.04.2020.
 */
public class Luke {
    public int x = 0;
    public int y = 0;
    public Image img = new ImageIcon("res/Luke200x200.png").getImage();// агружает картинку в класс
    public void update(int heroSpeed)
    {
        x = x - heroSpeed;
        if(x < -150)
        {
            x = 1400;
            Random random = new Random();
            y = random.nextInt(440);
        }
    }
    public void paint(Graphics graphics)
    {
        graphics.drawImage(img,x,y,img.getWidth(null),img.getHeight(null),null);
    }
}
