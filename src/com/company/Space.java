package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * Created by admin on 14.04.2020.
 */
public class Space extends JPanel implements ActionListener {
    int countCar =0;
    int roadX = 0;
    int roadX2 =1280;
    public Image img = new ImageIcon("res/road.png").getImage();// агружает картинку в класс
    public Image img2 = new ImageIcon("res/road.png").getImage();// агружает картинку в класс
    Hero hero = new Hero();                      //создаем героя
    ArrayList<Rival> rivals = new ArrayList<>(); //хранилище соперников
    Thread rivalsFactory = new RivalsFactory(rivals);// сойдаем отдельный поток для создания соперников
    Luke luke = new Luke();  //создаем люк
    Timer timer = new Timer(20,this);  //создаем таймер
    public Space() {
        addKeyListener(new Control(hero));
        setFocusable(true);
        timer.start();   // запускаем таймер
        rivalsFactory.start();//запускаем фабрику соперников :)
    }

    public void update() // метод для просчета игровой механики
    {
        hero.update();
        roadX =  roadX - hero.speed;
        roadX2 =  roadX2 - hero.speed;
        if(roadX2<0)
        {
            roadX =  0;
            roadX2 =  1280;
        }
        luke.update(hero.speed);
        for (int i =0; i<rivals.size();i++){
            rivals.get(i).update(hero.speed);
        }
        rivalRemove();
    }

    @Override
    public void paint(Graphics graphics) { // метод для рисования графики
        graphics.drawImage(img,roadX,0,img.getWidth(null),(int)(img.getHeight(null)/1.5f),null);// рисуем дорогу
        graphics.drawImage(img2,roadX2,0,img.getWidth(null),(int)(img.getHeight(null)/1.5f),null);
        luke.paint(graphics);
        for (int i =0; i<rivals.size();i++){
            rivals.get(i).paint(graphics);
        }
        hero.paint(graphics);                                                                                            // рисуем героя
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }
    private void rivalRemove(){
        boolean flag = false;
        for(int i = 0 ; i < rivals.size();i++){
            if(rivals.get(i).x>3000){
                rivals.remove(i);
                flag = true;
                break;
            }
            if(rivals.get(i).x<-500){
                rivals.remove(i);
                flag = true;
                countCar++;
                break;
            }
        }
        if(flag == true){
            rivalRemove();
        }
    }
}
