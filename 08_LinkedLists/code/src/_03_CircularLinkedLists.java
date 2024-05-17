public class _03_CircularLinkedLists {

    private int size;
    private Node head;
    private Node tail;

    public _03_CircularLinkedLists() {
        this.size = 0;
    }

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        if (size == 0) {
            head = node;
            tail = node;
            tail.next = head;
            size++;
            return;
        }

        node.next = head;
        head = node;
        tail.next = head;

        size++;
    }

    public void insertLast(int value) {
        Node node = new Node(value);
        if (size == 0) {
            insertFirst(value);
            size++;
            return;
        }

        tail.next = node;
        tail = node;
        node.next = head;
        size++;
    }

    public void deleteFirst() {
        if (size == 1) {
            tail = null;
            head = null;
        }
        if (size > 1) {
            tail.next = head.next;
            head = head.next;
        }
        size--;
    }

    public void displayAll() {
        Node node = head;
        if (size == 1) {
            System.out.print(node.value);
        }

        while (node != tail) {
            System.out.print(node.value + " --> ");
            node = node.next;
        }

        // when node is tail
        System.out.print(node.value + " --> ");

        System.out.println("END");
    }

}
