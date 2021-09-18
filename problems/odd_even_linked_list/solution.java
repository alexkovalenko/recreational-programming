/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode evenCur = head;
        ListNode oddHead = head.next;
        ListNode oddCur = head.next;
        while(evenCur.next != null || oddCur.next != null) {
            if (evenCur.next != null) {
                if (evenCur.next.next != null) {
                    evenCur.next = evenCur.next.next;
                    evenCur = evenCur.next;
                } else {
                    evenCur.next = null;
                }
            }
            if (oddCur.next != null) {
                if (oddCur.next.next != null) {
                    oddCur.next = oddCur.next.next;
                    oddCur = oddCur.next;
                } else {
                    oddCur.next = null;
                }
            }
        }
        evenCur.next = oddHead;

        return head;
    }
}