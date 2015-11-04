package com.hightechnologysoftware.parallelprogrammingtests.basic;

/**
 *
 * @author albert.motos
 */
public class Loop2 extends Thread {
    
    private Statistics stats;
    private String myName;
    
    public Loop2(String name) {
        stats = Statistics.getInstance();
        myName = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50000; i++) {
            stats.insertUniqueStatistic(String.valueOf(i), myName);
        }
    }
    
    public static void main(String[] args) {
        Loop2 t1 = new Loop2("Thread 1");
        Loop2 t2 = new Loop2("Thread 2");
        Loop2 t3 = new Loop2("Thread 3");
        t1.start();
        t2.start();
        t3.start();
        
        boolean finish = false;
        
        while (!finish) {
            if (!t1.isAlive() && !t2.isAlive() && !t3.isAlive()) {
                Statistics.getInstance().printUniqueStatistics();
                finish = true;
            }
        }
    }
    
}
