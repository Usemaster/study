package phone;


import org.junit.Test;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestPhoNumber{

    @Test
    public void test(){
        new PhoNumber();
    }

    @Test
    //在方法中，修改一个基础类型的参数不会影响原始参数值
    public void test01(){
        int i = 5;
        func(i);
        System.out.println(i);
    }

    public static void func(int i){
        i = 10;
    }

    @Test
    public void test02(){
        String x="fmn";
        x.toUpperCase();
        String y=x.replace('f','F');
        y=y+"wxy";
        System.out.println(y);
    }

    @Test
    public void test03(){
        int i = 0;
        for (out('A');out('B') && (i < 2);out('C')){
            i++;
            out('D');
        }
    }

    static boolean out(char c){
        System.out.println(c);
        return true;
    }

    @Test
    public void test04(){
        int[] a = {1,2,3,4};
        int[] b = {1,3,5,7};
        System.out.println(a.equals(b));
    }

    @Test
    public void test05(){
        int i = 5;
        int j = 10;
        System.out.println(i + ~j);
    }

    @Test
    public void test06(){
        int a = '2';
        System.out.println(a);
    }

    @Test
    public void test07(){
        int a[] = new int[6];
        System.out.println ( a[0]);
    }

    @Test
    public void test08(){
        String s = "祝你考出好成绩！";
        System.out.println(s.length());
    }

    @Test
    public void test09(){
        char chr = 127;
        int sum = 200;
        chr += 1;
        sum += chr;
        System.out.println(sum);
    }

    @Test
    public void test10(){
        char chr = 127;
        Object sum = chr;
        System.out.println(sum);
    }

    @Test
    public void test11(){
        String s = "hello";
        String t = "hello";
        char c [] = {'h','e','l','l','o'};
        System.out.println(s.equals(t));
        System.out.println(t.equals(c));
        System.out.println(s == t);
        System.out.println(t.equals(new String("hello")));
    }

    @Test
    public void test12(){
        System.out.println(TestPhoNumber.hash(2));
    }
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input,int k){
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(input);
        for(int i = 0;i < k;i++){
            list.add(input[i]);
        }

        return list;
    }

    public void merge(int A[], int m, int B[], int n) {
        int i = 0,j = 0,p = 0;
        int[] c = new int[m+n];
        while(i < m && j < n){
            c[p++] = A[i] <= B[j]?A[i++]:B[j++];
        }
        while (i < m){
            c[p++] = A[i++];
        }
        while (j < n){
            c[p++] = B[j++];
        }
        for (i = 0; i < p; i++) {
            A[i] = c[i];
        }
    }

    public String solve (String str) {
        char[] res = str.toCharArray();
        int len = str.length();
        for (int i = 0;i < len;i++){
            res[i] = str.charAt(len-1-i);
        }
        return res.toString();
    }

}

class TestChinese {
    public static void main(String[] args) {
        Chinese obj1 = Chinese.getInstance();
        Chinese obj2 = Chinese.getInstance();
        System.out.println(obj1 == obj2);
    }
}
class Chinese{
    private static Chinese objref =new Chinese();
    private Chinese(){}
    public static Chinese getInstance() { return objref; }
}

abstract class hello{
    hello() {

    }
}

class Test1 {
    public static void hello() {
        System.out.println("hello");
    }
}
class MyApplication {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test1 test=null;
        test.hello();
    }
}
