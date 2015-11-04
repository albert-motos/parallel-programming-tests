package com.hightechnologysoftware.parallelprogrammingtests.basic;

import com.sun.javafx.font.freetype.HBGlyphLayout;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author albert.motos
 */
public class Statistics {
    
    private Map<String, String> map;
    
    private Statistics() {
        map = new HashMap<>();
    }
    
    public static Statistics getInstance() {
        return StatisticsHolder.INSTANCE;
    }
    
    private static class StatisticsHolder {

        private static final Statistics INSTANCE = new Statistics();
    }
    
    public boolean insertUniqueStatistic(String key, String value) {
        
        boolean unique = map.containsKey(key);
        
        if (!unique) {
            map.put(key, value);
        }
        
        return unique;
    }
    
    public void printUniqueStatistics(){
        
        HashMap<String, Integer> stats = new HashMap<>();
        
        for (Map.Entry<String, String> entrySet : map.entrySet()) {
            String key = entrySet.getValue();
            
            if (stats.containsKey(key)) {
                Integer value = stats.get(key);
                stats.put(key, value + 1);
            } else {
                stats.put(key, 1);
            }
            
        }
        
        for (Map.Entry<String, Integer> entrySet : stats.entrySet()) {
            String key = entrySet.getKey();
            Integer value = entrySet.getValue();
            
            System.out.println("[" + key + "] -> " + value + " -> " + Math.round(value / 50000.0 * 100) + "%");
        }
    }
    
}
