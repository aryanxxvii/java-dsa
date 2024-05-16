public class _01_SinglyLinkedLists {

    private Node head;
    private Node tail;

    private int size;

    public _01_SinglyLinkedLists() {
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node next;

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
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }

        size += 1;
    }

    public void insertLastWithHead(int value) {

        if (head == null) {
            insertFirst(value);
            return;
        }

        Node node = new Node(value);
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = node;
        size += 1;

        tail = node;
    }

    public void insertLastWithTail(int value) {

        if (tail == null) {
            insertFirst(value);
            return;
        }

        Node node = new Node(value);
        tail.next = node;
        tail = node;

        size += 1;
    }

    public void insertAt(int value, int index) {
        if (index >= size) {
            insertLastWithHead(value);
            return;
        }


        Node node = new Node(value);
        Node track = head;
        for (int i = 0; i < index; i++) {
            track = track.next;
        }

        // Now 'track' is node at index N

//        System.out.println("VALUE IS "+ track.value);

        Node temp_next = track.next;

        track.next = node;
        node.next = temp_next;
    }

    public void deleteFirst() {
        if (size == 0) {
            tail = null;
        }

        head = head.next;

        size--;
    }

    public void deleteLastWithHead() {

        if (size <= 1) {
            deleteFirst();
            return;
        }

        Node track = head;
        for (int i = 0; i < size - 1; i++) {
            track = track.next;
        }

        // Now 'track' is second last element
        track.next = null;
        tail = track;
        size--;
    }

    public void deleteLastWithTail() {
        // Can't do in singly linked list because no track of previous element (in this case, previous of tail)
    }

    public void deleteAt(int index) {
        if (index == 0) {
            deleteFirst();
            return;
        }

        if ( index == size-1) {
            deleteLastWithHead();
            return;
        }

        Node prevToDelete = new Node(0);
        Node nextToDelete;
        Node track = head;

        for (int i = 0; i < index + 1; i++) {
            if (i == index - 1) {
                prevToDelete = track;
            }
            track = track.next;
        }

        nextToDelete = track;

        prevToDelete.next = nextToDelete;
    }

    public void displayAll() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ---> ");
            temp = temp.next;
        }

        System.out.println("END");
    }


}





