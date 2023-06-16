
public class dList {

    static Node head;
    static Node tail;

    static class Node {
        int value;
        Node next;
        Node prev;
    }

    public static void pushBack(int value) {
        Node node = new Node();
        node.value = value;

        if (tail == null) {
            head = node;
        } else {
            node.prev = tail;
            tail.next = node;
        }
        tail = node;

    }

    public void revert() {
        /*
         * Node node = head;
         * 
         * Node temp = head;
         * head = tail;
         * tail = temp;
         * 
         * while (node.next != null) {
         * temp = node.next;
         * node.next = node.prev;
         * node.prev = temp;
         * node = node.prev;
         */

        Node node = head;
        while (node != null) {
            Node next = node.next;
            Node prev = node.prev;
            node.next = prev;
            node.prev = next;
            if (prev == null) {
                tail = node;
            }
            if (next == null) {
                head = node;
            }
            node = next;
        }

    }

    public static void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        dList list = new dList();
        for (int i = 0; i <= 10; i++)
            list.pushBack(i);

        list.print();

        list.revert();

        list.print();

    }

}