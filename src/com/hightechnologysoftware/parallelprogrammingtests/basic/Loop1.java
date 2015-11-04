package com.hightechnologysoftware.parallelprogrammingtests.basic;

/**
 *
 * @author albert.motos
 */
public class Loop1 extends Thread {
    
    private String myName;
    
    public Loop1(String name) {
        myName = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            System.out.println(myName + " (" + i + ")");
        }
    }
    
    public static void main(String[] args) {
        Loop1 t1 = new Loop1("Thread 1");
        Loop1 t2 = new Loop1("Thread 2");
        Loop1 t3 = new Loop1("Thread 3");
        t1.start();
        t2.start();
        t3.start();
    }
    
}
