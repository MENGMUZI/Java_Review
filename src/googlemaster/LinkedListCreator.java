package googlemaster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : mengmuzi
 * create at:  2019-08-14  15:50
 * @description: 创建一个链表
 */
class Node {
    private final int value;
    private Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.getValue()+"\t");
            head = head.getNext();
        }
        System.out.println();
    }
}

public class LinkedListCreator {
    /**
     * @Description:
     * @Param data: the data to create the list
     * @return: firstNode
     **/
    public Node createLinkedList(List<Integer> data) {
        if (data.isEmpty()) {
            return null;
        }
        Node firstNode = new Node(data.get(0));//data maybe empty
        Node headOfSublist = createLinkedList(data.subList(1, data.size()));//only one on the list
        firstNode.setNext(headOfSublist);
        return firstNode;
    }

    public static void main(String[] args) {

        LinkedListCreator creator = new LinkedListCreator();

        Node.printLinkedList(creator.createLinkedList(new ArrayList<>()));

        Node.printLinkedList(creator.createLinkedList(Arrays.asList(1)));

        Node.printLinkedList(creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5)));


    }

}
