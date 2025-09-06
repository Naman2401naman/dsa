class LRUCache {
    final int capacity;
    final LinkedHashMap<Integer,Integer> cache;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.cache=new LinkedHashMap<>(capacity,0.75f,true);
    }
    
    public int get(int key) {
        return cache.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value); // Update
        } else {
            if (cache.size() >= capacity) {
                // Remove least recently used (first entry)
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
            cache.put(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */