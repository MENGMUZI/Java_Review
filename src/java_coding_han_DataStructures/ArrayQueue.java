package java_coding_han_DataStructures;

/**
 * @author : mengmuzi
 * create at:  2019-07-25  01:42
 * @description: 数组实现队列
 */
public class ArrayQueue {

    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize){
        maxSize = this.maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否已满
    public boolean isFull(){
        return  rear == maxSize -1;

    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据
    public void addQueue(int n){
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据~");
            return;
        }
        rear++; // 让 rear 后移
        arr[rear] = n;

    }

    // 获取队列的数据, 出队列
    public int getQueue() {
        // 判断队列是否空
        if (isEmpty()) {
        // 通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        front++; // front 后移
        return arr[front];
    }


}
