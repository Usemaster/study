package com.study.set_;

import java.util.HashSet;
import java.util.Set;

public class HashSet01 {

    public static void main(String[] args) {

        Set set = new HashSet();

        set.add("lucy");//成功
        set.add("lucy");//失败
        set.add(new Dog("lucy"));//OK
        set.add(new Dog("lucy"));//OK

        System.out.println(set);

        set.add(new String("hsp"));//ok
        set.add(new String("hsp"));//加入不了

        System.out.println(set);


    }

}

class Dog{
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
