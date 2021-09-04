class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] squares = new int[len];
        int left = 0;
        int right = len - 1;
        for (int i = len - 1; i > -1 ; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                squares[i] = nums[left] * nums[left];
                left++;
            } else {
                squares[i] = nums[right] * nums[right];
                right--;
            }
        }
        return squares;
    }
}