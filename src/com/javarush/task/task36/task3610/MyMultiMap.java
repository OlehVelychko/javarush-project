package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int totalSize = 0;
        for (List<V> values : map.values()) {
            totalSize += values.size();
        }
        return totalSize;
    }

    /*@Override
    public V put(K key, V value) {
        List<V> values = map.computeIfAbsent(key, k -> new ArrayList<>());
        V returnedValue = null;

        if (values.size() < repeatCount) {
            values.add(value);
        } else {
            returnedValue = values.get(values.size() - 1);
            values.remove(0);
            values.add(value);
        }

        return values.isEmpty() ? null : returnedValue;

    }*/

    @Override
    public V put(K key, V value) {
        if (map.containsKey(key)) {
            if (map.get(key).size() < repeatCount) {
                map.get(key).add(value);
                return map.get(key).get(map.get(key).size() - 2);
            } else {
                List<V> list = map.get(key);
                list.add(value);
                list.remove(0);
                return list.get(repeatCount - 2);
            }
        } else {
            map.put(key, new ArrayList<V>() {{
                add(value);
            }});
            return null;
        }
    }

    @Override
    public V remove(Object key) {
        List<V> values = map.get(key);

        if (values != null && !values.isEmpty()) {
            V removedValue = values.remove(0);

            if (values.isEmpty()) {
                map.remove(key);
            }

            return removedValue;
        }

        return null;
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        List<V> allValues = new ArrayList<>();

        for (List<V> values : map.values()) {
            allValues.addAll(values);
        }

        return allValues;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        for (List<V> thisValues : map.values()) {
            if (thisValues.contains(value)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}