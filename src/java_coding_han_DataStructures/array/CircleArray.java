package java_coding_han_DataStructures.array;

/**
 * @author : mengmuzi
 * create at:  2019-07-25  21:38
 * @description: 环形队列
 */
public class CircleArray {

    private int maxSize; // 表示数组的最大容量
    //front 变量的含义做一个调整: front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
    // front 的初始值 = 0

    private int front;

    //rear 变量的含义做一个调整:rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
    // rear 的初始值 = 0
    private int rear;

    private int[] arr;

    public CircleArray(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    // 判断队列是否满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空
    public boolean isEmpty(){
        return rear == front;

    }

    // 添加数据到队列
    public void addQueue(int n){
        // 判断队列是否满
        if(isFull()){
            System.out.println("队列满，不能加入数据");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //将 rear 后移, 这里必须考虑取模
        rear = (rear + 1) % maxSize;

    }

    // 获取队列的数据, 出队列
    public int getQueue(){
        if(isEmpty()){
            // 通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        // 这里需要分析出 front 是指向队列的第一个元素
        // 1. 先把 front 对应的值保留到一个临时变量
        // 2. 将 front 后移, 考虑取模
        // 3. 将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;

    }

    // 求出当前队列有效数据的个数
    public int size() {
        // rear = 2
        // front = 1
        // maxSize = 3
        return (rear + maxSize - front) % maxSize;
    }


}
