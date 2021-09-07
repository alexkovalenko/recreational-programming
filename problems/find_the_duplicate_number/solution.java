class Solution {
    public int findDuplicate(int[] n) {
        int slow = n[0];
        int fast = n[0];
        while (true) {
            slow = n[slow];
            fast = n[n[fast]];
            if (slow == fast) 
                break;
        }
        
        int p1 = n[0];
        int p2 = slow;
        while (p1 != p2) {
            p1 = n[p1];
            p2 = n[p2];
        }
        return p1;
    }
}