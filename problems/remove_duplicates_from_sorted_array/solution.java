class Solution {
    public int removeDuplicates(int[] nums) {
        int p = 1, count = nums.length;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[p++] = nums[i];
            } else {
                count--;    
            }
        }
        return count;
    }
}