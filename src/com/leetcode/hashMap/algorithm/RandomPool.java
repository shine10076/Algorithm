package com.leetcode.hashMap.algorithm;

import java.util.HashMap;

/**
 * @author shine10076
 * @date 2019/9/21 19:48
 */
public class RandomPool {

    public HashMap<String, Integer> keyIndexMap;
    public HashMap<Integer,String> IndexKeyMap;
    public int size;

    public RandomPool(){
        keyIndexMap = new HashMap<>();
        IndexKeyMap = new HashMap<>();
        size = 0;
    }

    public void insert(String key)
    {
        if(!this.keyIndexMap.containsKey(key))
        {
            this.keyIndexMap.put(key,this.size);
            this.IndexKeyMap.put(this.size++,key);
        }
    }

    public void delete(String key)
    {
        if(this.keyIndexMap.containsKey(key))
        {
            int deleteIndex = this.keyIndexMap.get(key);
            int lastIndex = --this.size;
            String lastKey = this.IndexKeyMap.get(lastIndex);
            this.IndexKeyMap.put(deleteIndex,lastKey);
            this.keyIndexMap.put(lastKey,deleteIndex);
            this.keyIndexMap.remove(key);
            this.IndexKeyMap.remove(lastIndex);
        }
    }

    public String getRandomKey()
    {
        if(size == 0) return null;
        int index  = (int)(Math.random()*size);
        return IndexKeyMap.get(index);

    }

}
