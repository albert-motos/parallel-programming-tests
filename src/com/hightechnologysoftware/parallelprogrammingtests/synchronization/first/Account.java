package com.hightechnologysoftware.parallelprogrammingtests.synchronization.first;

/**
 *
 * @author albert.motos
 */
public class Account {
    
    private float balance;
    
    public float get() {
        return balance;
    }
    
    public void booking(float amount) {
        balance += amount;
    }
    
}
