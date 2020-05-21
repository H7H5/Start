package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by admin on 12.05.2020.
 */
public class Rival {
    public int x = 500;
    public int y = 200;
    public int speed = 10;
    int line;
    public Image img;
    public Image img0 = new ImageIcon("res/car1.png").getImage();
    public Image img1 = new ImageIcon("res/car2.png").getImage();
    public Image img2 = new ImageIcon("res/car3.png").getImage();
    public Image img3 = new ImageIcon("res/car4.png").getImage();
    public Image img4 = new ImageIcon("res/car5.png").getImage();
    public Image img5 = new ImageIcon("res/car6.png").getImage();
    public int []arrY = {10,80,160,240,320,400};
    public Rival(int x, int line, int speed) {
        this.x = x;
        this.line = line;
        y = arrY[line];
        this.speed = speed;
        Random random = new Random();
        int im = random.nextInt(6);
        switch (im){
            case 0:
                img = img0;
                break;
            case 1:
                img = img1;
                break;
            case 2:
                img = img2;
                break;
            case 3:
                img = img3;
                break;
            case 4:
                img = img4;
                break;
            case 5:
                img = img5;
                break;
        }
    }

    public void paint(Graphics graphics)
    {
        graphics.drawImage(img,x,y,img.getWidth(null)/2,img.getHeight(null)/2,null);// рисуем картинку
    }
    public void update(int heroSpeed)
    {
        x = x + speed - heroSpeed; // двигаем соперника
    }


}
