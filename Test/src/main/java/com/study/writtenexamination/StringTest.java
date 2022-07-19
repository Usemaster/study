package com.study.writtenexamination;

public class StringTest {

    public static void main(String[] args) {
        //false
        System.out.println(new String("john") == new String("john"));
        //false
        System.out.println("john" == new String("john"));
        //true
        System.out.println(new String("john").equals(new String("john")));
        //true
        //当调用 intern 方法时，如果池中已经包含一个等于该String对象的字符串equals(Object)由equals(Object)方法确定equals(Object) ，则返回池中的字符串。 否则，将此String对象添加到池中并返回对此String对象的引用。
        //由此可见，对于任何两个字符串s和t ， s.intern() == t.intern()是true当且仅当s.equals(t)是true 。
        System.out.println("john" == "john".intern());
        //true
        System.out.println("john" == "john");
    }

}
