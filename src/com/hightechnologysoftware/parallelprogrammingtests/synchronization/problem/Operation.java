package com.hightechnologysoftware.parallelprogrammingtests.synchronization.problem;

/**
 *
 * @author albert.motos
 */
public class Operation {
    
    public static void main(String[] args) {
        Bank deutscheBank = new Bank("DeutscheBank");
        Employee eveEmployee = new Employee("Eve", deutscheBank);
        Employee hannaEmployee = new Employee("Hanna", deutscheBank);
        
        boolean end = false;
        while (!end) {
            if (!eveEmployee.isAlive() && !hannaEmployee.isAlive()) {
                deutscheBank.print();
                end = true;
            }
        }
    }
    
}
