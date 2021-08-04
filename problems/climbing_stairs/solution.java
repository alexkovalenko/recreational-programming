class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int n1 = 1;
        int n2 = 2;
        for (int i = 3; i < n + 1; i++) {
            n2 = n2 + n1;
            n1 = n2 - n1;
        }
        return n2;    
    }
}