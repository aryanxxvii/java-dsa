public class _01_SinglyLinkedLists {

    private Node head;
    private Node tail;

    private int size;

    public _01_SinglyLinkedLists() {
        this.size = 0;
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

    public void displayAll() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ---> ");
            temp = temp.next;
        }

        System.out.println("END");
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
}





