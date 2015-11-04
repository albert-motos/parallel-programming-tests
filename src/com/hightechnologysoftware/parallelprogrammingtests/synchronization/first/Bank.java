package com.hightechnologysoftware.parallelprogrammingtests.synchronization.first;

/**
 *
 * @author albert.motos
 */
public class Bank {
    
    private Account[] accounts;
    String bankName;
    
    public Bank(String bankName) {
        this.bankName = bankName;
        
        accounts = new Account[100];
        for(int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account();
        }
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
