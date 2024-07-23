package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.*;

/**
 * Singleton class that manages and stores statistical data
 */
public class StatisticManager {
    private static StatisticManager instance;
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        if (instance == null) {
            synchronized (StatisticManager.class) {
                if (instance == null) {
                    instance = new StatisticManager();
                }
            }
        }
        return instance;
    }

    /**
     * Registers data to storage
     *
     * @param dataRow the event data to be registered
     */
    public void register(EventDataRow dataRow) {

    }

    /**
     * Private inner class that acts as a storage for statistical data
     */
    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new EnumMap<>(EventType.class);

        /**
         * Constructor that initializes the storage map with empty lists for each event type
         */
        public StatisticStorage() {
            Arrays.stream(EventType.values()).forEach(eventType -> storage.put(eventType, new ArrayList<>()));
        }
    }
}