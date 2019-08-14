package googlemaster;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author : mengmuzi
 * create at:  2019-08-14  21:14
 * @description: 链表中删除所有指定的元素(多看看这个很重要!!!!)
 */
public class LinkedListDeletor {

    public Node deleteIfEquals(Node head, int value) {

        while (head != null && head.getValue() == value) {
            head = head.getNext();
        }

        if (head == null) {
            return null;
        }

        Node prev = head;
        while (prev.getNext() != null) {
            if (prev.getNext().getValue() == value) {
                //delete it
                prev.setNext(prev.getNext().getNext());
            } else {
                prev = prev.getNext();
            }
        }
        return head;

    }

    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();
        LinkedListDeletor deletor = new LinkedListDeletor();

        Node.printLinkedList(creator.createLinkedList(new ArrayList<>()));

        Node.printLinkedList(creator.createLinkedList(Arrays.asList(1)));

        Node.printLinkedList(creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5)));

        Node.printLinkedList(deletor.deleteIfEquals(creator.createLinkedList(new ArrayList<>()), 1));

        Node.printLinkedList(deletor.deleteIfEquals(creator.createLinkedList(Arrays.asList(1, 1, 1, 1, 2)), 1));

        Node.printLinkedList(deletor.deleteIfEquals(creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 1)), 1));


    }
}
