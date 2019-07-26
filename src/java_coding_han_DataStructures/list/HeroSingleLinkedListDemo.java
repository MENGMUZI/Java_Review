package java_coding_han_DataStructures.list;


/**
 * @author : mengmuzi
 * create at:  2019-07-25  22:08
 * @description: 水浒英雄排名榜,单向链表
 */
//定义 HeroNode ， 每个 HeroNode 对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

//定义 SingleLinkedList 管理我们的英雄
public class HeroSingleLinkedListDemo {

    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    // 思路，当不考虑编号顺序时
    //1. 找到当前链表的最后节点
    //2. 将最后这个节点的 next 指向 新的节点
    public void add(HeroNode heroNode){
        //因为 head 节点不能动，因此我们需要一个辅助变量 temp
        HeroNode temp = head;

        //遍历链表，找到最后
        while (true){
            //找到链表的最后
            if(temp.next == null){
                break;
            }
            //如果没有找到最后, 将 temp 后移
            temp = temp.next;

        }
        //当退出 while 循环时，temp 就指向了链表的最后
        // 将最后这个节点的 next 指向 新的节点
        temp.next = heroNode;
    }


    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    // (如果有这个排名，则添加失败，并给出提示)
    public void addByOrder(HeroNode heroNode){
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        // 因为单链表，因为我们找的 temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false; //flag添加编号是否存在，默认为false；
        while(true){
            if(temp.next == null){//说明 temp 已经在链表的最后
                break;
            }
            if(temp.next.no > heroNode.no){//位置找到，就在 temp 的后面插入
                break;
            }else if(temp.next.no == heroNode.no){ //说明希望添加的 heroNode 的编号已然存在
                flag = true; //说明编号存在
                break;
            }
            temp = temp.next; //后移，遍历当前链表
        }

        //判断 flag 的值
        if(flag) {
            //不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        } else {
            //插入到链表中, temp 的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    //修改节点的信息, 根据 no 编号来修改，即 no 编号不能改.
    //说明
    //1. 根据 newHeroNode 的 no 来修改即可
    public void update(HeroNode heroNode){
        //判断是否空
        if(head.next == null){
            System.out.println("链表为空:");
            return;
        }
        //找到需要修改的节点, 根据 no 编号
        // 定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;
        while(true){
            if(temp == null){//遍历完了链表
                break;
            }
            if(temp.no == heroNode.no){
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }

        //根据 flag 判断是否找到要修改的节点
        if(flag) {
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        } else { //没有找到
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", heroNode.no);
        }

    }



    //显示链表[遍历]
    public void list(){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true){
            //判断是否到链表最后
            if(temp == null){
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将 temp 后移， 一定小心
            temp = temp.next;
        }
    }

    //删除节点
    //思路
    //1. head 不能动，因此我们需要一个 temp 辅助节点找到待删除节点的前一个节点
    //2. 说明我们在比较时，是 temp.next.no 和 需要删除的节点的 no 比较
    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        //判断flag
        if(flag) {
            //找到
            //可以删除
            temp.next = temp.next.next;

        }else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }

    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给链表
        HeroSingleLinkedListDemo list = new HeroSingleLinkedListDemo();
//        list.add(hero1);
//        list.add(hero4);
//        list.add(hero3);
//        list.add(hero2);

        ////加入按照编号的顺序
        list.addByOrder(hero1);
        list.addByOrder(hero4);
        list.addByOrder(hero3);
        list.addByOrder(hero2);
        list.list();

        System.out.println("========================================================");

        //测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        list.update(newHeroNode);
        list.list();

        System.out.println("========================================================");
        list.del(4);
        list.list();

        //计算链表的节点个数
        System.out.println("========================================================");
        int length = ListInterview.getLength(list.getHead());
        System.out.println("链表长度：" + length);

        //单链表倒数第k个节点
        System.out.println("========================================================");
        HeroNode result = ListInterview.findLastIndexNode(list.getHead(),2);
        System.out.println(result);

        //反转链表
        System.out.println("========================================================");
        ListInterview.reverseList(list.getHead());
        list.list();

        //反向打印链表
        System.out.println("========================================================");
        ListInterview.reversePrint(list.getHead());



    }

}
