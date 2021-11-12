package com.example.mydemos.bloomFilter;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @author : huangjie121015
 * @date : 2021/11/12 15:24
 */
public class MyBloomFilter {
    //你的布隆过滤器容量
    private static final int DEFAULT_SIZE = 2 << 28;
    //后面hash函数会用到，用来生成不同的hash值
    private static final int[] ints = {1, 6, 16, 38, 58, 68};
    //bit数组，用来存放结果
    private static BitSet bitSet = new BitSet(DEFAULT_SIZE);

    //push方法，计算出key的hash值，并将对应下标置为true
    public void push(Object key) {
        Arrays.stream(ints).forEach(i -> bitSet.set(hash(key, i)));
    }

    //判断key是否存在，true不一定说明key存在，但是false一定说明不存在
    public boolean contain(Object key) {
        boolean result = true;
        for (int i : ints) {
            result = result && bitSet.get(hash(key, i));
        }
        return result;
    }

    //hash函数，借鉴了hashmap的扰动算法
    private int hash(Object key, int i) {
        int h;
        return key == null ? 0 : (i * (DEFAULT_SIZE - 1) & ((h = key.hashCode()) ^ (h >>> 16)));
    }
}
