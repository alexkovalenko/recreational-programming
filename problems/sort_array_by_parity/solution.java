class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] sorted = new int[nums.length];
        int evenIndex = 0, oddIndex = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            int e = nums[i];
            sorted[e % 2 == 0 ? evenIndex++ : oddIndex--] = e;
        }
        return sorted;
    }
}