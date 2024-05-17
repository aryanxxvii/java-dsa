public class _02_DoublyLinkedLists {

    private Node head;
    private Node tail;

    private int size;

    public _02_DoublyLinkedLists() {
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        node.prev = null;

        if (size == 0) {
            head = node;
            tail = node;
            size++;
            return;
        }

        if (head != null) {
            // Change prev for past head from 'null' to 'node' : create backlink
            head.prev = node;
        }

        head = node;

        size++;
    }

    public void insertLast(int value) {
        if (size == 0) {
            insertFirst(value);
            return;
        }

        Node node = new Node(value);
        if (tail != null) {
            tail.next = node;
        }
        node.prev = tail;
        tail = node;

        size++;
    }

    public void insertAt(int value, int index) {
        Node temp = head;
        Node node = new Node(value);
        if (index == 0) {
            insertFirst(value);
            return;
        }

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        // Now temp is at index element
        temp.prev.next = node;
        node.next = temp;

        size++;
    }

    public void displayAll() {
        Node track = head;
        while (track != null) {
            System.out.print(track.value + " --> ");
            track = track.next;
        }

        System.out.println("END");
    }

    public void displayReverseAll() {
        Node track = tail;
        while (track != null) {
            System.out.print(track.value + " --> ");
            track = track.prev;
        }

        System.out.println("START");
    }


}
