package com.hightechnologysoftware.parallelprogrammingtests.synchronization.first;

/**
 *
 * @author albert.motos
 */
public class Employee extends Thread{
    
    private Bank bank;
    public String name;
    
    public Employee(String name, Bank bank) {
        super(name);
        this.bank = bank;
        this.name = name;
        start();
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            int accountnr = i;
            float amount = 1;
            
            bank.booking(name, accountnr, amount);
        }
    }
}
