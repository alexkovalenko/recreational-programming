class Solution {
    public int findNumbers(int[] nums) {
        int numberOfEvens = 0;
        
        if (nums != null) {
            for (int n : nums) {
                if (hasEvenNumberOfDigits(n)) {
                    numberOfEvens ++;
                }
            }
        }
        
        return numberOfEvens;
    }
    
    private boolean hasEvenNumberOfDigits(int n) {
        int numberOfDigits = 1;
        while((n = n /10) > 0) {
            numberOfDigits++;
        }
        return numberOfDigits % 2 == 0;
    }
}