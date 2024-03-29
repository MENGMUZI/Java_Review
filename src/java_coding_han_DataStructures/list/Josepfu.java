package java_coding_han_DataStructures.list;

/**
 * @author : mengmuzi
 * create at:  2019-07-26  10:58
 * @description: 约瑟夫环
 *
 */
public class Josepfu {
    public static void main(String[] args) {
        // 测试一把看看构建环形链表，和遍历是否 ok
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(125);// 加入 5 个小孩节点
        //circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(10,20,125);
    }


}
// 创建一个环形的单向链表
class CircleSingleLinkedList{
    // 创建一个 first 节点,当前没有编号
    private Boy first = null;

    // 添加小孩节点，构建成一个环形的链表
    public void addBoy(int nums){//环中所有小孩的数量
        if(nums < 1){
            System.out.println("nums 的值不正确");
            return;
        }
        Boy curBoy = null; // 辅助指针，帮助构建环形链表
        // 使用 for 来创建我们的环形链表
        for (int i = 1; i <= nums ; i++) {
            Boy boy = new Boy(i);
            if(i == 1){
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }

    }

    // 遍历当前的环形链表
    public void showBoy(){
        if(first == null){
            System.out.println("没有任何小孩~~");
            return;

        }
        // 因为 first 不能动，因此我们仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while(true){
            System.out.printf("小孩的编号 %d \n", curBoy.getNo());
            if(curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    // 根据用户的输入，计算出小孩出圈的顺序
    /**
     * @param startNo 表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums 表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums){
        // 先对数据进行校验
        if(startNo > nums || first == null || countNum <= 0){
            return;
        }
        // 创建要给辅助指针,帮助完成小孩出圈
        Boy helper = first;
        // 需求创建一个辅助指针(变量) helper , 事先应该指向环形链表的最后这个节点
        while(true){
            if(helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让 first 和 helper 移动 k - 1 次
        for (int i = 1; i <= startNo-1 ; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //当小孩报数时，让 first 和 helper 指针同时 的移动 m
        // 这里是一个循环操作，知道圈中只有一个节点
        while (true){
            if(helper == first){
                break;
            }
            //让 first 和 helper 指针同时 的移动 countNum - 1
            for (int i = 0; i <countNum -1 ; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时 first 指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d 出圈\n", first.getNo());
            //这时将 first 指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());
    }

}
class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }

}