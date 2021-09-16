class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0, count = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            } else {
                count++;
            }
        }
        
        for (int e = nums.length - 1; e > nums.length - count - 1; e--) {
            nums[e] = 0;
        }
    }
}