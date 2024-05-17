public class _01_SinglyLinkedLists {

    /*

        ================== INITIALIZATIONS ==================

     */

    public Node head;
    public Node tail;

    public int size;

    public _01_SinglyLinkedLists() {
        this.size = 0;
    }

    public class Node {
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

    /*

        ================== QUESTIONS ==================

     */

    // TODO: Merge Sort
    // TODO: Bubble Sort
    // TODO: Reverse Linked-list between 2 nodes
    // TODO: Check Palindrome
    // TODO: Reorder Linked List
    // TODO: Reverse in K-Group
    // TODO: Rotate List

    // Insert Recursively
    public void insertRec(int value, int index, Node prev) {
        Node next_call;
        // Check if it's the first call
        if (prev == null) {
            next_call = head;
        } else {
            next_call = prev.next;
        }

        if (index == 0) {
            // Reached the index where we need to add node
            Node node = new Node(value);
            if (prev != null) {
                // Check if it's the first call
                node.next = prev.next;
                prev.next = node;
                size++;
            } else {
                insertFirst(value);
            }
            return;
        }

        // prev.next == current node
        insertRec(value, index-1, next_call);
    }

    // Remove Duplicates from sorted linked list
    public void removeDuplicatesSorted() {

        // Length of the linked list will be >= 3

        Node track = head;
        while (track != null && track.next != null) {
            if (track.value == track.next.value) {
                if (track.next.next != null) {
                    track.next = track.next.next;
                } else {
                    track.next = tail;
                }
                size--;
            } else {
                track = track.next;
            }
        }
    }

    // Merge two sorted linked lists
    public void mergeTwoSorted(_01_SinglyLinkedLists first, _01_SinglyLinkedLists second) {
        Node firstTrack = first.head;
        Node secondTrack = second.head;

        _01_SinglyLinkedLists merged = new _01_SinglyLinkedLists();

        while (firstTrack != null && secondTrack != null) {
            if (firstTrack.value < secondTrack.value) {
                merged.insertLastWithHead(firstTrack.value);
                firstTrack = firstTrack.next;
            } else {
                merged.insertLastWithHead(secondTrack.value);
                secondTrack = secondTrack.next;
            }
        }

        while (firstTrack != null) {
            merged.insertLastWithHead(firstTrack.value);
            firstTrack = firstTrack.next;
        }

        while (secondTrack != null) {
            merged.insertLastWithHead(secondTrack.value);
            secondTrack = secondTrack.next;
        }
    }

    // Check for loop : FAST & SLOW POINTER
    public boolean hasCycle() {
        // fast pointer -> moves 2 places at once
        // slow pointer -> moves 1 place at once
        // If fast & slow pointers meet, there is a loop

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // Find the length of cycle
    public int cycleLength() {
        // When slow == fast, make slow pointer do the whole cycle again and count

        Node fast = head;
        Node slow = head;
        int count = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                do {
                    slow = slow.next;
                    count++;
                } while (slow != fast);
            }
        }
        return count;
    }

    // Find node where cycle begins
    public Node cycleStart() {
        // Apply fast-slow pointer approach
        // The point where they collide will be exactly as far from the start of the loop, as the loop is from the head
        // So take a new pointer 'track', and place it at head
        // Move track and slow pointer by 1 place each till they collide
        // The point where they will collide will be the start of the loop

        Node slow = head;
        Node fast = head;
        Node track = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                track = head;
                while (track != slow) {
                    track = track.next;
                    slow = slow.next;
                }
            }
        }
        return track;
    }

    // Happy Number
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);

        return slow == 1;
    }
    private int findSquare(int n) {
        int ans = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            ans += lastDigit*lastDigit;
            n = n / 10;
        }

        return ans;
    }

    // Middle of Linked List
    public Node findMiddle(Node start) {
        // Make speed of fast 2x of slow
        // By the time fast reaches end, slow would have reached middle

        Node slow = start;
        Node fast = start;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Recursive Reversing Linked List
    public void reverseRec(Node node) {
        if (node == tail) {
            head = tail;
            return;
        }

        reverseRec(node.next);
        // point tail to prev element
        tail.next = node;
        // move tail to prev element
        tail = node;
        // remove next of prev element
        tail.next = null;
    }

    // Iterative Reversing Linked List
    public void reverseList() {
        // Take 3 pointers, prev, pres, next
        // Use them to reverse 'pres'

        if (size < 2) {
            return;
        }

        Node prev = null;
        Node present = head;
        Node next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;

            if (next != null) {
                next = next.next;
            }
        }
        head = prev;
    }

    // Check if palindromic linked list
    public void checkPalindrome() {
        // Find middle element
        // Reverse from middle to tail
        // Check from head -> middle && middle -> end
        // After checking, reverse it back
        // ! Requires: Reverse Between Nodes
    }

    // Reorder Linked List
    public void reorder() {
        //  GIVEN:      1 -> 2 -> 3 -> 4 -> 5
        //  ANSWER:     1 -> 5 -> 2 -> 4 -> 3

        // Find middle element and reverse from middle to tail
    }



    /*

        ================== BASICS ==================

     */

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





