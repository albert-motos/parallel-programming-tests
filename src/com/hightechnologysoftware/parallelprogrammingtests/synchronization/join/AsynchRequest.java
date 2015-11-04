package com.hightechnologysoftware.parallelprogrammingtests.synchronization.join;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author albert.motos
 */
public class AsynchRequest {

    private static final int ARRAY_SIZE = 100000000;
    private static final int NUMBER_OF_SERVERS = 100;
    private static final String INFO_TAG = "[INFO]";

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        boolean[] array = new boolean[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = Math.random() < 0.1;
        }

        Service[] service = new Service[NUMBER_OF_SERVERS];
        Thread[] serverThread = new Thread[NUMBER_OF_SERVERS];

        int start = 0;
        int end;
        int howMany = ARRAY_SIZE / NUMBER_OF_SERVERS;

        for (int i = 0; i < NUMBER_OF_SERVERS; i++) {
            end = start + howMany - 1;
            service[i] = new Service(array, start, end);
            serverThread[i] = new Thread(service[i]);
            serverThread[i].start();
            start = end + 1;
        }

        try {
            for (int i = 0; i < NUMBER_OF_SERVERS; i++) {
                serverThread[i].join();
            }
        } catch (Exception e) {
        }

        int result = 0;
        for (int i = 0; i < NUMBER_OF_SERVERS; i++) {
            result += service[i].getResult();
        }
        
        long endTime = System.currentTimeMillis();
        float time = (endTime - startTime) / 1000.0f;
        
        System.out.println(INFO_TAG + " Computation time: " + time);
        System.out.println(INFO_TAG + " Result: " + result);
        
        startTime = endTime;
        
        Service uniqueService = new Service(array, 0, ARRAY_SIZE - 1);
        Thread threadUniqueService = new Thread(uniqueService);
        threadUniqueService.start();
        try {
            threadUniqueService.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(AsynchRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        endTime = System.currentTimeMillis();
        time = (endTime - startTime) / 1000.0f;
        
        System.out.println(INFO_TAG + " Computation time: " + time);
        System.out.println(INFO_TAG + " Result: " + uniqueService.getResult());
    }
}
