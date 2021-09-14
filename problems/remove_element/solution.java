class Solution {
    public int removeElement(int[] nums, int val) {
        int p = 0, count = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[p++] = nums[i];
            } else {
                count--;
            }
            
        }
        return count;
    }
}