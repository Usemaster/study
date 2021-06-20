package com.study.queue;

public class LinkQueue<T> {

    public class Node<T> {
        // 存储的数据
        private T data;
        // 下一个节点的引用
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

    }

    // 队头
    private Node<T> front;
    // 队尾
    private Node<T> rear;
    // 元素个数
    private int size;

    /**
     * 创建队列
     */
    public LinkQueue() {
        rear = front = null;
    }

    /**
     * 入队列
     *
     * @param data
     */
    public void enQueue(T data) {
        Node<T> node = new Node<T>(data);
        if (isEmpty()) {
            front = rear = node;
        } else {
            rear.setNext(node);
            rear = node;
        }

        size++;
    }

    /**
     * 出队列
     *
     * @return 返回数据
     */
    public T deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }

        Node<T> delete = front;
        front = delete.getNext();
        delete.setNext(null);; // help GC
        size--;

        if (size == 0) {
            // 删除掉最后一个元素时，front值已经为null，但rear还是指向该节点，需要将rear置为null
            // 最后一个结点front和rear两个引用都没指向它，帮助GC处理该节点对象
            rear = front;
        }

        return (T) delete.getData();
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return (front == null && rear == null) ? true : false;
    }

    /**
     * 获取队列的元素个数
     * @return
     */
    public int size() {
        return this.size;
    }


    public static void main(String[] args) {
        LinkQueue<Integer> queue = new LinkQueue<Integer>();

        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);

        System.out.println("size：" + queue.size());

        System.out.println("出队列：" + queue.deQueue());
        System.out.println("出队列：" + queue.deQueue());
        System.out.println("出队列：" + queue.deQueue());
        System.out.println("出队列：" + queue.deQueue());

        System.out.println("删完重新添加==============");
        queue.enQueue(11);
        queue.enQueue(22);
        queue.enQueue(33);
        queue.enQueue(44);

        System.out.println("size：" + queue.size());

        System.out.println("出队列：" + queue.deQueue());
        System.out.println("出队列：" + queue.deQueue());
        System.out.println("出队列：" + queue.deQueue());
        System.out.println("出队列：" + queue.deQueue());
    }

}
