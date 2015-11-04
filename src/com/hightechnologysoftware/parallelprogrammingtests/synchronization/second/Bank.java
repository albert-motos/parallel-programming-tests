package com.hightechnologysoftware.parallelprogrammingtests.synchronization.second;

/**
 *
 * @author albert.motos
 */
public class Bank {
    
    private Account[] accounts;
    String bankName;
    private boolean lock;
    
    public Bank(String bankName) {
        this.bankName = bankName;
        
        accounts = new Account[100];
        for(int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account();
        }
        lock = false;
    }
    
    public void booking(String employee, int accountnr, float amount) {
        accounts[accountnr].booking(amount);
    }
    
    public void print() {
        for(int i = 0; i < accounts.length; i++) {
            System.out.println("[" + i + "] -> " + accounts[i].get());
        }
    }
    
}
