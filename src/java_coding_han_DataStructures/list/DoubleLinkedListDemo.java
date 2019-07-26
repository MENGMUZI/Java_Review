package java_coding_han_DataStructures.list;

/**
 * @author : mengmuzi
 * create at:  2019-07-26  10:11
 * @description: 双向链表
 */
class HeroNode02{
    public int no;
    public String name;
    public String nickname;
    public HeroNode02 next;
    public HeroNode02 pre;

    public HeroNode02(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }


    @Override
    public String toString() {
        return "HeroNode02{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

}
public class DoubleLinkedListDemo {

    private HeroNode02 head = new HeroNode02(0,"","");

    public HeroNode02 getHead() {
        return head;
    }

    // 遍历双向链表的方法
    // 显示链表[遍历]
    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }

        HeroNode02 temp = head.next;

        while (true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }

    // 添加一个节点到双向链表的最后.
    public void add(HeroNode02 heroNode){
        HeroNode02 temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }

        temp.next = heroNode;
        heroNode.pre = temp;
    }

    // 修改一个节点的内容, 可以看到双向链表的节点内容修改和单向链表一样
    // 只是 节点类型改成 HeroNode2
    //1. 根据 newHeroNode 的 no 来修改即可
    public void update(HeroNode02 heroNode){
        //判断是否空
        if(head.next == null){
            System.out.println("链表为空:");
            return;
        }
        //找到需要修改的节点, 根据 no 编号
        // 定义一个辅助变量
        HeroNode02 temp = head.next;
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

    // 从双向链表中删除一个节点,
    // 说明
    // 1 对于双向链表，我们可以直接找到要删除的这个节点
    // 2 找到后，自我删除即可
    public void del(int no){
        if(head.next == null){
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode02 temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            if(temp.no == no){
                temp.pre.next = temp.next;
                //如果是删除最后一个节点要判断
                if(temp.next != null){
                    temp.next.pre = temp.pre;
                }
                break;
            }
            temp = temp.next;
        }


    }

}
