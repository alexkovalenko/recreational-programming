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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode middle = middleNode(head);
        ListNode reversed = reverseList(middle);
                
        while (reversed != null) {
            if (reversed.val != head.val) {
                return false;
            }
            reversed = reversed.next;
            head = head.next;
        }       
        
        return true;
    }
    
    private ListNode middleNode(ListNode head) {
        var fast = head;
        var slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        } 
        return slow;
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}