package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    private OriginalRetriever originalRetriever;
    private LRUCache<Long, Object> lruCache = new LRUCache<>(5);
    private Storage storage;

    public CachingProxyRetriever(Storage storage) {
        this.originalRetriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
        Object cachedObject = lruCache.find(id);

        if (cachedObject == null) {
            cachedObject = originalRetriever.retrieve(id);
            lruCache.set(id, cachedObject);
        }

        return cachedObject;
    }
}
