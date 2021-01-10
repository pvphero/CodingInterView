package com.vv.singleton;

/**
 * 双重检查 DCL
 *
 * @author ShenZhenWei
 * @date 2021/1/11
 */
public class DCLSingleton {
    private static DCLSingleton singleton;

    public DCLSingleton() {
    }

    public static DCLSingleton getInstance() {
        if (singleton == null) {
            synchronized (DCLSingleton.class) {
                if (singleton == null) {
                    singleton = new DCLSingleton();
                }
            }
        }
        return singleton;
    }
}
