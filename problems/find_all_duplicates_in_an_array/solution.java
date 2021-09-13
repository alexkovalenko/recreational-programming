class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for (int n : nums) {
            int index = Math.abs(n) - 1;
            if (nums[index] < 0) {
                duplicates.add(Math.abs(n));
            }
            nums[index] *= -1;
        }
        return duplicates;
    }
}