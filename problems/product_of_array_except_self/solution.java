class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] result = new int[l];
        Arrays.fill(result, 1);
        for (int i = 1; i < l; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        int right = 1;
        for(int i = l - 1; i > -1; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }
}