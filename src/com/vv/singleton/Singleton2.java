package com.vv.singleton;

/**
 * 懒汉式 优化
 *
 * @author ShenZhenWei
 * @date 2021/1/11
 */
public class Singleton2 {
    private static Singleton2 singleton2;

    public Singleton2() {
    }

    public static synchronized Singleton2 getInstance() {
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}
