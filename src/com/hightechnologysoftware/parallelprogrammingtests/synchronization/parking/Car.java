package com.hightechnologysoftware.parallelprogrammingtests.synchronization.parking;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author albert.motos
 */
public class Car extends Thread {
    
    public static final String ENTER = "has entered";
    public static final String LEAVE = "has left";
    private Garage garage;
    
    public Car(String name, Garage garage) {
        super(name);
        this.garage = garage;
        start();
    }
    
    @Override
    public void run () {
//        while (true) {
            try {
                sleep((int) (Math.random() * 10000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            garage.enter();
            System.out.println("[" + getName() + "] " + ENTER);
            
            try {
                sleep((int) (Math.random() * 20000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            garage.leave();
            System.out.println("[" + getName() + "] " + LEAVE);
//        }
    }
}
