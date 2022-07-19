package com.demo.com.usemaster.lambda;/**
 * @author gongwj
 * @Date 2022/1/10
 */

import org.junit.Test;
import org.omg.Messaging.SyncScopeHelper;

import javax.crypto.interfaces.PBEKey;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author gongwj
 * @Date 2022/1/10
 */
public class LambdaTest {

    protected List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Employee.Status.SLEEPING),
            new Employee("李四", 38, 5555.55, Employee.Status.WORKING),
            new Employee("王五", 60, 6666.66, Employee.Status.WORKING),
            new Employee("赵六", 8, 7777.77, Employee.Status.SLEEPING),
            new Employee("田七", 58, 3333.33, Employee.Status.VOCATION)
    );

    public String stringHandler(String str,MyFunction myFunction){
        return myFunction.getValue(str);
    }

    @Test
    public void test1(){
        Collections.sort(employees,(e1,e2)->{
            if(e1.getAge() == e2.getAge()){
                return  e1.getName().compareTo(e2.getName());
            }
            //正序输出
            //return Integer.compare(e1.getAge(),e2.getAge());
            //倒叙输出
            return -Integer.compare(e1.getAge(),e2.getAge());
        });
        //流遍历
        employees.stream().forEach(System.out::println);
    }

    @Test
    public void test2(){
        String value = stringHandler("binghe",(s)-> s.toUpperCase().substring(1,3));
        System.out.println(value);
    }

}
