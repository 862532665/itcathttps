package com.solr;

/**
 * @author: 11827
 * @date: 2019/1/10 10:09
 * @description:
 */
public class Singleton {
    private Singleton() {
    }

    private static  Singleton singleton = new Singleton();

    public static Singleton getInstance() {
        return singleton;
    }
}
