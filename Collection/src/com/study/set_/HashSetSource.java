package com.study.set_;

import java.util.HashSet;
import java.util.Set;

public class HashSetSource {

    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        hashSet.add("java");
        hashSet.add("php");
        hashSet.add("java");
        System.out.println("set=" + hashSet);

        /*
        * 源码解析
        * 1.执行 HashSet()
        * public HashSet() {
        *   map = new HashMap<>();
        * }
        * 2.执行add()
        * public boolean add(E e) {//e = "java"
        *   return map.put(e, PRESENT)==null;//(static) Object PRESENT = new Object();
        * }
        * 3.执行put(),该方法会执行hash(key)得到key对应的hash值 算法h = key.hashCode()) ^ (h >>> 16
        * public V put(K key, V value) {//key = "java" value=PRESENT 共享
        *   return putVal(hash(key), key, value, false, true);
        * }
        * 4.执行 putVal
        * final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
            Node<K,V>[] tab; Node<K,V> p; int n, i;//定义了辅助变量
            //table就是HashMap的一个数组，类型是Node[]
            //if语句代表如果当前table为null 或者 大小为0
            //就是第一次扩容，到16个空间
            if ((tab = table) == null || (n = tab.length) == 0)
                n = (tab = resize()).length;
            //(1)根据key，得到hash去计算该key应该存放到table表的哪个索引位置
            //并把这个位置的对象，赋给p
            //(2)判断p是否为null
            //(2.1)如果p为null，表示还没有存放元素，就创建一个Node (key="java",value=PRESENT)
            //(2.2)就放在位置tab[i] = newNode(hash, key, value, null);
            if ((p = tab[i = (n - 1) & hash]) == null)
                tab[i] = newNode(hash, key, value, null);
            else {
                Node<K,V> e; K k;
                //如果当前索引位置对应的链表的第一个元素和准备添加的元素的hash值一样
                //并且满足 下面两个条件之一：
                //(1)准备加入的key和p指向的Node结点的key是同一个对象
                //(2)p指向的Node结点的key的equals()和准备加入的key比较后相同
                //就不能加入
                if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))
                    e = p;
                //再判断p是不是一棵红黑树
                //如果是一棵红黑树，就调用putTreeVal，来进行添加
                else if (p instanceof TreeNode)
                    e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                else {//如果table对应索引位置，已经是应该链表，就使用for循环比较
                      //(1)依次和该链表的每个元素比较后，都不相同，则加入到该链表的最后
                      //   注意再把元素添加到链表后，立即判断该链表是否已经达到8个结点
                      //   ,达到8个结点就调用treeifyBin()对这个链表进行树化(转成红黑树)
                      //   注意，在转成红黑树前，要进行判断，如果该table数组小于64或table为空,先进行table扩容
                      *         if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
                      *             resize();
                      *     只有上面条件不成立，才进行红黑树转换
                      //(2)依次和该链表的每个元素比较过程中，如果有相同情况，就直接break
                    for (int binCount = 0; ; ++binCount) {
                        if ((e = p.next) == null) {
                            p.next = newNode(hash, key, value, null);
                            if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                treeifyBin(tab, hash);
                            break;
                        }
                        if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                            break;
                        p = e;
                    }
                }
                if (e != null) { // existing mapping for key
                    V oldValue = e.value;
                    if (!onlyIfAbsent || oldValue == null)
                        e.value = value;
                    afterNodeAccess(e);
                    return oldValue;
                }
            }
            ++modCount;
            //size 就是我们每加入一个结点Node(k,v,h,next)(无论是数组还是是链表上的结点)，size++
            if (++size > threshold)
                resize();
            afterNodeInsertion(evict);
            return null;
        }
        * */


    }

}
