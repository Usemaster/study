package com.study.throwable.exception;

import com.study.DetailTest.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.logging.Logger;

/**
 * @author gongwj
 * @Date 2023/2/19
 */
public class ExceptionTest {

    static Log log = LogFactory.getLog(ExceptionTest.class);

    public static void main(String[] args) {
        exceptionCatch();
    }

    public static void exceptionCatch(){
        try {
            Person person = null;
            Person person1 = person;
            person1.setAge(16);
        }catch (Exception e){
            //二月 19, 2023 10:40:25 下午 com.study.throwable.exception.ExceptionTest exceptionCatch
            //严重: 空指针异常
            //java.lang.NullPointerException
            //	at com.study.throwable.exception.ExceptionTest.exceptionCatch(ExceptionTest.java:25)
            //	at com.study.throwable.exception.ExceptionTest.main(ExceptionTest.java:18)
            //打印具体报错的类和位置
//            log.error("空指针异常",e);
            throw new RuntimeException("空指针异常");
//            System.out.println("NullException");
        }
//        Person person = null;
//        Person person1 = person;
//        person1.setAge(16);
    }

}
