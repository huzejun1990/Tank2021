package com.dream.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author : huzejun
 * @Date: 2021/12/8-19:46
 */
public class PropertyMgr {

    private static Properties prop = new Properties();

    public PropertyMgr() {
    }

    static {
        try {
            prop.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getValue(String key){
        if (prop == null) {
            return null;
        }
        return prop.get(key);
    }


}
