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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }        
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
//         if (head == null) {
//             return null;
//         }
        
//         Deque<ListNode> stack = new ArrayDeque<>();
//         while (head != null) {
//             stack.push(head);
//             head = head.next;
//         }
        
//         ListNode first = head = stack.pop();
//         while(!stack.isEmpty()) {
//             ListNode next = stack.pop();
//             head.next = next;
//             head = next;
//         }
        
//         head.next = null;
        
//         return first;
    }
}