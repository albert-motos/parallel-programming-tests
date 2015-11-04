package com.hightechnologysoftware.parallelprogrammingtests.synchronization.parking;

/**
 *
 * @author albert.motos
 */
public class Garage {
    
    private int places;
    
    public Garage(int places) {
        this.places = (places < 0 ? 0 : places);
    }
    
    public synchronized void enter() {
        while (places == 0) {            
            try {
                wait();
            } catch (Exception e) {
            }
        }
        
        places--;
    }
    
    public synchronized void leave() {
        places++;
        notify();
    }
    
}
