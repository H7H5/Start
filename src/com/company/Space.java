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
    int roadX2 = 1280;
    public Image img = new ImageIcon("res/road.png").getImage();// агружает картинку в класс
    public Image img2 = new ImageIcon("res/road.png").getImage();// агружает картинку в класс
    Hero hero = new Hero();                      //создаем героя
    ArrayList<Rival> rivals = new ArrayList<>(); //хранилище соперников
    Thread rivalsFactory = new RivalsFactory(rivals);// сойдаем отдельный поток для создания соперников
    Luke luke = new Luke();  //создаем люк
    Finish finish = new Finish();// создаем финиш
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
            roadX = 0;
            roadX2 = 1280;
        }
        finish.update(hero.speed);
        luke.update(hero.speed);
        for (int i =0; i<rivals.size();i++){
            rivals.get(i).update(hero.speed);
            if(hero.getRectangle().intersects(rivals.get(i).getRectangle())){
                JOptionPane.showMessageDialog(null,"Вы проиграли :(");
                System.exit(1);
            }
        }
        if(hero.getRectangle().intersects(finish.getRectangle())){
            JOptionPane.showMessageDialog(null,"Вы выиграли");
            System.exit(1);
        }
        rivalRemove();
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(img,roadX,0,img.getWidth(null),(int)(img.getHeight(null)/1.5f),null);// рисуем дорогу
        graphics.drawImage(img2,roadX2,0,img.getWidth(null),(int)(img.getHeight(null)/1.5f),null);
        finish.paint(graphics);
        luke.paint(graphics);
        for (int i =0; i<rivals.size();i++){
            rivals.get(i).paint(graphics);
            //graphics.fillRect(rivals.get(i).getRectangle().x,rivals.get(i).getRectangle().y,rivals.get(i).getRectangle().width,rivals.get(i).getRectangle().height);
        }
        hero.paint(graphics);// рисуем героя
        //graphics.fillRect(hero.getRectangle().x,hero.getRectangle().y,hero.getRectangle().width,hero.getRectangle().height);
        Font f1 = new Font("TimesRoman",Font.BOLD,42);
        graphics.setFont(f1);
        graphics.setColor(color(242,47,9));
        graphics.drawString("Distanse "+hero.distanse/100,50,50);
        graphics.setColor(color(42,117,9));
        graphics.drawString("Speed "+hero.speed,400,50);
        graphics.setColor(color(42,117,100));
        graphics.drawString("Car "+countCar,700,50);
    }
    public  Color color (int red, int green, int blue){ // метод для создания цвета
        return new Color(red,green,blue);
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
