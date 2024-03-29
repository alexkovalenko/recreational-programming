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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode cur = sentinel;
        int remainder = 0;
        while (l1 != null || l2 != null) {
            int sum = remainder;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
                
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            remainder = sum / 10;
        }
        
        if (remainder > 0) {
            cur.next = new ListNode(remainder);
        }
        
        return sentinel.next;
    }
}