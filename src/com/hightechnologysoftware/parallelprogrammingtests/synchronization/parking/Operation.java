package com.hightechnologysoftware.parallelprogrammingtests.synchronization.parking;

/**
 *
 * @author albert.motos
 */
public class Operation {
    
    public static void main(String[] args) {
        Garage garage = new Garage(10);
        
        for (int i = 0; i < 40; i++) {
            new Car("CAR-" + i, garage);
        }
    }
    
}
