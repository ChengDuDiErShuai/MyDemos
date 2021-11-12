package com.example.mydemos.bloomFilter;

import org.junit.Test;

/**
 * @author : huangjie121015
 * @date : 2021/11/12 15:26
 */
public class MyBloomFilterTest {

    @Test
    public void f() {
        MyBloomFilter myBloomFilter = new MyBloomFilter();
        myBloomFilter.push("张学友");
        myBloomFilter.push("郭德纲");
        myBloomFilter.push(666);
        System.out.println(myBloomFilter.contain("张学友"));//true
        System.out.println(myBloomFilter.contain("张学友 "));//false
        System.out.println(myBloomFilter.contain("张学友1"));//false
        System.out.println(myBloomFilter.contain("郭德纲"));//true
        System.out.println(myBloomFilter.contain(666));//true
        System.out.println(myBloomFilter.contain(888));//false
    }
}
