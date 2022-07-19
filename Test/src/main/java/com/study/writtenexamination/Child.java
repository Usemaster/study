package com.study.writtenexamination;

class Base{
    void test(){
        System.out.println("Base.test()");
    }
}

public class Child extends Base{

    void test(){
        System.out.println("Child.test()");
    }

    static String s;

    public static void main(String[] args) {
        Child anObj = new Child();
        Base baseObj = (Base) anObj;
        //测试代码相当于：Base baseObj = new Child();
        // 父类的引用指向子类的实例，子类又重写了父类
        //的test方法，因此调用子类的test方法。
        baseObj.test();//Child.test()
        System.out.println("s=" + s);
    }

}
