class Solution {
    public int[] sortedSquares(int[] nums) {
        return Arrays.stream(nums)
            .map(n -> n * n)
            .sorted()
            .toArray();
    }
}