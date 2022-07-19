package com.study.DetailTest;

//String,StringBuilder,StringBuffer
public class StringTest {
    public static void main(String[] args) {
        int i = 10;
        String s = "哪吒";
        //"+"连接符底层，实际上就是StringBuilder调用append方法，再调用toString方法完成的
        System.out.println(s + i);
    }
}

/**
 * 反编译后
 */
//public class StringTest {
//    public static void main(String args[]) {
//
//        byte byte0 = 10;
//        String s = "哪吒";
//        System.out.println((new StringBuilder()).append(s).append(byte0).toString());
//    }
//}
