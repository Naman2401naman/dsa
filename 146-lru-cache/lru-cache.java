class LRUCache {
    final int capacity;
    final LinkedHashMap<Integer,Integer> mp;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.mp=new LinkedHashMap<>(capacity,0.75f,true);
    }
    
    public int get(int key) {
        return mp.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            mp.put(key,value);
        }else{
            if(mp.size()>=capacity){
                int old=mp.keySet().iterator().next();
                mp.remove(old);
            }
            mp.put(key,value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */