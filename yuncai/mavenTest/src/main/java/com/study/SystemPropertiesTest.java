package com.study;

import java.util.Properties;
import java.util.Set;

/**
 * @author gongwj
 * @Date 2022/10/7
 */
public class SystemPropertiesTest {

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        Set<Object> propNameSet = properties.keySet();
        for (Object propName : propNameSet) {
            String propValue = properties.getProperty((String) propName);
            System.out.println(propName + "=" + propValue);
        }
    }

}
