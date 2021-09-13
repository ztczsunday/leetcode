package Leetcode146;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
//todo
class LRUCache {
    int capacity;
    Map<Integer,Integer> map=new HashMap<>();
    Queue<Integer> queue=new LinkedList<>();
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            map.put(key,value);
            return;
        }
        if (queue.size()==capacity){
            int removedKey=queue.poll();
            map.remove(removedKey);
        }
        map.put(key,value);
    }
}