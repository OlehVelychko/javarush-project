package com.javarush.task.task39.task3911;

import java.util.*;

public class Software {
    private int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        if (rollbackVersion < getMaxKey()) {
            removeNextVersions(rollbackVersion);
            currentVersion = rollbackVersion;
            return true;
        }
        return false;
    }

    private Integer getMaxKey() {
        return Collections.max(versionHistoryMap.keySet());
    }

    private void removeNextVersions(int rollbackVersion) {
        versionHistoryMap = new LinkedHashMap<>(new TreeMap<>(versionHistoryMap));
        for (int i = rollbackVersion + 1; i <= getMaxKey(); i++) {
            versionHistoryMap.remove(i);
        }
    }
}
