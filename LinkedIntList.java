public class LinkedIntList{
    private ListNode front;
    private int size;

    // Constructs an empty list
    public LinkedIntList() {
        this(new int[0]);
    }

    // Constructs a list containing the given elements
    public LinkedIntList(int... elements) {
        if (elements.length > 0) {
            front = new ListNode(elements[0]);
            ListNode current = front;
            for (int i = 1; i < elements.length; i++) {
                current.next = new ListNode(elements[i]);
                current = current.next;
            }
            this.size = elements.length;
        }
    }

    // TODO: Implement add()
    public void add(int index, int val) {
        if(index < 0) {
            throw new IllegalArgumentException();
        }
        if(front == null) {
            front = new ListNode(val);
        } else if(index == 0) {
            front = new ListNode(0, front.next);
        } else {
            add(index, val, front, 1);
        }
    }

    private void add(int index, int val, ListNode curr, int currIndex) {
        if(currIndex == val || curr.next == null) {
            curr.next = new ListNode(val, curr.next);
            size ++;
        } else {
            add(index, val, curr.next, currIndex+1);
        }
    }

    // Returns the size of the list
    public int size() {
        return this.size;
    }

    // Returns a string representation of the current list
    @Override
    public String toString() {
        ListNode curr = front;
        String listStr = "[";
        while (curr != null) {
            listStr += curr.data;
            if (curr.next != null) {
                listStr += ", ";
            } 
            curr = curr.next;
        }
        return listStr += "]";
    }

    public static class ListNode {
        public int data;
        public ListNode next;

        public ListNode(int data) {
            this(data, null);
        }

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }
}