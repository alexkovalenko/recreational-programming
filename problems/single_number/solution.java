class Solution {
    public int singleNumber(int[] nums) {
        /*Arrays.sort(n);
        for (int i = 0; i < n.length - 1; i++) {
            if (i == 0 && n[i] != n[i + 1]) {
                return n[i];
            }    
            if (i > 0 && n[i] != n[i - 1] && n[i] != n[i + 1]) {
                return n[i];
            }
        }
        return n[n.length - 1];*/
        int mask = 0;
        for(int n : nums) {
            mask ^= n;
        }
        return mask;
    }
}