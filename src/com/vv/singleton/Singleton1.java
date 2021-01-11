package com.vv.singleton;

/**
 * 懒汉式
 *
 * @author ShenZhenWei
 * @date 2021/1/11
 */
public class Singleton1 {
    private static Singleton1 singleton1;

    private Singleton1() {
    }

    ;

    public static Singleton1 getInstance() {
        if (singleton1 == null) {
            singleton1 = new Singleton1();
        }
        return singleton1;
    }
}
