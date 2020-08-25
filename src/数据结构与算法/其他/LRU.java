package 数据结构与算法.其他;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName LRU
 * @Description TODO 双向链表+HashMap
 * @Author tuantuan
 * @Date 2020/4/23 上午11:56
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class LRU {

    CashMap cashMap;

    public LRU(int capacity) {
        cashMap = new CashMap(capacity);
    }

    public int get(int key) {
        if (cashMap.containsKey(key)){
            int val = cashMap.get(key);
            cashMap.remove(key);
            cashMap.put(key,val);
            return  val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cashMap.containsKey(key)) cashMap.remove(key);
        cashMap.put(key,value);
    }
}

class CashMap extends LinkedHashMap<Integer,Integer>{

    private int MAX;

    CashMap(int max) {
        this.MAX = max;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>MAX;
    }
}
