package com.demo.com.usemaster.oom;/**
 * @author gongwj
 * @Date 2022/1/12
 */

/**
 * @author gongwj
 * @Date 2022/1/12
 */

import java.util.ArrayList;
import java.util.List;

/**
 * VM参数： -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * Java堆溢出
 * Java堆用于储存对象实例，只要不断创建不可被回收的对象，比如静态对象，那么随着对象数量的增加，总容量触及最大堆的容量限制后就会产生内存溢出异常（OutOfMemoryError）。
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }
    }

}
