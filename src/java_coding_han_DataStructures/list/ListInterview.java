package java_coding_han_DataStructures.list;

import java.util.Stack;

/**
 * @author : mengmuzi
 * create at:  2019-07-26  00:39
 * @description: 链表的面试题
 */
public class ListInterview {

    //1) 求单链表中有效节点的个数
    //方法:获取到单链表的节点的个数(如果是带头结点的链表，需求不统计头节点)
    /**
     *  @param head 链表的头节点
     *  @return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head){
        if(head.next == null){
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null){
            length ++;
            cur = cur.next;
        }
        return length;
    }



    //2) 查找单链表中的倒数第k个结点【新浪面试题】
    //思路
    //1. 编写一个方法，接收 head 节点，同时接收一个 index
    //2. index 表示是倒数第 index 个节点
    //3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
    //4. 得到 size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
    //5. 如果找到了，则返回该节点，否则返回 null
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        if(head.next == null){
            return null;
        }
        //遍历链表得到长度
        int size = getLength(head);
        //下一次遍历到 size-index
        if(index <= 0 || index > size){
            return null;

        }
        HeroNode cur = head.next;
        for (int i = 0; i <size-index ; i++) {
            cur = cur.next;
        }
        return cur;

    }

    //3) 单链表的反转【腾讯面试题，有点难度】
    public static void reverseList(HeroNode head){
        if(head.next == null || head.next.next == null){
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0,"","");

        while(cur != null){
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;

        }
        head.next = reverseHead.next;

    }

    //4) 从尾到头打印单链表【百度，要求方式1:反向遍历。方式2:Stack栈】
    public static void reversePrint(HeroNode head){
        if(head == null){
            return;
        }
        HeroNode cur = head.next;
        Stack<HeroNode> stack = new Stack<>();

        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }


}
