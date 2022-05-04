package com.study.nowcoder;

public class ExtendsTest {

    public static void main(String[] args) {

    }


class Car extends Vehicle {
//    public static void main (String[] args) {
//        // cannot be referenced from a static context
//        //new  Car(). run();
//    }

    private final void run() {
        System. out. println ("Car");
    }
}

class Vehicle {
    private final void run()
    {
        System. out. println("Vehicle");
    }
}

}
