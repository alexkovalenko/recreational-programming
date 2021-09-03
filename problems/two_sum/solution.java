class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> table = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (table.containsKey(target - nums[i])) {
                return new int[] {table.get(target - nums[i]), i};
            } else {
                table.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}