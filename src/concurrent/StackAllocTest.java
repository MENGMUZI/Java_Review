package concurrent;

/**
 * @author : mengmuzi
 * create at:  2019-08-14  02:14
 * @description: 逃逸现象
 */

import java.util.concurrent.TimeUnit;

/**
 * 进行2种测试：
 *      关闭逃逸分析，同时调大堆空间避免GC的发生，如果有GC信息会被打印出来
 *      VM运行参数：-Xmx4G -Xms4G -XX:-DoEscapeAnalysis -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
 *
 *      关闭逃逸分析，同时调大堆空间避免GC的发生，如果有GC信息会被打印出来
 *      VM运行参数：-Xmx4G -Xms4G -XX:+DoEscapeAnalysis -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
 *
 *      jps查看进程
 *      jmap -histo 进程ID 查看对应的内存分配
 * */
public class StackAllocTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("cost-time\t" + (double)(end-start)/1000 + "s");
        try{
            TimeUnit.MILLISECONDS.sleep(30000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    private static void alloc(){
        Student student = new Student();
    }

    static class Student{
        private String name;

        private int age;
    }
}



