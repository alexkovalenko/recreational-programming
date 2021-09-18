class MyLinkedList {

    ListNode head;
    int length;

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    public String toString() {
        ListNode node = head;
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.val);
            builder.append("->");
            node = node.next;
        }
        return builder.toString();
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        ListNode node = head;
        int cur = 0;
        while (cur != index && node != null) {
            cur++;
            node = node.next;
        }
        return node != null ? node.val : -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
        length++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
        } else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
        length++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {

        if (length == index) {
            this.addAtTail(val);
        } else if (index < length) {
            ListNode prev = null;
            ListNode node = head;
            int cur = 0;
            while (cur < index) {
                cur++;
                prev = node;
                node = node.next;
            }
            ListNode newNode = new ListNode(val);
            if (prev == null) {
                newNode.next = node;
                head = newNode;
            } else {
                newNode.next = node;
                prev.next = newNode;
            }

            length++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index + 1 <= length) {
            ListNode node = head;
            ListNode prev = null;
            int cur = 0;
            while (cur < index) {
                cur++;
                prev = node;
                node = node.next;
            }
            if (prev != null) {
                prev.next = node.next;
            } else {
                head = node.next;
            }

            length--;
        }
    }
}