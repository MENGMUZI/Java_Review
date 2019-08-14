package googlemaster;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author : mengmuzi
 * create at:  2019-08-14  20:35
 * @description: 链表反转，循环控制
 */
public class LinkedListReverseByLoop {

    public Node reverseLinkedListByLoop(Node head){
        Node newHead = null;
        Node curHead = head;
        while(curHead != null){
            Node next = curHead.getNext();
            curHead.setNext(newHead);
            newHead = curHead;
            curHead = next;
        }
        return newHead;
    }
    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();
        LinkedListReverseByLoop reverse = new LinkedListReverseByLoop();

        Node.printLinkedList(creator.createLinkedList(new ArrayList<>()));

        Node.printLinkedList(creator.createLinkedList(Arrays.asList(1)));

        Node.printLinkedList(creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5)));

        Node.printLinkedList(reverse.reverseLinkedListByLoop(creator.createLinkedList(new ArrayList<>())));

        Node.printLinkedList(reverse.reverseLinkedListByLoop(creator.createLinkedList(Arrays.asList(1))));

        Node.printLinkedList(reverse.reverseLinkedListByLoop(creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5))));

    }

}
