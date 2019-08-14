package googlemaster;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author : mengmuzi
 * create at:  2019-08-14  16:45
 * @description: 链表反转
 */
public class LinkedListReverse {

    /**
     * @Description:
     * @Param head: the linked list to reverse
     * @return: head of the reversed linked list
     **/
    public Node reverseLinkedList(Node head) {
        //size == 0
        if (head == null) {
            return null;
        }
        //size == 1
        if (head.getNext() == null) {
            return head;
        }
        Node newHead = reverseLinkedList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }

    public static void main(String[] args) {

        LinkedListCreator creator = new LinkedListCreator();
        LinkedListReverse reverse = new LinkedListReverse();

        Node.printLinkedList(creator.createLinkedList(new ArrayList<>()));

        Node.printLinkedList(creator.createLinkedList(Arrays.asList(1)));

        Node.printLinkedList(creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5)));

        Node.printLinkedList(reverse.reverseLinkedList(creator.createLinkedList(new ArrayList<>())));

        Node.printLinkedList(reverse.reverseLinkedList(creator.createLinkedList(Arrays.asList(1))));

        Node.printLinkedList(reverse.reverseLinkedList(creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5))));


    }

}
