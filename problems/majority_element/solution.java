class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else {
                if (nums[i] == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return candidate;
    }
}