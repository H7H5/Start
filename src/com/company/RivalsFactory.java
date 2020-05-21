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
                Thread.sleep(random.nextInt(500));
                int xRival = 1700;
                int line = random.nextInt(6);
                int speed = random.nextInt(30);
                boolean valid = true;
                for (int i =0; i < rivals.size();i++){
                    if(rivals.get(i).line == line){
                        valid = false;
                    }
                }
                if(valid == true){
                    rivals.add(new Rival(xRival,line,speed));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
