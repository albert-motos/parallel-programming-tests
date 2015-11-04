package com.hightechnologysoftware.parallelprogrammingtests.synchronization.problem;

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
        float oldBalance = accounts[accountnr].get();
        float newBalance = oldBalance + amount;
        accounts[accountnr].set(newBalance);
    }
    
    public void print() {
        for(int i = 0; i < accounts.length; i++) {
            System.out.println("[" + i + "] -> " + accounts[i].get());
        }
    }
    
}
