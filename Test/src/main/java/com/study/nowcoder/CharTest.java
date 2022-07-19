package com.study.nowcoder;

//for循环的语句执行顺序
//第一个参数，第二个参数，循环体，第三个参数，第二个参数，循环体，第三个参数，一直循环直到for循环结束
public class CharTest {

    static boolean foo(char c)
    {
        System.out.print(c);
        return true;
    }
    public static void main(String[] args) {
        int i =0;
        for(foo('A');foo('B')&&(i<2);foo('C'))
        {
            i++;
            foo('D');
        }
    }

}
