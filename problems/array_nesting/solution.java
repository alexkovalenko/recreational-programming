class Solution {
    public int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MAX_VALUE) 
                continue;
            int current = nums[i], count = 0;
            while(nums[current] != Integer.MAX_VALUE) {
                int tmp = current;
                current = nums[current];
                count++;
                nums[tmp] = Integer.MAX_VALUE;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}