class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxNum = 0;
        int currentNum = 0;
        if (nums != null) {
            for(int n : nums) {
                if (n == 1) {
                    currentNum++;
                } else if (n == 0) {
                    maxNum = Math.max(maxNum, currentNum);
                    currentNum = 0;
                }
            } 
            maxNum = Math.max(maxNum, currentNum);
        }
        return maxNum;
    }
}