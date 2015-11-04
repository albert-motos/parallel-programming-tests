package com.hightechnologysoftware.parallelprogrammingtests.basic;

/**
 *
 * @author albert.motos
 */
public class MyThread extends Thread {
    
    @Override
    public void run() {
        System.out.println("Hello world");
    }
    
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
