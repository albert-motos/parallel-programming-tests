package com.hightechnologysoftware.parallelprogrammingtests.basic;

/**
 *
 * @author albert.motos
 */
public class MyRunnableThread implements Runnable {

    @Override 
    public void run() {
        System.out.println("Hello World");
    }
    
    public static void main(String[] args) {
        MyRunnableThread runner = new MyRunnableThread();
        Thread t = new Thread(runner);
        t.start();
    }
}
