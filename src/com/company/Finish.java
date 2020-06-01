package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by admin on 26.05.2020.
 */
public class Finish {
    public int x = 100000;
    public int y = 0;
    public Image img = new ImageIcon("res/finish.png").getImage();// агружает картинку в класс
    public void  update(int speed){
        x = x- speed;
    }
    public void paint (Graphics graphics){
        graphics.drawImage(img,x,y,img.getWidth(null),img.getHeight(null),null);
    }
    public  Rectangle getRectangle (){
        Rectangle rectangle = new Rectangle(x+200,y,img.getWidth(null),img.getHeight(null));
        return rectangle;
    }

}