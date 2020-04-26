package com.company;

import javax.swing.*;

public class Main extends JPanel { //наследуемся от класса JPanel

    public static final int WIDTH = 1280;
    public static final int HEIGHT =720;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Гонки");   //создаем объект frame
        frame.setSize(WIDTH,HEIGHT);       //устанавливаем размеры
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// закрывает окно
        frame.setResizable(false);                //запрет на изменение размера окна
        frame.setLocationRelativeTo(null);        // окно будет по центру
        frame.add(new Space());                   // добавляем объект Space
        frame.setVisible(true);                   // делаем фрейм видимым
    }
}
