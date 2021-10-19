class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int cur = 1;
        int max = cur;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else if (nums[i] == nums[i - 1] + 1) {
                cur++;
            } else {
                cur = 1;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}