package com.company;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by admin on 12.05.2020.
 */
public class RivalsFactory extends Thread {
    ArrayList<Rival> rivals;
    public RivalsFactory(ArrayList<Rival> rivals) {
        this.rivals = rivals;
    }
    @Override
    public void run() {
        super.run();
        while (true){
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(1000));
                rivals.add(new Rival(1700,random.nextInt(400),random.nextInt(30))); // создаем очередного соперника и помещаем его в общюю коллекцию
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
