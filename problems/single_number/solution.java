class Solution {
    public int singleNumber(int[] nums) {
        int mask = 0;
        for(int n : nums) {
            mask ^= n;
        }
        return mask;
    }
}